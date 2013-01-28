/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jos.build.Application.Architecture;
import jos.build.Application.Platform;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;

public class Configuration {

    List<String> VARS = Lists.newArrayList();

    private static class Deps<K, V> extends HashMap<K, V> {

        // def []=(key, val)
        // key = relpath(key)
        // val = [val] unless val.is_a?(Array)
        // val = val.map { |x| relpath(x) }
        // super
        // end

        private String relativePath(final String path) {
            return path.matches("/^./") ? path : "File.join('.', path)";
        }
    }

    private List<File> files;
    private Map<String, String> infoPlist;
    private boolean detectDependencies;
    private List<String> frameworks;
    private List<String> weakFrameworks, libs;
    private List<File> frameworkSearchPaths;
    private String name;
    private String delegateClass;
    private File buildDir;
    private File resourcesDir;
    private File specsDir;
    private Family[] deviceFamily;
    private String bundleSignature;
    private List<Orientation> interfaceOrientations;
    private String version, shortVersion;
    private StatusBarStyle statusBarStyle;
    private List<BackgroundMode> backgroundModes;
    private List<String> icons;
    private boolean prerenderedIcon;
    private List<Vendor> vendorProjects;
    private Map<String, String> entitlements;
    private File motionDir;

    private String xcodeDir, identifier, codeSignCertificate, seedId, fonts;
    private File provisioningProfile;
    private float sdkVersion, deploymentTarget;

    private boolean specMode;
    private BuildMode buildMode;
    private boolean distributionMode;
    private Map<String, String> dependencies;

    private File projectDir;
    private List<String> setupBlocks;
    private boolean xcodeErrorPrinted;
    private float[] xcodeVersion;
    private float[] supportedVersions;
    private List<String> frameworksDependencies;
    private List<File> bridgeSupportFiles;
    private Map<Platform, List<Architecture>> archs;
    private String[] readProvisionedProfileArray;
    private String deviceId;
    private String[] provisionedDevices;

    float OSX_VERSION = 0;// `/usr/bin/sw_vers
    // -productVersion`.strip.sub("\.\d+$", '').to_f";

    public enum Orientation {
        PORTRAIT ("UIInterfaceOrientationPortrait"),
        LANDSCAPE_LEFT ("UIInterfaceOrientationLandscapeLeft"),
        LANDSCAPE_RIGHT ("UIInterfaceOrientationLandscapeRight"),
        PORTRAIT_UPSIDE_DOWN ("UIInterfaceOrientationPortraitUpsideDown");

        private final String constant;

        private Orientation(final String constant) {
            this.constant = constant;
        }

        public String getConstant() {
            return this.constant;
        }
    }

    public enum Family {
        IPHONE (1, "iPhone"),
        IPAD (2, "iPad");

        private final int familyInt;

        private final String familyName;

        private Family(final int familyInt, final String familyName) {
            this.familyInt = familyInt;
            this.familyName = familyName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public int getFamilyInt() {
            return familyInt;
        }
    }

    public enum BuildMode {
        DEVELOPMENT, RELEASE, DISTRIBUTION
    }

    public enum Retina {
        FALSE, TRUE, INCH_3_5, INCH_4
    }

    public enum BackgroundMode {
        AUDIO ("audio"),
        LOCATION ("location"),
        VOIP ("voip"),
        NEWSSTAND_CONTENT ("newsstand-content"),
        EXTERNAL_ACCESSORY ("external-accessory"),
        BLUETOOTH_CENTRAL ("bluetooth-central");

        private final String modeName;

        private BackgroundMode(final String modeName) {
            this.modeName = modeName;
        }

        public String getModeName() {
            return modeName;
        }
    }

    public enum StatusBarStyle {
        DEFAULT ("UIStatusBarStyleDefault"),
        black_translucent ("UIStatusBarStyleBlackTranslucent"),
        black_opaque ("UIStatusBarStyleBlackOpaque");

        private final String constant;

        private StatusBarStyle(final String constant) {
            this.constant = constant;
        }

        public String getConstant() {
            return constant;
        }
    }

    public Configuration(final File projectDir, final BuildMode buildMode) {
        this.projectDir = projectDir;
        final Collection<File> files = FileUtils.listFiles(projectDir,
                FileFilterUtils.suffixFileFilter(".m"),
                DirectoryFileFilter.DIRECTORY);
        this.files = Lists.newArrayList(files);
        infoPlist = Maps.newHashMap();
        dependencies = Maps.newHashMap();
        detectDependencies = true;
        frameworks = Lists.newArrayList("UIKit", "Foundation", "CoreGraphics");
        weakFrameworks = Lists.newArrayList();
        frameworkSearchPaths = Lists.newArrayList();
        libs = Lists.newArrayList();
        delegateClass = "AppDelegate";
        name = "Untitled";
        resourcesDir = new File(projectDir, "resources");
        buildDir = new File(projectDir, "build");
        specsDir = new File(projectDir, "spec");
        deviceFamily = new Family[] {Family.IPHONE};
        bundleSignature = "????";
        interfaceOrientations = Lists.newArrayList(Orientation.PORTRAIT,
                Orientation.LANDSCAPE_LEFT, Orientation.LANDSCAPE_RIGHT);
        version = "1.0";
        shortVersion = "1";
        statusBarStyle = StatusBarStyle.DEFAULT;
        backgroundModes = Lists.newArrayList();
        icons = Lists.newArrayList();
        prerenderedIcon = false;
        vendorProjects = Lists.newArrayList();
        entitlements = Maps.newHashMap();
        specMode = false;
        this.buildMode = buildMode;
    }

    public Map<String, String> variables() {
        final Map<String, String> map = Maps.newHashMap();
        for (String sym : VARS) {
            map.put(sym, sym);
        }
        return map;
    }

    private List<String> getSetupBlocks() {
        if (setupBlocks == null) {
            setupBlocks = Lists.newArrayList();
        }
        return setupBlocks;
    }

    public void setup() {
        // if @setup_blocks
        // @setup_blocks.each { |b| b.call(self) }
        // @setup_blocks = nil
        // validate
        // end
        // self
    }

    public String getXcodeDir() {
        if (xcodeDir == null) {
            final String xcodeDotAppPath = "/Applications/Xcode.app/Contents/Developer";

            // First, honor /usr/bin/xcode-select
            final String xcodeselect = "/usr/bin/xcode-select";
            if (new File(xcodeselect).exists()) {
                final String path = (xcodeselect + " -print-path").trim();
                if (path.matches("^/Developer/")
                        && new File(xcodeDotAppPath).exists()) {
                    xcodeErrorPrinted |= false;
                    if (!xcodeErrorPrinted) {
                        System.err
                        .println("===============================================================================\n"
                                + "It appears that you have a version of Xcode installed in /Applications that has\n"
                                + "not been set as the default version. It is possible that RubyMotion may be\n"
                                + "using old versions of certain tools which could eventually cause issues.\n"
                                + "\n"
                                + "To fix this problem, you can type the following command in the terminal:\n"
                                + "    $ sudo xcode-select -switch /Applications/Xcode.app/Contents/Developer\n"
                                + "===============================================================================");
                        xcodeErrorPrinted = true;
                    }
                }
                if (new File(path).exists()) {
                    return path;
                }
            }

            // Since xcode-select is borked, we assume the user installed Xcode
            // as an app (new in Xcode 4.3).
            if (new File(xcodeDotAppPath).exists()) {
                return xcodeDotAppPath;
            }

            Application.fail("Can't locate any version of Xcode on the system.");
        }
        return xcodeDir;
    }

    public File locateBinary(final String name) {
        for (File dir : Lists.newArrayList(new File(getXcodeDir(), "usr/bin"),
                new File("/usr/bin"))) {
            final File path = new File(dir, name);
            if (path.exists()) {
                return path;
            }
        }
        Application.fail("Can't locate binary '" + name + "' on the system.");
        return null;
    }

    private float[] getXcodeVersion() {
        if (xcodeVersion == null) {
            final String txt = locateBinary("xcodebuild").getPath()
                    + "-version";
            final float vers = Float.valueOf(txt);// .scan("Xcode\s(.+)")[0][0];
            final float build = Float.valueOf(txt);// .scan("Build
            // version\s(.+)")[0][0];
            return new float[] { vers, build };
        }
        return xcodeVersion;
    }

    private void validate() {
        // Xcode version
        if (getXcodeVersion()[0] < 4.0) {
            Application.fail("Xcode 4.x or greater is required");
        }

        // SDK version
        for (String platform : Lists
                .newArrayList("iPhoneSimulator", "iPhoneOS")) {
            final File sdkPath = new File(new File(getPlatformsDir(), platform
                    + ".platform"),
                    "Developer/SDKs/#{platform}#{sdk_version}.sdk");
            if (!sdkPath.exists()) {
                Application
                .fail("Can't locate #{platform} SDK #{sdk_version} at `#{sdk_path}'");
            }
        }

        // Deployment target
        if (deploymentTarget > sdkVersion) {
            Application.fail("Deployment target '" + deploymentTarget
                    + "' must be equal or lesser than SDK version '"
                    + sdkVersion + "')");
        }
        if (!getDataDir().exists()) {
            Application.fail("iOS deployment target '" + deploymentTarget
                    + "' is not supported by this version of jOS");
        }
    }

    private float[] getSupportedVersions() {
        if (supportedVersions == null) {
            final List<Float> versions = Lists.newArrayList();
            final Collection<File> files = FileUtils.listFiles(motionDir,
                    new WildcardFileFilter("data/*"),
                    DirectoryFileFilter.DIRECTORY);
            for (final File path : files) {
                if (path.isDirectory()) {
                    versions.add(Float.valueOf(path.getName()));
                }
            }
            supportedVersions = new float[versions.size()];
            for (int i = 0; i < versions.size(); i++) {
                supportedVersions[i] = versions.get(i);
            }
        }
        return supportedVersions;
    }

    public File getBuildDir() {
        if (!buildDir.isDirectory()) {
            try {
                buildDir.mkdirs();
            } catch (final SecurityException e) {
                final File tmp = Files.createTempDir();
                Application
                .warn("Cannot create build directory '"
                        + buildDir
                        + "'. Check the permissions. Using a temporary build directory instead: '"
                        + tmp + "'");
                buildDir = tmp;
            }
        }
        return buildDir;
    }

    private String getBuildModeName() {
        return StringUtils.capitalize(buildMode.toString().toLowerCase());
    }

    public boolean isDevelopment() {
        return buildMode == BuildMode.DEVELOPMENT;
    }

    private boolean isRelease() {
        return buildMode == BuildMode.RELEASE;
    }

    public int getOptLevel() {
        switch (buildMode) {
        case DEVELOPMENT:
            return 0;
        case RELEASE:
            return 3;
        default:
            return 0;
        }
    }

    public File getVersionedBuildDir(final Platform platform) {
        return new File(buildDir, platform.getPlatform() + '-' + deploymentTarget + '-'
                + getBuildModeName());
    }

    public File getProjectFile() {
        return new File(projectDir, "Makefile");
    }

    private void getFilesDependencies(Map<File, String> deps_hash) {
        // res_path = lambda do |x|
        // path = /^\./.match(x) ? x : File.join('.', x)
        // unless @files.include?(path)
        // App.fail "Can't resolve dependency `#{x}'"
        // end
        // path
        // end
        // deps_hash.each do |path, deps|
        // deps = [deps] unless deps.is_a?(Array)
        // @dependencies[res_path.call(path)] = deps.map(&res_path)
        // end
    }

    private void vendorProject(final File path, final String type,
            Map<String, String> opts) {
        vendorProjects.add(new Vendor(path, type, this, opts));
    }

    private void unvendorProject(final File path) {
        final Iterator<Vendor> iterator = vendorProjects.iterator();
        while (iterator.hasNext()) {
            final Vendor vendor = (Vendor) iterator.next();
            if (vendor.getPath().equals(path)) {
                vendorProjects.remove(vendor);
            }
        }
    }

    private void fileDependencies(final File file) {

    }

    public List<File> getOrderedBuildFiles() {
        return files;
    }

    public List<String> getFrameworksDependencies() {
        if (frameworksDependencies == null) {
            // Compute the list of frameworks, including dependencies, that the
            // project uses.
            final Set<String> deps = Sets.newLinkedHashSet();
            final File slf = new File(new File(new File(getSdk(Platform.IPHONE_SIMULATOR),
                    "System"), "Library"), "Frameworks");
            for (final String framework : frameworks) {
                final File frameworkPath = new File(new File(slf, framework
                        + ".framework"), framework);
                if (frameworkPath.exists()) {
                    // for (String dep : locate_binary("otool") +
                    // " -L \"#{framework_path}\"".scan("\t([^\s]+)\s\(")) {
                    // // Only care about public, non-umbrella frameworks (for
                    // now).
                    // if
                    // (md.equals(dep[0].match("^\/System\/Library\/Frameworks\/(.+)\.framework\/(.+)$")
                    // && md[1].equals(md[2]) {
                    // deps.add(md[1]);
                    // }
                    // }
                }
                deps.add(framework);
            }
            // deps.uniq!
            if (frameworkSearchPaths.isEmpty()) {
                // deps = deps.select { |dep| File.exist?(File.join(datadir,
                // 'BridgeSupport', dep + '.bridgesupport')) };
            }
            frameworksDependencies = Lists.newArrayList(deps);
        }
        return frameworksDependencies;
    }

    public List<File> getFrameworksStubsObjects(final Platform platform) {
        final List<File> stubs = Lists.newArrayList();
        final List<String> frameworks = Lists
                .newArrayList(getFrameworksDependencies());
        frameworks.addAll(weakFrameworks);
        for (final String framework : frameworks) {
            final File stubs_obj = new File(new File(getDataDir(), platform.getPlatform()),
                    "#{framework}_stubs.o");
            if (stubs_obj.exists()) {
                stubs.add(stubs_obj);
            }
        }
        return stubs;
    }

    public List<File> getBridgeSupportFiles() {
        if (bridgeSupportFiles == null) {
            bridgeSupportFiles = Lists.newArrayList();
            /*Set<String> deps = Sets.newLinkedHashSet();
            deps.add("jOS");
            deps.addAll(getFrameworksDependencies());
            deps.addAll(weakFrameworks);
            if (specMode) {
                deps.add("UIAutomation");
            }
            for (final String framework : deps) {
                for (final float ver : getSupportedVersions()) {
                    if (ver < deploymentTarget || sdkVersion < ver) {
                        continue;
                    }
                    final File bs_path = new File(new File(getDataDir(ver),
                            "BridgeSupport"), framework + ".bridgesupport");
                    if (bs_path.exists()) {
                        bridgeSupportFiles.add(bs_path);
                    }
                }
            }*/
        }
        return bridgeSupportFiles;
    }

    public List<File> getSpecFiles() {
        return null;
    }

    @Deprecated
    public File getDataDir() {
        return null;
    }

    private File getDataDir(final float target) {
        return null;
    }

    private File getPlatformsDir() {
        return new File(getXcodeDir(), "Platforms");
    }

    private File getPlatformDir(final Platform platform) {
        return new File(getPlatformsDir(), platform.getPlatform() + ".platform");
    }

    @Deprecated
    public File getBinDir() {
        return null;
    }

    public float getSdkVersion() {
        if (sdkVersion == 0) {
            final Collection<File> files = FileUtils.listFiles(getPlatformsDir(),
                    new WildcardFileFilter(
                            "iPhoneOS.platform/Developer/SDKs/iPhoneOS*.sdk"),
                            DirectoryFileFilter.DIRECTORY);
            final List<Float> versions = Lists.newArrayList();
            for (final File file : files) {
                // versions.add(file.getName().scan("iPhoneOS(.*)\.sdk")[0][0]);
            }
            if (versions.size() == 0) {
                Application.fail("Can't find an iOS SDK in `#{platforms_dir}'");
            }
            float supported_vers = 0;// = versions.reverse.find { |vers|
            // File.exist?(datadir(vers)) }
            if (supported_vers == 0) {
                Application
                .fail("jOS doesn't support any of these SDK versions: "
                        + StringUtils.join(versions, ", "));
            }
            sdkVersion = supported_vers;
        }
        return sdkVersion;
    }

    private float getDeploymentTarget() {
        if (deploymentTarget == 0) {
            deploymentTarget = getSdkVersion();
        }
        return deploymentTarget;
    }

    public File getSdk(final Platform platform) {
        return new File(new File(getPlatformDir(platform), "Developer/SDKs"),
                platform.getPlatform() + sdkVersion + ".sdk");
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
        Application.fail("Can't locate compilers for platform '" + platform
                + "'");
        return buildDir;
    }

    public Map<Platform, List<Architecture>> getArchs() {
        if (archs == null) {
            archs = Maps.newHashMap();
            for (final Platform platform : Platform.values()) {
//                final Collection<File> files = FileUtils.listFiles(getDataDir(),
//                        FileFilterUtils.suffixFileFilter(".bc"),
//                        DirectoryFileFilter.DIRECTORY);
//                for (File path : files) {
//                    archs.put(platform, ""/* path.scan(/kernel-(.+).bc$/)[0][0] */);
//                }
                archs.put(platform, Lists.newArrayList(Architecture.I386,
                        Architecture.X86_64));
            }
        }
        return archs;
    }

    private String getArchFlags(final Platform platform) {
        return "-arch " + StringUtils.join(getArchs().get(platform), " ");
    }

    private String getCommonFlags(final Platform platform) {
        return getArchFlags(platform) + " -isysroot \"" + getSdk(platform)
                + "\" -miphoneos-version-min=" + getDeploymentTarget() + " -F"
                + getSdk(platform) + "/System/Library/Frameworks";
    }

    public String getCFlags(final Platform platform, final boolean cplusplus) {
        return getCommonFlags(platform) + " -fexceptions -fblocks -fobjc-legacy-dispatch -fobjc-abi-version=2" + (cplusplus ? "" : " -std=c99");
    }

    public String getLdFlags(final Platform platform) {
        String ldflags = getCommonFlags(platform);
        if (deploymentTarget < 5.0) {
            ldflags += " -fobjc-arc";
        }
        return ldflags;
    }

    private String getBundleName() {
        return name + (specMode ? "_spec" : "");
    }

    public File getAppBundle(final Platform platform) {
        return new File(getVersionedBuildDir(platform), getBundleName() + ".app");
    }

    public File getAppBundle_dSym(final Platform platform) {
        return new File(getVersionedBuildDir(platform), getBundleName() + ".dSYM");
    }

    public File getAppBundleExecutable(final Platform platform) {
        return new File(getAppBundle(platform), name);
    }

    public File getArchive() {
        return new File(getVersionedBuildDir(Platform.IPHONE_OS), getBundleName() + ".ipa");
    }

    private String identifier() {
        if (identifier == null) {
            //    		identifier = "com.yourcompany.#{@name.gsub(/\s/, '')}";
        }
        return specMode ? identifier + "_spec" : identifier;
    }

    public String getDeviceFamilyString(final Family family, final float target,
            final Retina retina) {
        String device = family.getFamilyName();
        switch (retina) {
        case TRUE:
            device += ((family.getFamilyInt() == 1 && target >= 6.0) ? " (Retina 4-inch)" : " (Retina)");
        case INCH_3_5:
            device += " (Retina 3.5-inch)";
        case INCH_4:
            device += " (Retina 4-inch)";
        }
        return device;
    }

    public int[] getDeviceFamilyInts() {
        final int[] ary = new int[deviceFamily.length];
        for (int i = 0; i < deviceFamily.length; i++) {
            final Family family = deviceFamily[i];
            ary[i] = family.getFamilyInt();
        }
        return ary;
    }

    private String[] getInterfaceOrientationsConsts() {
        final String[] consts = new String[interfaceOrientations.size()];
        for (int i = 0; i < interfaceOrientations.size(); i++) {
            consts[i] = interfaceOrientations.get(i).getConstant();
        }
        return consts;
    }

    private String[] getBackgroundModesConsts() {
        final String[] consts = new String[backgroundModes.size()];
        for (int i = 0; i < backgroundModes.size(); i++) {
            consts[i] = backgroundModes.get(i).getModeName();
        }
        return consts;
    }

    public String getInfoPlistData() {
        final String ios_version_to_build;// = lambda do |vers|
        // XXX we should retrieve these values programmatically.
        //        switch (vers) {
        //        case 4.3: ios_version_to_build = "8F191m";
        //        case 5.0: ios_version_to_build = "9A334";
        //        case 5.1: ios_version_to_build = "9B176";
        //          default: ios_version_to_build = "10A403"; // 6.0 or later
        //        }
        final Map<String, String> plist = Maps.newHashMap();
        plist.put("BuildMachineOSBuild", "sw_vers -buildVersion".trim());
        plist.put("MinimumOSVersion", String.valueOf(getDeploymentTarget()));
        plist.put("CFBundleDevelopmentRegion", "en");
        plist.put("CFBundleName", name);
        plist.put("CFBundleDisplayName", name);
        plist.put("CFBundleExecutable", name);
        plist.put("CFBundleIdentifier", identifier());
        plist.put("CFBundleInfoDictionaryVersion", "6.0");
        plist.put("CFBundlePackageType", "APPL");
        plist.put("CFBundleResourceSpecification", "ResourceRules.plist");
        plist.put("CFBundleShortVersionString", shortVersion);
        plist.put("CFBundleSignature", bundleSignature);
        plist.put("CFBundleSupportedPlatforms", "iPhoneOS");
        plist.put("CFBundleVersion", version);
        //      plist.put("CFBundleIconFiles", icons);
        //      plist.put("CFBundleIcons", {
        //          "CFBundlePrimaryIcon", {
        //            "CFBundleIconFiles", icons,
        //            "UIPrerenderedIcon", prerendered_icon,
        //          }
        //        });
        //      plist.put("UIAppFonts", fonts);
        //      plist.put("UIDeviceFamily", device_family_ints();
        //      plist.put("UISupportedInterfaceOrientations", interface_orientations_consts());
        //      plist.put("UIStatusBarStyle", status_bar_style_const());
        //      plist.put("UIBackgroundModes", background_modes_consts());
        //      plist.put("DTXcode", begin
        //          vers = xcode_version[0].gsub(/\./, "")
        //          if vers.length == 2
        //            "0" + vers + "0"
        //          else
        //            "0" + vers
        //          end
        //        end,
        plist.put("DTXcodeBuild", String.valueOf(getXcodeVersion()[1]));
        plist.put("DTSDKName", "iphoneos" + getSdkVersion());
        //      plist.put("DTSDKBuild", ios_version_to_build.call(sdk_version()));
        plist.put("DTPlatformName", "iphoneos");
        plist.put("DTCompiler", "com.apple.compilers.llvm.clang.1_0");
        plist.put("DTPlatformVersion", String.valueOf(getSdkVersion()));
        //      plist.put("DTPlatformBuild", ios_version_to_build.call(sdk_version()));
        plist.putAll(infoPlist);
        return plist.toString();
    }

    private String getPkgInfoData() {
        return "AAPL"+bundleSignature;
    }

    public String getCodeSignCertificate() {
        if (codeSignCertificate == null) {
            final String cert_type = (!isDevelopment() ? "Distribution" : "Developer");
            List<String> certs = null;//"/usr/bin/security -q find-certificate -a".scan(/"iPhone #{cert_type}: [^"]+"/).uniq
            if (certs.size() == 0) {
                Application.fail("Can't find an iPhone Developer certificate in the keychain");
            } else if (certs.size() > 1) {
                Application.warn("Found "+certs.size()+" iPhone Developer certificates in the keychain. Set the `codesign_certificate' project setting. Will use the first certificate: "+certs.get(0));
            }
            //        codesign_certificate = certs[0][1..-2] // trim trailing `"` characters
        }
        return codeSignCertificate;
    }

    public String getDeviceId() {
        if (deviceId == null) {
            final File deploy = new File(getBinDir(), "deploy");
            deviceId = deploy+" -D".trim();
            if (deviceId.isEmpty()) {
                Application.fail("Can't find an iOS device connected on USB");
            }
        }
        return deviceId;
    }

    public File getProvisioningProfile() {
        return getProvisioningProfile("iOS Team Provisioning Profile");
    }

    private File getProvisioningProfile(final String name) {
        if (provisioningProfile == null) {
            final Collection<File> files = FileUtils.listFiles(
                    new File("~/Library/MobileDevice/Provisioning Profiles"),
                    FileFilterUtils.suffixFileFilter(".mobileprovision"),
                    DirectoryFileFilter.DIRECTORY);
            final List<File> paths = Lists.newArrayList();
            //          text = File.read(path)
            //          text.force_encoding("binary") if RUBY_VERSION >= '1.9.0'
            //          text.scan(/<key>\s*Name\s*<\/key>\s*<string>\s*([^<]+)\s*<\/string>/)[0][0].match(name)

            if (paths.size() == 0) {
                Application.fail("Can't find a provisioning profile named '"+name+"'");
            } else if (paths.size() > 1) {
                Application.warn("Found "+paths.size()+" provisioning profiles named "+name+". Set the `provisioning_profile' project setting. Will use the first one: "+paths.get(0)+"'");
            }
            provisioningProfile = paths.get(0);
        }
        return provisioningProfile;
    }

    private String[] getReadProvisionedProfileArray(final String key) {
        //      text = File.read(provisioning_profile)
        //      text.force_encoding('binary') if RUBY_VERSION >= '1.9.0'
        //      text.scan(/<key>\s*#{key}\s*<\/key>\s*<array>(.*?)\s*<\/array>/m)[0][0].scan(/<string>(.*?)<\/string>/).map { |str| str[0].strip }
        return null;
    }

    public List<String> getProvisionedDevices() {
        if (provisionedDevices == null) {
            provisionedDevices = getReadProvisionedProfileArray("ProvisionedDevices");
        }
        return Lists.newArrayList(provisionedDevices);
    }

    private String getSeedId() {
        if (seedId == null) {
            String[] seedIds = getReadProvisionedProfileArray("ApplicationIdentifierPrefix");
            if (seedIds.length == 0) {
                Application.fail("Can't find an application seed ID in the provisioning profile '"+provisioningProfile+"'");
            } else if (seedIds.length > 1) {
                Application.warn("Found "+seedIds.length+" seed IDs in the provisioning profile. Set the `seed_id' project setting. Will use the last one: "+seedIds[seedIds.length - 1]);
            }
            seedId = seedIds[seedIds.length - 1];
        }
        return seedId;
    }

    public String getEntitlementsData() {
        Map<String, String> dict = entitlements;
        if (!isDevelopment()) {
            if (!dict.containsKey("application-identifier")) {
                dict.put("application-identifier", seedId + '.' + identifier);
            }
        } else {
            // Required for gdb.
            if (!dict.containsKey("get-task-allow")) {
                dict.put("get-task-allow", "true");
            }
        }
        //new PropertyList(dict).toString();
        return dict.toString();
    }

    private List<File> getFonts() {
        final List<File> fontList;
        if (fonts == null) {
            if (resourcesDir.exists()) {
                final Collection<File> files = FileUtils.listFiles(
                        resourcesDir,
                        new WildcardFileFilter("*.{otf,ttf}"),
                        DirectoryFileFilter.DIRECTORY);
                fontList = Lists.newArrayList(files);
            } else {
                fontList = Collections.emptyList();
            }
        } else {
            fontList = Collections.emptyList();
        }
        return fontList;
    }

    private void genBridgeMetadata(final List<String> headers, final File bsFile) {
        final File sdk_path = getSdk(Platform.IPHONE_SIMULATOR);
        final Set<String> includes = Sets.newLinkedHashSet();
        for (String header : headers) {
            includes.add("-I" + new File(header).getParent());
        }
        //      final String[] a = sdk_version.scan("(\d+)\.(\d+)")[0];

        //      sdk_version_headers = ((Integer.valueOf(a[0]) * 10000) + (Integer.valueOf(a[1]) * 100)).toString();
        final String extra_flags = OSX_VERSION >= 10.7 ? "--no-64-bit" : "";
        //      sh "RUBYOPT='' /usr/bin/gen_bridge_metadata --format complete #{extra_flags} --cflags \"-isysroot #{sdk_path} -miphoneos-version-min=#{sdk_version} -D__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__=#{sdk_version_headers} -I. #{includes.join(' ')}\" #{headers.map { |x| "\"#{x}\"" }.join(' ')} -o \"#{bs_file}\""
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildDir(final File buildDir) {
        this.buildDir = buildDir;
    }

    public File getResourcesDir() {
        return resourcesDir;
    }

    public void setResourcesDir(File resources_dir) {
        this.resourcesDir = resources_dir;
    }

    public boolean isDetectDependencies() {
        return detectDependencies;
    }

    public void setDetectDependencies(boolean detectDependencies) {
        this.detectDependencies = detectDependencies;
    }

    public List<String> getLibs() {
        return libs;
    }

    public List<String> getWeakFrameworks() {
        return weakFrameworks;
    }

    public List<File> getFrameworkSearchPaths() {
        return frameworkSearchPaths;
    }

    public File getSpecsDir() {
        return specsDir;
    }

    public List<Vendor> getVendorProjects() {
        return vendorProjects;
    }

    public File getMotionDir() {
        return motionDir;
    }

    public boolean isSpecMode() {
        return specMode;
    }

    public void setSpecMode(boolean specMode) {
        this.specMode = specMode;
    }

    public BuildMode getBuildMode() {
        return buildMode;
    }

    public void setBuildMode(BuildMode buildMode) {
        this.buildMode = buildMode;
    }

    public boolean isDistributionMode() {
        return distributionMode;
    }

    public void setDistributionMode(boolean distributionMode) {
        this.distributionMode = distributionMode;
    }

    public Map<String, String> getDependencies() {
        return dependencies;
    }
}
