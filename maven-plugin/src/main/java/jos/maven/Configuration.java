package jos.maven;

import static jos.maven.Builder.sh;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jos.maven.types.Architecture;
import jos.maven.types.BuildError;
import jos.maven.types.BuildMode;
import jos.maven.types.Platform;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;

public class Configuration {

	private static final Logger logger = Logger.getLogger(Configuration.class.getName());
	
	private final Map<Platform, List<Architecture>> archs = Maps.newHashMap();
	
    public static String PROJECT_FILE = "pom.xml";
	public static String BUILD_FILE_EXTENTION = ".m";

    private File projectDir;
    private BuildMode buildMode;

    private String name;
    private List<File> files;
    private String xcodeDir;
    private File buildDir;
	private File resourcesDir;
    private Float sdkVersion;
	private String bundleSignature;
    
    private List<String> frameworks;
    private List<String> frameworksDependencies;
    
    private boolean xcodeErrorPrinted = false;
	
	public Configuration(final File projectDir, final BuildMode buildMode) {
        this.projectDir = projectDir;
        this.buildMode = buildMode;

        name = "Untitled";
        buildDir = new File(projectDir, "build");
        resourcesDir = new File(projectDir, "resources");
        files = getFiles();
        bundleSignature = "????";
        
		archs.put(Platform.IPHONE_OS, Lists.newArrayList(Architecture.ARM6));
		archs.put(Platform.IPHONE_SIMULATOR, Lists.newArrayList(Architecture.I386));

        frameworks = Lists.newArrayList("UIKit", "Foundation", "CoreGraphics");
	}
	
	protected List<File> getFiles() {
        final Collection<File> buildFiles = FileUtils.listFiles(projectDir,
                FileFilterUtils.suffixFileFilter(BUILD_FILE_EXTENTION),
                DirectoryFileFilter.DIRECTORY);
        return Lists.newArrayList(buildFiles);
	}

    public String getXcodeDir() {
        if (xcodeDir == null) {
            final String xcodeDotAppPath = "/Applications/Xcode.app/Contents/Developer";

            // First, honor /usr/bin/xcode-select
            final String xcodeselect = "/usr/bin/xcode-select";
            if (new File(xcodeselect).exists()) {
                final String path = sh(xcodeselect + " -print-path").trim();
                if (path.matches("^/Developer/")
                        && new File(xcodeDotAppPath).exists()) {
                    xcodeErrorPrinted |= false;
                    if (!xcodeErrorPrinted) {
                        logger.warning(
                        		  "===============================================================================\n"
                                + "It appears that you have a version of Xcode installed in /Applications that has\n"
                                + "not been set as the default version. It is possible that the builder may be\n"
                                + "using old versions of certain tools which could eventually cause issues.\n"
                                + "\n"
                                + "To fix this problem, you can type the following command in the terminal:\n"
                                + "    $ sudo xcode-select -switch /Applications/Xcode.app/Contents/Developer\n"
                                + "===============================================================================");
                        xcodeErrorPrinted = true;
                    }
                }
                if (new File(path).exists()) {
                	xcodeDir = path;
                    return xcodeDir;
                }
            }

            // Since xcode-select is borked, we assume the user installed Xcode
            // as an app (new in Xcode 4.3).
            if (new File(xcodeDotAppPath).exists()) {
            	xcodeDir = xcodeDotAppPath;
                return xcodeDotAppPath;
            }

            throw new BuildError("Can't locate any version of Xcode on the system.");
        }
        return xcodeDir;
    }

    public File getBuildDir() {
        if (!buildDir.isDirectory()) {
            try {
                buildDir.mkdirs();
            } catch (final SecurityException e) {
                final File tmp = Files.createTempDir();
                logger.warning("Cannot create build directory '"
                        + buildDir
                        + "'. Check the permissions. Using a temporary build directory instead: '"
                        + tmp + "'");
                buildDir = tmp;
            }
        }
        return buildDir;
    }

    public File getVersionedBuildDir(final Platform platform) {
        return new File(getBuildDir(), platform.getPlatform() + '-' + getSdkVersion() + '-'
                + buildMode.getModeName());
    }

    private File getPlatformsDir() {
        return new File(getXcodeDir(), "Platforms");
    }

    private File getPlatformDir(final Platform platform) {
        return new File(getPlatformsDir(), platform.getPlatform() + ".platform");
    }

    public File getProjectFile() {
        return new File(projectDir, PROJECT_FILE);
    }

    public File locateCompiler(final Platform platform, String... execs) {
        final List<File> paths = Lists.newArrayList(new File(
                getPlatformDir(platform), "Developer/usr/bin"));
        paths.add(0, new File(getXcodeDir(),
                "Toolchains/XcodeDefault.xctoolchain/usr/bin"));

        for (String exec : execs) {
            for (File path : paths) {
                final File cc = new File(path, exec);
                if (cc.exists()) {
                    return cc;
                }
            }
        }
        throw new BuildError("Can't locate compilers for platform '" + platform + "'");
    }

    public File locateBinary(final String name) {
        for (File dir : Lists.newArrayList(new File(getXcodeDir(), "usr/bin"),
                new File("/usr/bin"))) {
            final File path = new File(dir, name);
            if (path.exists()) {
                return path;
            }
        }
        throw new BuildError("Can't locate binary '" + name + "' on the system.");
    }

    public File getSdk(final Platform platform) {
        return new File(new File(getPlatformDir(platform), "Developer/SDKs"),
                platform.getPlatform() + getSdkVersion() + ".sdk");
    }

    public float getSdkVersion() {
        if (sdkVersion == null) {
            final File[] files = new File(getPlatformsDir(),
            		"iPhoneOS.platform/Developer/SDKs/").listFiles(
            				(FileFilter) DirectoryFileFilter.INSTANCE);
            final List<Float> versions = Lists.newArrayList();
            final Pattern pattern = Pattern.compile("iPhoneOS(.*).sdk");
            for (final File file : files) {
            	final Matcher matcher = pattern.matcher(file.getName());
            	if (matcher.matches()) {
            		final String group = matcher.group(1);
	            	if (group != null) {
	                    versions.add(Float.valueOf(group));
	            	}
                }
            }
            if (versions.size() == 0) {
                throw new BuildError("Can't find an iOS SDK in " + getPlatformsDir());
            }
            Collections.reverse(versions);
            sdkVersion = versions.get(0);
        }
        return sdkVersion;
    }

    public List<String> getFrameworksDependencies() {
        if (frameworksDependencies == null) {
        	final Pattern p1 = Pattern.compile("\t([^\\s]+)\\s\\(");
    		final Pattern p2 = Pattern.compile("^/System/Library/Frameworks/(.+).framework/(.+)$");
    		
            // Compute the list of frameworks, including dependencies, that the
            // project uses.
            final Set<String> deps = Sets.newLinkedHashSet();
            final File slf = new File(new File(new File(getSdk(Platform.IPHONE_SIMULATOR),
                    "System"), "Library"), "Frameworks");
            for (final String framework : frameworks) {
                final File frameworkPath = new File(new File(slf, framework
                        + ".framework"), framework);
                if (frameworkPath.exists()) {
                	final String libsUsed = sh(locateBinary("otool") + " -L " + frameworkPath);
                	final Matcher m1 = p1.matcher(libsUsed);
                	while (m1.find()) {
                		final String dep = m1.group();
                		// Only care about public, non-umbrella frameworks (for now).
                		final Matcher m2 = p2.matcher(dep);
                		if (m2.groupCount() >= 2 && m2.group(1).equals(m2.group(2))) {
                			deps.add(m2.group(1));
                		}
					}
                }
                deps.add(framework);
            }
            frameworksDependencies = Lists.newArrayList(deps);
        }
        return frameworksDependencies;
    }

    public boolean isDevelopment() {
        return buildMode == BuildMode.DEVELOPMENT;
    }

    public boolean isDistribution() {
        return buildMode == BuildMode.DISTRIBUTION;
    }

    public List<File> getOrderedBuildFiles() {
        return files;
    }

    private String getCommonFlags(final Platform platform) {
        return " -isysroot " + getSdk(platform)
                + " -miphoneos-version-min=" + getSdkVersion()
                + " -F" + getSdk(platform) + "/System/Library/Frameworks";
    }

    public String getCFlags(final Platform platform, final boolean cplusplus,
    		final boolean objc) {
        return getCommonFlags(platform)
        		+ (isDevelopment() ? " -DDEBUG=1 -g" : "")
        		+ " -fexceptions -fblocks -fobjc-legacy-dispatch -fobjc-abi-version=2"
        		+ (cplusplus ? "" : " -std=c99") //gnu99
        		+ " -x " + (cplusplus ? "c++" : objc ? "objective-c" : "c")
        		+ " -O0";
    }

    public String getLdFlags(final Platform platform) {
        String ldflags = getArchFlags(platform) + getCommonFlags(platform);
        if (getSdkVersion() < 5.0) {
            ldflags += " -fobjc-arc";
        }
        return ldflags;
    }

	private String getArchFlags(final Platform platform) {
		return StringUtils.join(Lists.transform(getArchs().get(platform),
				new Function<Architecture, String>() {
					@Override
					public String apply(final Architecture arch) {
						return "-arch " + arch.getArch();
					}
				}), " ");
	}

    public String getInfoPlistData() {
    	return "";
    }

    public String getPkgInfoData() {
        return "AAPL" + bundleSignature;
    }

    public File getAppBundle(final Platform platform) {
        return new File(getVersionedBuildDir(platform), name + ".app");
    }

    public File getAppBundle_dSym(final Platform platform) {
        return new File(getVersionedBuildDir(platform), name + ".dSYM");
    }

    public File getAppBundleExecutable(final Platform platform) {
        return new File(getAppBundle(platform), name);
    }

    public Map<Platform, List<Architecture>> getArchs() {
    	return archs;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public File getResourcesDir() {
        return resourcesDir;
    }

	public void setResourcesDir(File resourcesDir) {
		this.resourcesDir = resourcesDir;
	}

	public void setBuildDir(final File buildDir) {
		this.buildDir = buildDir;
	}

}
