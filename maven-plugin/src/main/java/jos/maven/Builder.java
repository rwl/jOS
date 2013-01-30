package jos.maven;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import jos.maven.types.Architecture;
import jos.maven.types.BuildError;
import jos.maven.types.Platform;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Builder {
	
    private static final Logger logger = Logger.getLogger(Builder.class.getName());

    public static void build(final Configuration config, final Platform platform) {

        final List<Architecture> archs = config.getArchs().get(platform);
        final File clang = config.locateCompiler(platform, "clang");
        final File buildDir = config.getVersionedBuildDir(platform);
        final File objsBuildDir = new File(buildDir, "objs");
        objsBuildDir.mkdirs();

        final Buildlet buildlet = new Buildlet() {

            @Override
            public File build(final File path) {
                final File obj = new File(objsBuildDir, FilenameUtils.removeExtension(path.getName()) + ".o");
                final boolean shouldRebuild = (!obj.exists()
                        || path.lastModified() > obj.lastModified());

                if (shouldRebuild) {
                    logger.info("Compiling: " + path);
                    obj.getParentFile().mkdirs();
                    final List<File> archObjs = Lists.newArrayList();
                    for (final Architecture arch : archs) {
                        // Object.
                        final File archObj = new File(objsBuildDir, FilenameUtils.removeExtension(path.getName()) + '-' + arch.getArch() + ".o");                       
                        sh(clang + config.getCFlags(platform, false, true)
                        		+ " -arch " + arch.getArch()
                        		+ " -c " + path
                        		+ " -o " + archObj);

                        archObjs.add(archObj);
                    }

                    // Assemble fat binary.
                    final String archObjsList = StringUtils.join(archObjs, " ");
                    sh("/usr/bin/lipo -create " + archObjsList + " -output " + obj + "");
                }

                return obj;
            }
        };

        // Create builders.
        int buildersCount;
        if (System.getenv().containsKey("jobs")) {
            buildersCount = Integer.valueOf(System.getenv().get("jobs"));
        } else {
            buildersCount = Integer.valueOf(sh("/usr/sbin/sysctl -n machdep.cpu.thread_count").trim());
        }
        if (buildersCount < 1) {
            buildersCount = 1;
        }
        final List<List<File>> builderQueues = Lists.newArrayList();
        final List<Runnable> builderThreads = Lists.newArrayList();
        for (int i = 0; i < buildersCount; i++) {
            final List<File> queue = Lists.newArrayList();
            final Runnable th = new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                    final List<File> objs = Lists.newArrayList();
                    while (queue.size() > 0) {
                        final File path = queue.remove(0);
                        objs.add(buildlet.build(path));
                    }
                    queue.addAll(objs);
                }
            };
            builderQueues.add(queue);
            builderThreads.add(th);
        }

        // Feed builders with work.
        int builder_i = 0;
        for (final File path : config.getOrderedBuildFiles()) {
            builderQueues.get(builder_i).add(path);
            builder_i += 1;
            if (builder_i == buildersCount) {
                builder_i = 0;
            }
        }

        // Start build.
        for (int i = 0; i < buildersCount; i++) {
            final Runnable th = builderThreads.get(i);
            th.run();
            //new Thread(th).start();
        }

        // Merge the result (based on build order).
        final List<File> objs = Lists.newArrayList();
        builder_i = 0;
        for (@SuppressWarnings("unused") final File path : config.getOrderedBuildFiles()) {
            objs.add(builderQueues.get(builder_i).remove(0));
            builder_i += 1;
            if (builder_i == buildersCount) {
                builder_i = 0;
            }
        }

        // Prepare bundle.
        final File bundlePath = config.getAppBundle(platform);
        if (!bundlePath.exists()) {
            logger.info("Creating: " + bundlePath);
            bundlePath.mkdirs();
        }

        // Link executable.
        final File mainExec = config.getAppBundleExecutable(platform);
        boolean mainExecCreated = false;
        boolean modified = false;
        for (final File path : objs) {
            if (path.lastModified() > mainExec.lastModified()) {
                modified = true;
                break;
            }
        }
        if (!mainExec.exists()
                || config.getProjectFile().lastModified() > mainExec.lastModified()
                || modified) {
        	logger.info("Linking: " + mainExec);
            final String objsList = StringUtils.join(objs, " ");
            final String frameworks = StringUtils.join(Lists.transform(config.getFrameworksDependencies(), new Function<String, String>() {
                public String apply(final String x) {
                    return "-framework " + x;
                }
            }), " ");
            sh(clang + " -o " + mainExec
            		+ " " + objsList
            		+ " " + config.getLdFlags(platform)
            		+ " " + frameworks);
            mainExecCreated = true;
        }

        // Create bundle/Info.plist.
        final File bundleInfoPlist = new File(bundlePath, "Info.plist");
        if (!bundleInfoPlist.exists() || config.getProjectFile().lastModified() > bundleInfoPlist.lastModified()) {
            logger.info("Creating: " + bundleInfoPlist);
            write(bundleInfoPlist, config.getInfoPlistData());
            sh("/usr/bin/plutil -convert binary1 \"" + bundleInfoPlist + "\"");
        }

        // Create bundle/PkgInfo.
        final File bundlePkgInfo = new File(bundlePath, "PkgInfo");
        if (!bundlePkgInfo.exists() || config.getProjectFile().lastModified() > bundlePkgInfo.lastModified()) {
            logger.info("Creating: " + bundlePkgInfo);
            write(bundlePkgInfo, config.getPkgInfoData());
        }

        // Copy resources, handle subdirectories.
        final Set<String> reservedAppBundleFiles = Sets.newHashSet(
                "_CodeSignature/CodeResources", "CodeResources", "embedded.mobileprovision",
                "Info.plist", "PkgInfo", "ResourceRules.plist",
                config.getName()
                );
        Collection<File> resourcesFiles = Lists.newArrayList();
        if (config.getResourcesDir().exists()) {
            resourcesFiles = FileUtils.listFilesAndDirs(config.getResourcesDir(),
                    new NotFileFilter(new SuffixFileFilter(new String[] {"xib", "storyboard", "xcdatamodeld", "lproj"})),
                    DirectoryFileFilter.DIRECTORY);
            for (final File resPath : resourcesFiles) {
                if (reservedAppBundleFiles.contains(resPath)) {
                    logger.severe("Cannot use '" + resPath + "' as a resource file because it's a reserved application bundle file");
                    throw new BuildError();
                }
                final File destPath = new File(bundlePath, resPath.getPath());
                if (!destPath.exists() || resPath.lastModified() > destPath.lastModified()) {
                    destPath.getParentFile().mkdirs();
                    logger.info("Copying: " + resPath);
                    try {
                        FileUtils.copyFileToDirectory(resPath, destPath.getParentFile());
                    } catch (final IOException e) {
                        logger.warning("Error copying resource: " + resPath);
                    }
                }
            }
        }

        // Delete old resource files.
        final Collection<File> bundleResources = FileUtils.listFiles(
                config.getResourcesDir(),
                new WildcardFileFilter("**/*"),
                DirectoryFileFilter.DIRECTORY);
        for (final File bundleRes : bundleResources) {
            if (bundleRes.isDirectory()) {
            	continue;
            }
            if (reservedAppBundleFiles.contains(bundleRes)) {
            	continue;
            }
            if (resourcesFiles.contains(bundleRes)) {
            	continue;
            }
            logger.warning("File '" + bundleRes
            		+ "' found in app bundle but not in '"
            		+ config.getResourcesDir() + "', removing");
            FileUtils.deleteQuietly(bundleRes);
        }

        // Generate dSYM.
        final File dSymPath = config.getAppBundle_dSym(platform);
        if (!dSymPath.exists() || mainExec.lastModified() > dSymPath.lastModified()) {
            logger.info("Creating: " + dSymPath);
            sh("/usr/bin/dsymutil " + mainExec + " -o " + dSymPath);
        }

        // Strip all symbols. Only in distribution mode.
        if (mainExecCreated && config.isDistribution()) {
            logger.info("Striping: " + mainExec);
            sh(config.locateBinary("strip") + " " + mainExec);
        }
    }

	protected static String sh(final String cmd) {
		String result = "";
		try {			
			final Process p = Runtime.getRuntime().exec(cmd);
			result = IOUtils.toString(p.getInputStream());

			if (p.waitFor() != 0) {
				logger.severe(IOUtils.toString(p.getErrorStream()));
				throw new BuildError("Problem executing command: " + cmd);
			}
		} catch (final IOException e) {
			throw new BuildError("Failed to execute command: " + cmd);
		} catch (final InterruptedException e) {
			throw new BuildError("Command interrupted: " + cmd);
		}
		return result;
	}

    private static void write(final File file, final String data) {
        try {
            FileUtils.writeStringToFile(file, data);
        } catch (final IOException e) {
        	throw new BuildError("Problem writing to file: " + file.getPath());
        }
    }

    private interface Buildlet { 
        File build(final File path);
    }
    		
    private Builder() {
    }
}
