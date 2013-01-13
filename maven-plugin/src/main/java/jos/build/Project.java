/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import static jos.build.Application.sh;
import static jos.build.Application.system;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jos.build.Application.Platform;
import jos.build.Configuration.BuildMode;
import jos.build.Configuration.Family;
import jos.build.Configuration.Retina;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Project {

	/**
	 * Build the simulator version.
	 */
	public static void simulatorBuild() {
		Application.build(Platform.IPHONE_SIMULATOR);
	}

	/**
	 * Build the device version.
	 */
	public static void deviceBuild() {
		Application.build(Platform.IPHONE_OS);
		Application.codesign(Platform.IPHONE_OS);
	}

	/**
	 * Run the simulator.
	 */
	public static void simulator() {
		simulatorBuild();
		final File app = Application.config().app_bundle(Platform.IPHONE_SIMULATOR);
		final float target;
		if (System.getenv().containsKey("target")) {
			target = Float.valueOf(System.getenv("target"));
		} else {
			target = Application.config().sdk_version();
		}

		// Cleanup the simulator application sandbox, to avoid having old resource files there.
		if (System.getenv("clean") != null) {
			final File sim_apps = new File("~/Library/Application Support/iPhone Simulator/"+target+"/Applications");
			for (final File app_bundle : FileUtils.listFiles(sim_apps, new String[] {"app"}, true)) {
				if (app_bundle.getName().equals(app.getName())) {
					FileUtils.deleteQuietly(app_bundle);
					break;
				}
			}
		}

		// Prepare the device family.
		final int family_int;
	    if (System.getenv().containsKey("device_family")) {
	    	family_int = Application.config().device_family_int(Family.valueOf(System.getenv("device_family").toLowerCase()));
	    } else {
	    	family_int = Application.config().device_family_ints()[0];
	    }
	    final Family family = Family.values()[family_int];
	    final Retina retina = System.getenv().containsKey("retina") ? Retina.FALSE : Retina.FALSE;

	    // Configure the SimulateDevice variable (the only way to specify if we want to run in retina mode or not).
	    final String simulate_device = Application.config().device_family_string(family, target, retina);
	    if (!sh("/usr/bin/defaults read com.apple.iphonesimulator \"SimulateDevice\"").trim().equals(simulate_device)) {
	    	system("/usr/bin/killall \"iPhone Simulator\" >& /dev/null");
	    	system("/usr/bin/defaults write com.apple.iphonesimulator \"SimulateDevice\" \""+simulate_device+"\"");
	    }

	    // Launch the simulator.
	    final String xcode = Application.config().xcode_dir();
	    String env = xcode.matches("^/Applications/") ? "DYLD_FRAMEWORK_PATH=\""+xcode+"/../Frameworks\":\""+xcode+"/../OtherFrameworks\"" : "";
	    if (Application.config().spec_mode) env += " SIM_SPEC_MODE=1";
	    final File sim = new File(Application.config().bindir(), "sim");
	    final int debug = System.getenv().containsKey("debug") ? 1 : Application.config().spec_mode ? 0 : 2;
	    Application.info("Simulate", app);
	    /*Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				if (System.out.istty()) {
					// Just in case the simulator launcher crashes and leaves the terminal without echo.
					system("stty echo");
				}
			}
		}));*/
	    sh(String.format("%s %s %d %d %f \"%s\" \"%s\"", env, sim, debug, family_int, target, xcode, app));
	}

	/**
	 * Create an .ipa archive.
	 */
	public static void archive() {
		deviceBuild();
		Application.archive();
	}

	/**
	 * Create an .ipa archive for distribution (AppStore).
	 */
	public static void distributionArchive() {
		Application.config_without_setup().build_mode = BuildMode.RELEASE;
		Application.config().distribution_mode = true;
		deviceBuild();
		Application.archive();
	}

	/**
	 * Run the test suite on the simulator.
	 */
	public static void simulatorTest() {
	    Application.config().spec_mode = true;
	    simulator();
	}

	/**
	 * Run the test suite on the device.
	 */
	public static void deviceTest() {
		Application.config().spec_mode = true;
		//System.getenv().put"debug", "1");
		device();
	}

	public static void device() {
		archive();
		Application.info("Deploy", Application.config().archive());
		final String device_id;
		if (System.getenv().containsKey("id")) {
			device_id = System.getenv("id");
		} else {
			device_id = Application.config().device_id();
		}
		if (!Application.config().provisioned_devices().contains(device_id)) {
		    Application.fail("Device ID '"+device_id+"' not provisioned in profile '"+Application.config().provisioning_profile()+"'");
		}
		final String env = "XCODE_DIR=\""+Application.config().xcode_dir()+"\"";
		final File deploy = new File(Application.config().bindir(), "deploy");
		final String flags = "";//"-d";
		sh(String.format("%s %s %s \"%s\" \"%s\"", env, deploy, flags, device_id, Application.config().archive()));
	}

	/**
	 * Clear build objects.
	 */
	public static void clean() {
		Application.info("Delete", Application.config().build_dir());
		FileUtils.deleteQuietly(Application.config().build_dir());
		for (final Vendor vendor : Application.config().vendor_projects) {
			vendor.clean();
		}
		for (final File p : FileUtils.listFiles(Application.config().resources_dir, new String[] {"nib", "storyboardc", "momd"}, true)) {
			Application.info("Delete", p);
			FileUtils.deleteQuietly(p);
		}
	}

	/**
	 * Show project config.
	 */
	public static void config() {
		final Map<String, String> map = Application.config().variables();
		final List<String> keys = Lists.newArrayList(map.keySet());
		Collections.sort(keys);
		for (final String key : keys) {
			System.out.printf("%22s : %s", key, map.get(key));
			System.out.println();
		}
	}

	/**
	 * Generate ctags.
	 */
	public static void ctags() {
	  final File tags_file = new File("tags");
	  final Configuration config = Application.config();
	  if (!tags_file.exists() || config.project_file().lastModified() > tags_file.lastModified()) {
	    //bs_files = config.bridgesupport_files + config.vendor_projects.map { |p| Dir.glob(File.join(p.path, '*.bridgesupport')) }.flatten
	    //final File ctags = new File(config.bindir(), "ctags");
	    //final File cfg = new File(new File(config.motiondir, "data"), "bridgesupport-ctags.cfg");
	    //sh(ctags+" --options=\""+config+"\" "+bs_files.map { |x| "\"" + x + "\"" }.join(" ")}");
      }
    }

	/**
	 * "Create a .a static library.
	 */
	public static void staticLib() {
      final Map<String, String> opts = Maps.newHashMap();
      opts.put("static", "true");
      final String libs = StringUtils.join(Lists.transform(Lists.newArrayList(Platform.values()), new Function<Platform, String>() {
    	  public String apply(final Platform platform) {
    		  return "\"" + Application.build(platform, opts) + "\"";
    	  }
      }), " ");
	  final File fat_lib = new File(Application.config().build_dir(), Application.config().name + "-universal.a");
	  Application.info("Create", fat_lib);
	  sh("/usr/bin/lipo -create "+libs+" -output \""+fat_lib+"\"");
	}
}
