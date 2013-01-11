package jos.build;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.io.filefilter.WildcardFilter;
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
	private boolean detect_dependencies;
	private List<String> frameworks, weak_frameworks, framework_search_paths,
			libs;
	private String delegate_class, name;
	private File resources_dir, specs_dir, build_dir;
	private Family device_family;
	private String bundle_signature;
	private List<Orientation> interface_orientations;
	private String version, short_version;
	private String status_bar_style;
	private List<String> background_modes;
	private List<String> icons;
	private boolean prerendered_icon;
	private List<Vendor> vendor_projects;
	private Map<String, String> entitlements;
	private File motiondir;

	private String xcode_dir, identifier, codesign_certificate,
			provisioning_profile, seed_id, fonts;
	private float sdk_version, deployment_target;

	private boolean spec_mode;
	private BuildMode build_mode, distribution_mode;
	private Map<String, String> dependencies;

	public File project_dir;
	private List<String> setup_blocks;
	private boolean xcode_error_printed;
	private float[] xcode_version;
	private float[] supported_versions;
	private List<String> frameworks_dependencies;
	private List<File> bridgesupport_files;

	public enum Orientation {
		portrait, landscape_left, landscape_right
	}

	public enum Family {
		iphone, ipad
	}

	public enum BuildMode {
		DEVELOPMENT, RELEASE
	}

	public void initialize(final File project_dir, final BuildMode build_mode) {
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
		device_family = Family.iphone;
		bundle_signature = "????";
		interface_orientations = Lists.newArrayList(Orientation.portrait,
				Orientation.landscape_left, Orientation.landscape_right);
		version = "1.0";
		short_version = "1";
		status_bar_style = "default";
		background_modes = Lists.newArrayList();
		icons = Lists.newArrayList();
		prerendered_icon = false;
		vendor_projects = Lists.newArrayList();
		entitlements = Maps.newHashMap();
		spec_mode = false;
		this.build_mode = build_mode;
	}

	String OSX_VERSION = "";// `/usr/bin/sw_vers
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

	private void setup() {
		// if @setup_blocks
		// @setup_blocks.each { |b| b.call(self) }
		// @setup_blocks = nil
		// validate
		// end
		// self
	}

	private String xcode_dir() {
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

	private File locate_binary(final String name) {
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

	private boolean development() {
		return build_mode == BuildMode.DEVELOPMENT;
	}

	private boolean release() {
		return build_mode == BuildMode.RELEASE;
	}

	private int opt_level() {
		switch (build_mode) {
		case DEVELOPMENT:
			return 0;
		case RELEASE:
			return 3;
		default:
			return 0;
		}
	}

	private File versionized_build_dir(final String platform) {
		return new File(build_dir, platform + '-' + deployment_target + '-'
				+ build_mode_name());
	}

	private File project_file() {
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

	private void ordered_build_files() {

	}

	private List<String> frameworks_dependencies() {
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

	private List<File> frameworks_stubs_objects(final String platform) {
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

	private List<File> bridgesupport_files() {
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

	private void spec_files() {

	}

	private File datadir() {
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

	private float sdk_version() {
    	if (sdk_version == 0) {
    		final Collection<File> files = FileUtils.listFiles(platforms_dir(),
					new WildcardFileFilter("iPhoneOS.platform/Developer/SDKs/iPhoneOS*.sdk"),
    				DirectoryFileFilter.DIRECTORY);
    		final List<Float> versions = Lists.newArrayList();
    		for (final File file : files) {
    			//versions.add(file.getName().scan("iPhoneOS(.*)\.sdk")[0][0]);
			}
    		        if (versions.size() == 0) {
    		          Application.fail("Can't find an iOS SDK in `#{platforms_dir}'");
    		        }
    		        float supported_vers = 0;// = versions.reverse.find { |vers| File.exist?(datadir(vers)) }
    		        if (supported_vers == 0) {
    		          Application.fail("jOS doesn't support any of these SDK versions: " + StringUtils.join(versions, ", "));
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

	private File sdk(final String platform) {
		return new File(new File(platform_dir(platform), "Developer/SDKs"),
				platform + sdk_version + ".sdk");
	}
}
