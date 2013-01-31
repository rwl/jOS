package jos.build;

import static jos.build.Util.sh;

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

import jos.build.types.Architecture;
import jos.build.types.BackgroundMode;
import jos.build.types.BuildError;
import jos.build.types.BuildMode;
import jos.build.types.Family;
import jos.build.types.Orientation;
import jos.build.types.Platform;
import jos.build.types.StatusBarStyle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;

public class Configuration {

	private static final Logger logger = Logger.getLogger(Configuration.class.getName());
	
	private final Map<Platform, Set<Architecture>> archs = Maps.newHashMap();
	
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
    
	private String version, shortVersion;
    private String[] xcodeVersion;
    
    private List<String> icons;
    private boolean prerenderedIcon;
    
    private List<String> fonts;
    private List<Family> deviceFamilies;
    private List<Orientation> interfaceOrientations;
    private List<BackgroundMode> backgroundModes;
    private StatusBarStyle statusBarStyle;
    
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
        
        version = "1.0";
        shortVersion = "1";
        
        icons = Lists.newArrayList();
        prerenderedIcon = false;

        deviceFamilies = Lists.newArrayList(Family.IPHONE);
        interfaceOrientations = Lists.newArrayList(Orientation.PORTRAIT,
                Orientation.LANDSCAPE_LEFT, Orientation.LANDSCAPE_RIGHT);
        backgroundModes = Lists.newArrayList();
        statusBarStyle = StatusBarStyle.DEFAULT;
        
		archs.put(Platform.IPHONE_OS, Sets.newHashSet(Architecture.ARM6));
		archs.put(Platform.IPHONE_SIMULATOR, Sets.newHashSet(Architecture.I386));

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
                final String path = sh(xcodeselect, "-print-path").trim();
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
                	final String libsUsed = sh(ImmutableList.<String>builder()
                    		.add(locateBinary("otool").getAbsolutePath())
                    		.add("-L")
                    		.add(frameworkPath.getAbsolutePath()).build());
                	final Matcher m1 = p1.matcher(libsUsed);
                	while (m1.find()) {
                		final String dep = m1.group(1);
                		// Only care about public, non-umbrella frameworks (for now).
                		final Matcher m2 = p2.matcher(dep);
                		if (m2.matches() && m2.group(1).equals(m2.group(2))) {
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

    private List<String> getCommonFlags(final Platform platform) {
    	final List<String> common = Lists.newArrayList();
    	common.add("-isysroot");
    	common.add(getSdk(platform).getAbsolutePath());
    	common.add("-miphoneos-version-min=" + getSdkVersion());
    	common.add("-F" + getSdk(platform) + "/System/Library/Frameworks");
    	return common;
    }

    public List<String> getCFlags(final Platform platform) {
        final List<String> flags = getCommonFlags(platform);
        if (isDevelopment()) {
        	flags.add("-DDEBUG=1");
        	flags.add("-g");
        }
        flags.add("-fexceptions");
        flags.add("-fblocks");
        flags.add("-fobjc-legacy-dispatch");
        flags.add("-fobjc-abi-version=2");
        flags.add("-std=c99");  // gnu99
        flags.add("-x");
        flags.add("objective-c");
        flags.add("-O0");
        return flags;
    }

	private List<String> getArchFlags(final Platform platform) {
		final List<String> flags = Lists.newArrayList();
		for (Architecture arch : getArchs().get(platform)) {
			flags.add("-arch");
			flags.add(arch.getArch());
		}
		return flags;
	}

    public List<String> getLdFlags(final Platform platform) {
        final List<String> flags = Lists.newArrayList();
        flags.addAll(getArchFlags(platform));
        flags.addAll(getCommonFlags(platform));
        if (getSdkVersion() < 5.0) {
            flags.add("-fobjc-arc");
        }
        return flags;
    }
	
	private String getIosVersionToBuild(float version) {
		if (version == 4.3) {
			return "8F191m";
		} else if (version == 5.0) {
			return "9A334";
		} else if (version == 5.1) {
			return "9B176";
		} else {
			return "10A403"; // 6.0 or later
		}
	}

    public String getInfoPlistData() {
    	final Map<String, Object> plist = ImmutableMap.<String, Object>builder()
    		.put("BuildMachineOSBuild", sh("sw_vers -buildVersion").trim())
            .put("MinimumOSVersion", String.valueOf(getSdkVersion()))
            .put("CFBundleDevelopmentRegion", "en")
            .put("CFBundleName", name)
            .put("CFBundleDisplayName", name)
            .put("CFBundleExecutable", name)
            .put("CFBundleIdentifier", getIdentifier())
            .put("CFBundleInfoDictionaryVersion", "6.0")
            .put("CFBundlePackageType", "APPL")
            .put("CFBundleResourceSpecification", "ResourceRules.plist")
            .put("CFBundleShortVersionString", shortVersion)
            .put("CFBundleSignature", bundleSignature)
            .put("CFBundleSupportedPlatforms", "iPhoneOS")
            .put("CFBundleVersion", version)
            .put("CFBundleIconFiles", icons)
            .put("CFBundleIcons", ImmutableMap.<String, Object>builder()
            		.put("CFBundlePrimaryIcon", ImmutableMap.<String, Object>builder()
            				.put("CFBundleIconFiles", icons)
            				.put("UIPrerenderedIcon", prerenderedIcon).build()).build())
            .put("UIAppFonts", getFonts())
            .put("UIDeviceFamily", getDeviceFamilyInts())
            .put("UISupportedInterfaceOrientations", getInterfaceOrientationsConsts())
            .put("UIStatusBarStyle", statusBarStyle.getConstant())
            .put("UIBackgroundModes", getBackgroundModesConsts())
            .put("DTXcode", getDTXcode())
            .put("DTXcodeBuild", getXcodeVersion()[1])
            .put("DTSDKName", "iphoneos" + getSdkVersion())
            .put("DTSDKBuild", getIosVersionToBuild(getSdkVersion()))
            .put("DTPlatformName", "iphoneos")
            .put("DTCompiler", "com.apple.compilers.llvm.clang.1_0")
            .put("DTPlatformVersion", String.valueOf(getSdkVersion()))
            .put("DTPlatformBuild", getIosVersionToBuild(getSdkVersion())).build();
        return PropertyList.toString(plist);
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
    
    private String getIdentifier() {
    	return "com.yourcompany."+ name.replaceAll("\\s", "");
    }

    private List<String> getFonts() {
        if (fonts == null) {
            if (resourcesDir.exists()) {
            	final FileFilter filter = new SuffixFileFilter(new String[] {"otf", "ttf"});
            	final List<File> fontFiles = Lists.newArrayList(resourcesDir.listFiles(filter));
                fonts = Lists.transform(fontFiles, new Function<File, String>() {
					@Override
					public String apply(final File file) {
						return file.getName();
					}
				});
            } else {
            	fonts = Lists.newArrayList();
            }
        } else {
            fonts = Lists.newArrayList();
        }
        return fonts;
    }

    private List<String> getDeviceFamilyInts() {
        final List<String> list = Lists.newArrayList();
        for (final Family family : deviceFamilies) {
			list.add(String.valueOf(family.getFamilyInt()));
		}
        return list;
    }

    private List<String> getInterfaceOrientationsConsts() {
        final List<String> consts = Lists.newArrayList();
        for (Orientation orientation : interfaceOrientations) {
			consts.add(orientation.getConstant());
		}
        return consts;
    }

    private List<String> getBackgroundModesConsts() {
        final List<String> consts = Lists.newArrayList();
        for (BackgroundMode mode : backgroundModes) {
			consts.add(mode.getModeName());
		}
        return consts;
    }

    private String[] getXcodeVersion() {
        if (xcodeVersion == null) {
        	final Pattern p1 = Pattern.compile("Xcode\\s(.+)");
        	final Pattern p2 = Pattern.compile("Build version\\s(.+)");
        	
            final String txt = sh(ImmutableList.<String>builder()
            		.add(locateBinary("xcodebuild").getAbsolutePath())
            		.add("-version").build());
            
            final Matcher m1 = p1.matcher(txt);
            m1.find();
            final String vers = m1.group(1);
            
            final Matcher m2 = p2.matcher(txt);
            m2.find();
            final String build = m2.group(1);
            
            xcodeVersion = new String[] { vers, build };
        }
        return xcodeVersion;
    }
    
    private String getDTXcode() {
    	final String vers = getXcodeVersion()[0].replaceAll(".", "");
        if (vers.length() == 2) {
        	return "0" + vers + "0";
        } else {
        	return "0" + vers;
        }
    }

    public Map<Platform, Set<Architecture>> getArchs() {
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
