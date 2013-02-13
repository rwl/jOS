package jos.build;

import static jos.build.Util.sh;
import static jos.build.Util.system;
import static jos.build.Util.write;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import jos.build.types.Architecture;
import jos.build.types.BuildError;
import jos.build.types.Platform;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Builder {

    private static final Logger logger = Logger.getLogger(Builder.class.getName());

    private interface Buildlet {
        File build(final File path);
    }

    private final Configuration config;

    private final Platform platform;

	public Builder(final Configuration config, final Platform platform) {
		this.config = config;
		this.platform = platform;
	}

    public void compile() {
        final Set<Architecture> archs = config.getArchs().get(platform);
        final File clang = config.locateCompiler(platform, "clang");
        final File buildDir = config.getVersionedBuildDir(platform);
        final File objsBuildDir = new File(buildDir, "objs");
        objsBuildDir.mkdirs();

        final Buildlet buildlet = new Buildlet() {

            @Override
            public File build(final File path) {
            	final String name = FilenameUtils.removeExtension(path.getName());
                final File obj = new File(objsBuildDir, name + ".o");
                final boolean shouldRebuild = (!obj.exists()
                        || path.lastModified() > obj.lastModified());

                if (shouldRebuild) {
                    logger.info("Compiling " + path);
                    obj.getParentFile().mkdirs();
                    final List<File> archObjs = Lists.newArrayList();
                    for (final Architecture arch : archs) {
                        // Object.
                        final File archObj = new File(objsBuildDir, name + '-' + arch.getArch() + ".o.tmp");
                        sh(ImmutableList.<String>builder()
                            .add(clang.getAbsolutePath())
                            .addAll(config.getIncludeFlags())
                            .addAll(config.getCFlags(platform))
                            .add("-arch").add(arch.getArch())
                            .add("-c").add(path.getAbsolutePath())
                            .add("-o").add(archObj.getAbsolutePath()).build());

                        archObjs.add(archObj);
                    }

                    // Assemble fat binary.
                    if (archs.size() > 1) {
                    	logger.info("Assembling " + obj.getAbsolutePath());
                    }
                    sh(ImmutableList.<String>builder()
                            .add("/usr/bin/lipo")
                            .add("-create")
                            .addAll(Lists.transform(archObjs, Util.absolutePathFunction))
                            .add("-output")
                            .add(obj.getAbsolutePath()).build());
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
        /*final List<File> objs = Lists.newArrayList();
        builder_i = 0;
        for (@SuppressWarnings("unused") final File path : config.getOrderedBuildFiles()) {
            objs.add(builderQueues.get(builder_i).remove(0));
            builder_i += 1;
            if (builder_i == buildersCount) {
                builder_i = 0;
            }
        }*/
    }

    private List<File> getObjs() {
        final File buildDir = config.getVersionedBuildDir(platform);
        final File objsBuildDir = new File(buildDir, "objs");
        final Collection<File> objs = FileUtils.listFiles(objsBuildDir,
                FileFilterUtils.suffixFileFilter(".o"),
                DirectoryFileFilter.DIRECTORY);
    	return Lists.newArrayList(objs);
    }

    /**
     * Creates a static archive with all object files + dependencies.
     */
    public void archive() {
        final File lib = new File(config.getVersionedBuildDir(platform), config.getName() + ".a");
        logger.info("Creating " + lib);
        sh(ImmutableList.<String>builder()
        		.add("/usr/bin/libtool")
        		.add("-static")
        		.addAll(Lists.transform(getObjs(), Util.absolutePathFunction))
        		.add("-o")
        		.add(lib.getAbsolutePath()).build());
    }

    public void bundle() {
        final File clang = config.locateCompiler(platform, "clang");

    	List<File> objs = getObjs();
        if (objs.isEmpty()) {
        	compile();
        	objs = getObjs();
        }

        // Compile main file.
        if (config.getMainFile() == null) {
	        final File objsBuildDir = new File(config.getVersionedBuildDir(platform), "objs");
	        final File main = new File(objsBuildDir, "main.m");
	        final File main_o = new File(objsBuildDir, "main.o");
	        if (!main.exists() && !main_o.exists()) {
	            write(main, getMainTxt());
                logger.info("Compiling " + main);
	            sh(ImmutableList.<String>builder()
	            		.add(clang.getAbsolutePath())
	            		.add("-c")
	            		.add(main.getAbsolutePath())
	            		.addAll(config.getArchFlags(platform))
	            		.addAll(config.getCFlags(platform))
	            		.add("-o")
	            		.add(main_o.getAbsolutePath()).build());
	        	objs = getObjs();
	        }
        }

        // Prepare bundle.
        final File bundlePath = config.getAppBundle(platform);
        if (!bundlePath.exists()) {
            logger.info("Creating " + bundlePath);
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
        	logger.info("Linking " + mainExec);
            final List<String> frameworks = Lists.newArrayList();
            for (String fw : config.getFrameworksDependencies()) {
				frameworks.add("-framework");
				frameworks.add(fw);
			}
            sh(ImmutableList.<String>builder()
            		.add(clang.getAbsolutePath())
            		.addAll(config.getLibraryFlags())
            		.addAll(config.getLdFlags(platform))
            		.add("-o").add(mainExec.getAbsolutePath())
            		.addAll(Lists.transform(objs, Util.absolutePathFunction))
            		.addAll(frameworks).build());
            mainExecCreated = true;
        }

        // Create bundle/Info.plist.
        final File bundleInfoPlist = new File(bundlePath, "Info.plist");
        if (!bundleInfoPlist.exists() || config.getProjectFile().lastModified() > bundleInfoPlist.lastModified()) {
            logger.info("Creating " + bundleInfoPlist);
            write(bundleInfoPlist, config.getInfoPlistData());
            sh(ImmutableList.<String>builder()
            		.add("/usr/bin/plutil")
            		.add("-convert")
            		.add("binary1")
            		.add(bundleInfoPlist.getAbsolutePath()).build());
        }

        // Create bundle/PkgInfo.
        final File bundlePkgInfo = new File(bundlePath, "PkgInfo");
        if (!bundlePkgInfo.exists() || config.getProjectFile().lastModified() > bundlePkgInfo.lastModified()) {
            logger.info("Creating " + bundlePkgInfo);
            write(bundlePkgInfo, config.getPkgInfoData());
        }

        // Compile IB resources.
        if (config.getResourcesDir().exists()) {
            final List<File> ibResourcesSrc = Lists.newArrayList();
            final List<File> ibResourcesDest = Lists.newArrayList();
            for (final File path : FileUtils.listFiles(config.getResourcesDir(), new String[] {"xib", "storyboard"}, true)) {
                ibResourcesSrc.add(path);
                ibResourcesDest.add(new File(path.getPath().replaceFirst(".xib", ".nib").replaceFirst(".storyboard", ".storyboardc")));
            }
            assert ibResourcesSrc.size() == ibResourcesDest.size();
            for (int i = 0; i < ibResourcesSrc.size(); i++) {
                final File src = ibResourcesSrc.get(i);
                final File dest = ibResourcesDest.get(i);
                if (!dest.exists() || src.lastModified() > dest.lastModified()) {
                    logger.info("Compiling " + src);
                    sh(ImmutableList.<String>builder()
                    		.add("/usr/bin/ibtool")
                    		.add("--compile")
                    		.add(dest.getAbsolutePath())
                    		.add(src.getAbsolutePath()).build());
                }
            }
        }

        // Compile CoreData Model resources.
        if (config.getResourcesDir().exists()) {
            final Collection<File> models = FileUtils.listFiles(config.getResourcesDir(), new String[] {"xcdatamodeld"}, true);
            for (final File model : models) {
                final File momd = new File(model.getPath().replaceFirst(".xcdatamodeld", ".momd"));
                if (!momd.exists() || model.lastModified() > momd.lastModified()) {
                    logger.info("Compiling " + model);
                    sh(ImmutableList.<String>builder()
                    		.add(config.getXcodeDir() + "/usr/bin/momc")
                    		.add(model.getAbsolutePath())
                    		.add(momd.getAbsolutePath()).build());
                }
            }
        }

        // Copy resources, handle subdirectories.
        final Set<String> reservedAppBundleFiles = Sets.newHashSet(
                "_CodeSignature/CodeResources", "CodeResources", "embedded.mobileprovision",
                "Info.plist", "PkgInfo", "ResourceRules.plist",
                config.getName());
        Collection<File> resourcesFiles = Lists.newArrayList();
        if (config.getResourcesDir().exists()) {
            resourcesFiles = FileUtils.listFiles(config.getResourcesDir(),
                    new NotFileFilter(new SuffixFileFilter(new String[] {"xib", "storyboard", "xcdatamodeld", "lproj"})),
                    DirectoryFileFilter.DIRECTORY);
            for (final File resPath : resourcesFiles) {
                if (reservedAppBundleFiles.contains(resPath)) {
                    logger.severe("Cannot use '" + resPath + "' as a resource file because it's a reserved application bundle file");
                    throw new BuildError();
                }
                final File destPath = new File(bundlePath, resPath.getAbsolutePath()
                		.substring(config.getResourcesDir().getAbsolutePath().length()));
                if (!destPath.exists() || resPath.lastModified() > destPath.lastModified()) {
                    destPath.getParentFile().mkdirs();
                    logger.info("Copying " + resPath);
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
                bundlePath,
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
            logger.info("Creating " + dSymPath);
            sh(ImmutableList.<String>builder()
            		.add("/usr/bin/dsymutil")
            		.add(mainExec.getAbsolutePath())
            		.add("-o")
            		.add(dSymPath.getAbsolutePath()).build());
        }

        // Strip all symbols. Only in distribution mode.
        if (mainExecCreated && config.isDistribution()) {
            logger.info("Striping " + mainExec);
            sh(ImmutableList.<String>builder()
            		.add(config.locateBinary("strip").getAbsolutePath())
            		.add(mainExec.getAbsolutePath()).build());
        }
    }

    private String getMainTxt() {
    	return String.format("#import <UIKit/UIKit.h>\n"
    			+ "int main(int argc, char *argv[])\n"
    			+ "{\n"
    			+ "\t@autoreleasepool {\n"
    			+ "\t\treturn UIApplicationMain(argc, argv, nil, @\"%s\");\n"
    			+ "\t}\n"
    			+ "}\n", config.getDelegateClassName());
    }

    public void codeSign() {
        final File bundlePath = config.getAppBundle(platform);
        if (!bundlePath.exists()) {
            throw new BuildError("App bundle not found");
        }

        // Create bundle/ResourceRules.plist.
        final File resourceRulesPlist = new File(bundlePath, "ResourceRules.plist");
        if (!resourceRulesPlist.exists()) {
            logger.info("Creating " + resourceRulesPlist);
            write(resourceRulesPlist,
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "        <key>rules</key>\n" +
                "        <dict>\n" +
                "                <key>.*</key>\n" +
                "                <true/>\n" +
                "                <key>Info.plist</key>\n" +
                "                <dict>\n" +
                "                        <key>omit</key>\n" +
                "                        <true/>\n" +
                "                        <key>weight</key>\n" +
                "                        <real>10</real>\n" +
                "                </dict>\n" +
                "                <key>ResourceRules.plist</key>\n" +
                "                <dict>\n" +
                "                        <key>omit</key>\n" +
                "                        <true/>\n" +
                "                        <key>weight</key>\n" +
                "                        <real>100</real>\n" +
                "                </dict>\n" +
                "        </dict>\n" +
                "</dict>\n" +
                "</plist>");
        }

        // Copy the provisioning profile.
        final File bundleProvision = new File(bundlePath, "embedded.mobileprovision");
        if (!bundleProvision.exists() || config.getProvisioningProfile().lastModified() > bundleProvision.lastModified()) {
            logger.info("Creating " + bundleProvision);
            try {
                FileUtils.copyFile(config.getProvisioningProfile(), bundleProvision);
            } catch (final IOException e) {
                throw new BuildError("Error copying provisioning profile", e);
            }
        }

        // Codesign.
        final File allocate = new File(config.getPlatformDir(platform), "Developer/usr/bin/codesign_allocate");
        final List<String> codeSignCmd = ImmutableList.<String>builder()
        		.add("CODESIGN_ALLOCATE=\"" + allocate.getAbsolutePath() + "\"")
        		.add("/usr/bin/codesign").build();
        if (config.getProjectFile().lastModified() > bundlePath.lastModified()
                || !system(ImmutableList.<String>builder()
                		.add("codeSignCmd")
                		.add("--verify").add(bundlePath.getAbsolutePath())
                		.add(">&").add("/dev/null").build())) {
            logger.info("Codesigning " + bundlePath);
            final File entitlements = new File(config.getVersionedBuildDir(platform), "Entitlements.plist");
            write(entitlements, config.getEntitlementsData());
            sh(ImmutableList.<String>builder()
            		.addAll(codeSignCmd)
            		.add("-f")
            		.add("-s")
            		.add(config.getCodeSignCertificate())
            		.add("--resource-rules=\"" + resourceRulesPlist.getAbsolutePath())
            		.add("--entitlements")
            		.add(entitlements.getAbsolutePath())
            		.add(bundlePath.getAbsolutePath()).build());
        }
    }

    /**
     * Creates an iOS App Store Package (.ipa) archive.
     */
    public void ipa() {
        final File appBundle = config.getAppBundle(Platform.IPHONE_OS);
        final File archive = config.getArchive();
        if (!archive.exists() || appBundle.lastModified() > archive.lastModified()) {
            logger.info("Creating " + archive);
            final File tmp = new File("/tmp/ipa_root");
            sh("/bin/rm -rf " + tmp.getAbsolutePath());
            sh("/bin/mkdir -p " + tmp.getAbsolutePath() + "/Payload");
            sh(ImmutableList.<String>builder()
            		.add("/bin/cp")
            		.add("-r").add(appBundle.getAbsolutePath())
            		.add(tmp.getAbsolutePath() + "/Payload").build());
            sh("/bin/chmod -R 755 Payload", tmp);
            sh("/usr/bin/zip -q -r archive.zip Payload", tmp);
            sh(ImmutableList.<String>builder()
            		.add("/bin/cp")
            		.add(tmp.getAbsolutePath() + "/archive.zip")
            		.add(archive.getAbsolutePath()).build());
        }
    }
}
