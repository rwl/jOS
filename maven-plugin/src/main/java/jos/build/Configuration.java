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

	private File[] files;
	private Map<String, String> info_plist;
	public boolean detect_dependencies;
	private List<String> frameworks;
	public List<String> weak_frameworks, libs;
	public List<File> framework_search_paths;
	public String name;
	private String delegate_class;
	private File build_dir;
	public File resources_dir;
	public File specs_dir;
	private Family[] device_family;
	private String bundle_signature;
	private List<Orientation> interface_orientations;
	private String version, short_version;
	private StatusBarStyle status_bar_style;
	private List<BackgroundMode> background_modes;
	private List<String> icons;
	private boolean prerendered_icon;
	public List<Vendor> vendor_projects;
	private Map<String, String> entitlements;
	private File motiondir;

	private String xcode_dir, identifier, codesign_certificate,
			seed_id, fonts;
	private File provisioning_profile;
	private float sdk_version, deployment_target;

	public boolean spec_mode;
	private BuildMode build_mode;
	public boolean distribution_mode;
	public Map<String, String> dependencies;

	public File project_dir;
	private List<String> setup_blocks;
	private boolean xcode_error_printed;
	private float[] xcode_version;
	private float[] supported_versions;
	private List<String> frameworks_dependencies;
	private List<File> bridgesupport_files;
	private Map<String, String> archs;
    private String[] read_provisioned_profile_array;
    private String device_id;
    private String[] provisioned_devices;

	public enum Orientation {
		portrait, landscape_left, landscape_right, portrait_upside_down
	}

	public enum Family {
		iphone, ipad
	}

	public enum BuildMode {
		DEVELOPMENT, RELEASE, DISTRIBUTION
	}

	public enum Retina {
		TRUE, INCH_3_5, INCH_4
	}

	public enum BackgroundMode {audio, location, voip, newsstand_content,
		external_accessory, bluetooth_central}

	public enum StatusBarStyle {DEFAULT, black_translucent, black_opaque}

	public Configuration(final File project_dir, final BuildMode build_mode) {
		this.project_dir = project_dir;
		final Collection<File> files = FileUtils.listFiles(project_dir,
				FileFilterUtils.suffixFileFilter(".java"),
				DirectoryFileFilter.DIRECTORY);
		this.files = files.toArray(new File[files.size()]);
		info_plist = Maps.newHashMap();
		dependencies = Maps.newHashMap();
		detect_dependencies = true;
		frameworks = Lists.newArrayList("UIKit", "Foundation", "CoreGraphics");
		weak_frameworks = Lists.newArrayList();
		framework_search_paths = Lists.newArrayList();
		libs = Lists.newArrayList();
		delegate_class = "AppDelegate";
		name = "Untitled";
		resources_dir = new File(project_dir, "resources");
		build_dir = new File(project_dir, "build");
		specs_dir = new File(project_dir, "spec");
		device_family = new Family[] {Family.iphone};
		bundle_signature = "????";
		interface_orientations = Lists.newArrayList(Orientation.portrait,
				Orientation.landscape_left, Orientation.landscape_right);
		version = "1.0";
		short_version = "1";
		status_bar_style = StatusBarStyle.DEFAULT;
		background_modes = Lists.newArrayList();
		icons = Lists.newArrayList();
		prerendered_icon = false;
		vendor_projects = Lists.newArrayList();
		entitlements = Maps.newHashMap();
		spec_mode = false;
		this.build_mode = build_mode;
	}

	float OSX_VERSION = 0;// `/usr/bin/sw_vers
							// -productVersion`.strip.sub("\.\d+$", '').to_f";

	private Map<String, String> variables() {
		final Map<String, String> map = Maps.newHashMap();
		for (String sym : VARS) {
			map.put(sym, sym);
		}
		return map;
	}

	private List<String> setup_blocks() {
		if (setup_blocks == null) {
			setup_blocks = Lists.newArrayList();
		}
		return setup_blocks;
	}

	public void setup() {
		// if @setup_blocks
		// @setup_blocks.each { |b| b.call(self) }
		// @setup_blocks = nil
		// validate
		// end
		// self
	}

	public String xcode_dir() {
		if (xcode_dir == null) {
			final String xcode_dot_app_path = "/Applications/Xcode.app/Contents/Developer";

			// First, honor /usr/bin/xcode-select
			final String xcodeselect = "/usr/bin/xcode-select";
			if (new File(xcodeselect).exists()) {
				final String path = xcodeselect + " -print-path".trim();
				if (path.matches("^/Developer/")
						&& new File(xcode_dot_app_path).exists()) {
					xcode_error_printed |= false;
					if (!xcode_error_printed) {
						System.err
								.println("===============================================================================\n"
										+ "It appears that you have a version of Xcode installed in /Applications that has\n"
										+ "not been set as the default version. It is possible that RubyMotion may be\n"
										+ "using old versions of certain tools which could eventually cause issues.\n"
										+ "\n"
										+ "To fix this problem, you can type the following command in the terminal:\n"
										+ "    $ sudo xcode-select -switch /Applications/Xcode.app/Contents/Developer\n"
										+ "===============================================================================");
						xcode_error_printed = true;
					}
				}
				if (new File(path).exists()) {
					return path;
				}
			}

			// Since xcode-select is borked, we assume the user installed Xcode
			// as an app (new in Xcode 4.3).
			if (new File(xcode_dot_app_path).exists()) {
				return xcode_dot_app_path;
			}

			Application
					.fail("Can't locate any version of Xcode on the system.");
		}
		return xcode_dir;
	}

	public File locate_binary(final String name) {
		for (File dir : Lists.newArrayList(new File(xcode_dir, "usr/bin"),
				new File("/usr/bin"))) {
			final File path = new File(dir, name);
			if (path.exists()) {
				return path;
			}
		}
		Application.fail("Can't locate binary '" + name + "' on the system.");
		return null;
	}

	private float[] xcode_version() {
		if (xcode_version == null) {
			final String txt = locate_binary("xcodebuild").getPath()
					+ "-version";
			final float vers = Float.valueOf(txt);// .scan("Xcode\s(.+)")[0][0];
			final float build = Float.valueOf(txt);// .scan("Build
													// version\s(.+)")[0][0];
			return new float[] { vers, build };
		}
		return xcode_version;
	}

	private void validate() {
		// Xcode version
		if (xcode_version()[0] < 4.0) {
			Application.fail("Xcode 4.x or greater is required");
		}

		// SDK version
		for (String platform : Lists
				.newArrayList("iPhoneSimulator", "iPhoneOS")) {
			final File sdk_path = new File(new File(platforms_dir(), platform
					+ ".platform"),
					"Developer/SDKs/#{platform}#{sdk_version}.sdk");
			if (!sdk_path.exists()) {
				Application
						.fail("Can't locate #{platform} SDK #{sdk_version} at `#{sdk_path}'");
			}
		}

		// Deployment target
		if (deployment_target > sdk_version) {
			Application.fail("Deployment target '" + deployment_target
					+ "' must be equal or lesser than SDK version '"
					+ sdk_version + "')");
		}
		if (!datadir().exists()) {
			Application.fail("iOS deployment target '" + deployment_target
					+ "' is not supported by this version of jOS");
		}
	}

	private float[] supported_versions() {
		if (supported_versions == null) {
			final List<Float> versions = Lists.newArrayList();
			final Collection<File> files = FileUtils.listFiles(motiondir,
					new WildcardFileFilter("data/*"),
					DirectoryFileFilter.DIRECTORY);
			for (final File path : files) {
				if (path.isDirectory()) {
					versions.add(Float.valueOf(path.getName()));
				}
			}
			supported_versions = new float[versions.size()];
			for (int i = 0; i < versions.size(); i++) {
				supported_versions[i] = versions.get(i);
			}
		}
		return supported_versions;
	}

	private File build_dir() {
		if (!build_dir.isDirectory()) {
			try {
				build_dir.mkdirs();
			} catch (SecurityException e) {
				final File tmp = Files.createTempDir();
				Application
						.warn("Cannot create build directory '"
								+ build_dir
								+ "'. Check the permissions. Using a temporary build directory instead: '"
								+ tmp + "'");
				build_dir = tmp;
			}
		}
		return build_dir;
	}

	private String build_mode_name() {
		return StringUtils.capitalize(build_mode.toString().toLowerCase());
	}

	public boolean development() {
		return build_mode == BuildMode.DEVELOPMENT;
	}

	private boolean release() {
		return build_mode == BuildMode.RELEASE;
	}

	public int opt_level() {
		switch (build_mode) {
		case DEVELOPMENT:
			return 0;
		case RELEASE:
			return 3;
		default:
			return 0;
		}
	}

	public File versionized_build_dir(final String platform) {
		return new File(build_dir, platform + '-' + deployment_target + '-'
				+ build_mode_name());
	}

	public File project_file() {
		return new File(project_dir, "Makefile");
	}

	private void files_dependencies(Map<File, String> deps_hash) {
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

	private void vendor_project(final File path, final String type,
			Map<String, String> opts) {
		vendor_projects.add(new Vendor(path, type, this, opts));
	}

	private void unvendor_project(final File path) {
		final Iterator<Vendor> iterator = vendor_projects.iterator();
		while (iterator.hasNext()) {
			final Vendor vendor = (Vendor) iterator.next();
			if (vendor.getPath().equals(path)) {
				vendor_projects.remove(vendor);
			}
		}
	}

	private void file_dependencies(final File file) {

	}

	public List<File> ordered_build_files() {
		return null;
	}

	public List<String> frameworks_dependencies() {
		if (frameworks_dependencies == null) {
			// Compute the list of frameworks, including dependencies, that the
			// project uses.
			final Set<String> deps = Sets.newLinkedHashSet();
			final File slf = new File(new File(new File(sdk("iPhoneSimulator"),
					"System"), "Library"), "Frameworks");
			for (final String framework : frameworks) {
				final File framework_path = new File(new File(slf, framework
						+ ".framework"), framework);
				if (framework_path.exists()) {
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
			if (framework_search_paths.isEmpty()) {
				// deps = deps.select { |dep| File.exist?(File.join(datadir,
				// 'BridgeSupport', dep + '.bridgesupport')) };
			}
			frameworks_dependencies = Lists.newArrayList(deps);
		}
		return frameworks_dependencies;
	}

	public List<File> frameworks_stubs_objects(final String platform) {
		final List<File> stubs = Lists.newArrayList();
		final List<String> frameworks = Lists
				.newArrayList(frameworks_dependencies());
		frameworks.addAll(weak_frameworks);
		for (String framework : frameworks) {
			final File stubs_obj = new File(new File(datadir(), platform),
					"#{framework}_stubs.o");
			if (stubs_obj.exists()) {
				stubs.add(stubs_obj);
			}
		}
		return stubs;
	}

	public List<File> bridgesupport_files() {
		if (bridgesupport_files == null) {
			bridgesupport_files = Lists.newArrayList();
			Set<String> deps = Sets.newLinkedHashSet();
			deps.add("jOS");
			deps.addAll(frameworks_dependencies());
			deps.addAll(weak_frameworks);
			if (spec_mode) {
				deps.add("UIAutomation");
			}
			for (final String framework : deps) {
				for (final float ver : supported_versions()) {
					if (ver < deployment_target || sdk_version < ver) {
						continue;
					}
					final File bs_path = new File(new File(datadir(ver),
							"BridgeSupport"), framework + ".bridgesupport");
					if (bs_path.exists()) {
						bridgesupport_files.add(bs_path);
					}
				}
			}
		}
		return bridgesupport_files;
	}

	public List<File> spec_files() {
		return null;
	}

	public File datadir() {
		return null;
	}

	private File datadir(final float target) {
		return null;
	}

	private File platforms_dir() {
		return new File(xcode_dir, "Platforms");
	}

	private File platform_dir(final String platform) {
		return new File(platforms_dir(), platform + ".platform");
	}

	public File bindir() {
		return null;
	}

	private float sdk_version() {
		if (sdk_version == 0) {
			final Collection<File> files = FileUtils.listFiles(platforms_dir(),
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
			sdk_version = supported_vers;
		}
		return sdk_version;
	}

	private float deployment_target() {
		if (deployment_target == 0) {
			deployment_target = sdk_version();
		}
		return deployment_target;
	}

	public File sdk(final String platform) {
		return new File(new File(platform_dir(platform), "Developer/SDKs"),
				platform + sdk_version + ".sdk");
	}

	public File locate_compiler(final String platform, String... execs) {
		final List<File> paths = Lists.newArrayList(new File(
				platform_dir(platform), "Developer/usr/bin"));
		paths.add(0, new File(xcode_dir,
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
		return build_dir;
	}

	public Map<String, String> archs() {
		if (archs == null) {
			Map<String, String> h = Maps.newHashMap();
			for (String platform : Lists.newArrayList("iPhoneSimulator",
					"iPhoneOS")) {
				final Collection<File> files = FileUtils.listFiles(datadir(),
						FileFilterUtils.suffixFileFilter(".bc"),
						DirectoryFileFilter.DIRECTORY);
				for (File path : files) {
					h.put(platform, ""/* path.scan(/kernel-(.+).bc$/)[0][0] */);
				}
			}
			archs = h;
		}
		return archs;
	}

	private String arch_flags(final String platform) {
		final List<String> flags = Lists.newArrayList();
		for (final String x : archs().values()) {
			flags.add("-arch " + x);
		}
		return StringUtils.join(flags, " ");
	}

	private String common_flags(final String platform) {
		return arch_flags(platform) + " -isysroot \"" + sdk(platform)
				+ "\" -miphoneos-version-min=" + deployment_target() + " -F"
				+ sdk(platform) + "/System/Library/Frameworks";
	}

	public String cflags(final String platform, final boolean cplusplus) {
		return common_flags(platform) + " -fexceptions -fblocks -fobjc-legacy-dispatch -fobjc-abi-version=2" + (cplusplus ? "" : " -std=c99");
	}

	public String ldflags(final String platform) {
		String ldflags = common_flags(platform);
		if (deployment_target < 5.0) {
			ldflags += " -fobjc-arc";
		}
		return ldflags;
	}

	private String bundle_name() {
		return name + (spec_mode ? "_spec" : "");
	}

	public File app_bundle(final String platform) {
		return new File(versionized_build_dir(platform), bundle_name() + ".app");
	}

	public File app_bundle_dsym(final String platform) {
		return new File(versionized_build_dir(platform), bundle_name() + ".dSYM");
	}

    public File app_bundle_executable(final String platform) {
    	return new File(app_bundle(platform), name);
    }

    public File archive() {
    	return new File(versionized_build_dir("iPhoneOS"), bundle_name() + ".ipa");
    }

    private String identifier() {
    	if (identifier == null) {
//    		identifier = "com.yourcompany.#{@name.gsub(/\s/, '')}";
    	}
    	return spec_mode ? identifier + "_spec" : identifier;
    }

    private int device_family_int(final Family family) {
    	switch (family) {
		case iphone:
			return 1;
		case ipad:
			return 2;
		default:
			Application.fail("Unknown device_family value: " + family);
			return 0;
		}
    }

    private String device_family_string(final Family family, final float target,
    		final Retina retina) {
      String device = "";
      switch (family) {
      case iphone:
    	  device += "iPhone";
      case ipad:
    	  device += "iPad";
      }
      switch (retina) {
      case TRUE:
    	  device += ((device_family_int(family) == 1 && target >= 6.0) ? " (Retina 4-inch)" : " (Retina)");
      case INCH_3_5:
    	  device += " (Retina 3.5-inch)";
      case INCH_4:
          device += " (Retina 4-inch)";
      }
      return device;
    }

    private int[] device_family_ints() {
    	final int[] ary = new int[device_family.length];
    	for (int i = 0; i < device_family.length; i++) {
			final Family family = device_family[i];
			ary[i] = device_family_int(family);
		}
    	return ary;
    }

    private String[] interface_orientations_consts() {
    	final String[] consts = new String[interface_orientations.size()];
    	for (int i = 0; i < interface_orientations.size(); i++) {
    		final Orientation ori = interface_orientations.get(i);
    		switch (ori) {
			case portrait:
				consts[i] = "UIInterfaceOrientationPortrait";
			case landscape_left:
				consts[i] = "UIInterfaceOrientationLandscapeLeft";
			case landscape_right:
				consts[i] = "UIInterfaceOrientationLandscapeRight";
			case portrait_upside_down:
				consts[i] = "UIInterfaceOrientationPortraitUpsideDown";
			default:
				Application.fail("Unknown interface_orientation value: " + ori);
    		}
    	}
    	return consts;
    }

    private String[] background_modes_consts() {
    	final String[] consts = new String[background_modes.size()];
    	for (int i = 0; i < background_modes.size(); i++) {
    		final BackgroundMode mode = background_modes.get(i);
			switch (mode) {
			case audio:
				consts[i] = "audio";
			case location:
				consts[i] = "location";
			case voip:
				consts[i] = "voip";
			case newsstand_content:
				consts[i] = "newsstand-content";
			case external_accessory:
				consts[i] = "external-accessory";
			case bluetooth_central:
				consts[i] = "bluetooth-central";
			default:
				Application.fail("Unknown background_modes value: " + mode);
			}
		}
		return consts;
    }

    private String status_bar_style_const() {
    	switch (status_bar_style) {
    	case DEFAULT:
    		return "UIStatusBarStyleDefault";
    	case black_translucent:
    		return "UIStatusBarStyleBlackTranslucent";
    	case black_opaque:
    		return "UIStatusBarStyleBlackOpaque";
        default:
          Application.fail("Unknown status_bar_style value: " + status_bar_style);
          return null;
    	}
    }

    public String info_plist_data() {
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
      plist.put("MinimumOSVersion", String.valueOf(deployment_target()));
      plist.put("CFBundleDevelopmentRegion", "en");
      plist.put("CFBundleName", name);
      plist.put("CFBundleDisplayName", name);
      plist.put("CFBundleExecutable", name);
      plist.put("CFBundleIdentifier", identifier());
      plist.put("CFBundleInfoDictionaryVersion", "6.0");
      plist.put("CFBundlePackageType", "APPL");
      plist.put("CFBundleResourceSpecification", "ResourceRules.plist");
      plist.put("CFBundleShortVersionString", short_version);
      plist.put("CFBundleSignature", bundle_signature);
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
      plist.put("DTXcodeBuild", String.valueOf(xcode_version()[1]));
      plist.put("DTSDKName", "iphoneos" + sdk_version());
//      plist.put("DTSDKBuild", ios_version_to_build.call(sdk_version()));
      plist.put("DTPlatformName", "iphoneos");
      plist.put("DTCompiler", "com.apple.compilers.llvm.clang.1_0");
      plist.put("DTPlatformVersion", String.valueOf(sdk_version()));
//      plist.put("DTPlatformBuild", ios_version_to_build.call(sdk_version()));
      plist.putAll(info_plist);
      return plist.toString();
    }

    private String pkginfo_data() {
    	return "AAPL"+bundle_signature;
    }

    public String codesign_certificate() {
    	if (codesign_certificate == null) {
        final String cert_type = (!development() ? "Distribution" : "Developer");
        List<String> certs = null;//"/usr/bin/security -q find-certificate -a".scan(/"iPhone #{cert_type}: [^"]+"/).uniq
        if (certs.size() == 0) {
        	Application.fail("Can't find an iPhone Developer certificate in the keychain");
        } else if (certs.size() > 1) {
        	Application.warn("Found "+certs.size()+" iPhone Developer certificates in the keychain. Set the `codesign_certificate' project setting. Will use the first certificate: "+certs.get(0));
        }
//        codesign_certificate = certs[0][1..-2] // trim trailing `"` characters
    	}
      return codesign_certificate;
    }

    private String device_id() {
      if (device_id == null) {
        final File deploy = new File(bindir(), "deploy");
        device_id = deploy+" -D".trim();
        if (device_id.isEmpty()) {
          Application.fail("Can't find an iOS device connected on USB");
        }
      }
      return device_id;
    }

    public File provisioning_profile() {
    	return provisioning_profile("iOS Team Provisioning Profile");
    }

    private File provisioning_profile(final String name) {
    	if (provisioning_profile == null) {
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
			}else if (paths.size() > 1) {
				Application.warn("Found "+paths.size()+" provisioning profiles named "+name+". Set the `provisioning_profile' project setting. Will use the first one: "+paths.get(0)+"'");
			}
			provisioning_profile = paths.get(0);
    	}
    	return provisioning_profile;
    }

    private String[] read_provisioned_profile_array(final String key) {
//      text = File.read(provisioning_profile)
//      text.force_encoding('binary') if RUBY_VERSION >= '1.9.0'
//      text.scan(/<key>\s*#{key}\s*<\/key>\s*<array>(.*?)\s*<\/array>/m)[0][0].scan(/<string>(.*?)<\/string>/).map { |str| str[0].strip }
    	return null;
    }

    private String[] provisioned_devices() {
      if (provisioned_devices == null) {
    	  provisioned_devices = read_provisioned_profile_array("ProvisionedDevices");
      }
      return provisioned_devices;
    }

    private String seed_id() {
    	if (seed_id == null) {
    		String[] seed_ids = read_provisioned_profile_array("ApplicationIdentifierPrefix");
    		if (seed_ids.length == 0) {
    			Application.fail("Can't find an application seed ID in the provisioning profile '"+provisioning_profile+"'");
    		} else if (seed_ids.length > 1) {
    			Application.warn("Found "+seed_ids.length+" seed IDs in the provisioning profile. Set the `seed_id' project setting. Will use the last one: "+seed_ids[seed_ids.length - 1]);
    		}
    		seed_id = seed_ids[seed_ids.length - 1];
    	}
    	return seed_id;
    }

    public String entitlements_data() {
    	Map<String, String> dict = entitlements;
    	if (!development()) {
    		if (!dict.containsKey("application-identifier")) {
    			dict.put("application-identifier", seed_id + '.' + identifier);
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

    private List<File> fonts() {
    	final List<File> fontList;
    	if (fonts == null) {
    		if (resources_dir.exists()) {
    			final Collection<File> files = FileUtils.listFiles(
    					resources_dir,
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

    private void gen_bridge_metadata(final List<String> headers, final File bs_file) {
      final File sdk_path = sdk("iPhoneSimulator");
      final Set<String> includes = Sets.newLinkedHashSet();
      for (String header : headers) {
    	  includes.add("-I" + new File(header).getParent());
      }
//      final String[] a = sdk_version.scan("(\d+)\.(\d+)")[0];

//      sdk_version_headers = ((Integer.valueOf(a[0]) * 10000) + (Integer.valueOf(a[1]) * 100)).toString();
      final String extra_flags = OSX_VERSION >= 10.7 ? "--no-64-bit" : "";
//      sh "RUBYOPT='' /usr/bin/gen_bridge_metadata --format complete #{extra_flags} --cflags \"-isysroot #{sdk_path} -miphoneos-version-min=#{sdk_version} -D__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__=#{sdk_version_headers} -I. #{includes.join(' ')}\" #{headers.map { |x| "\"#{x}\"" }.join(' ')} -o \"#{bs_file}\""
      }
}
