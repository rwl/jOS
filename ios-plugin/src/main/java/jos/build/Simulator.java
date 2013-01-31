package jos.build;

import static jos.build.Util.sh;

import java.io.File;
import java.util.logging.Logger;

import jos.build.types.Family;
import jos.build.types.Platform;
import jos.build.types.Retina;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.ImmutableList;

public class Simulator {

    private static final Logger logger = Logger.getLogger(Simulator.class.getName());

    private final Configuration config;

    private float target;
    private Family family;
    private Retina retina;

    public Simulator(final Configuration config) {
    	this.config = config;

    	target = config.getSdkVersion();
    	family = Family.IPHONE;
    	retina = Retina.FALSE;
    }

    public void clean() {
        final File app = config.getAppBundle(Platform.IPHONE_SIMULATOR);
    	final File simApps = new File(System.getProperty("user.home"), "Library/Application Support/iPhone Simulator/" + target + "/Applications");
        for (final File appBundle : FileUtils.listFiles(simApps, new String[] {"app"}, true)) {
            if (appBundle.getName().equals(app.getName())) {
                FileUtils.deleteQuietly(appBundle);
                break;
            }
        }
    }

    public void launch() {
        // Configure the SimulateDevice variable (the only way to specify if we want to run in retina mode or not).
        final String simulateDevice = getDeviceFamilyString(family, target, retina);
        if (!sh("/usr/bin/defaults read com.apple.iphonesimulator SimulateDevice").trim().equals(simulateDevice)) {
            sh("/usr/bin/killall iPhone Simulator >& /dev/null");
            sh("/usr/bin/defaults write com.apple.iphonesimulator SimulateDevice " + simulateDevice);
        }

        // Launch the simulator.
        final String xcode = config.getXcodeDir();

        final File app = config.getAppBundle(Platform.IPHONE_SIMULATOR);
        logger.info("Simulating " + app);

        sh(ImmutableList.<String>builder()
        		.add(xcode + "/Platforms/iPhoneSimulator.platform/Developer/Applications/iPhone Simulator.app/Contents/MacOS/iPhone Simulator")
        		.add("-SimulateApplication")
        		.add(config.getAppBundleExecutable(Platform.IPHONE_SIMULATOR).getAbsolutePath()).build());
    }

    public void setTarget(float target) {
		this.target = target;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public void setRetina(Retina retina) {
		this.retina = retina;
	}

	private static String getDeviceFamilyString(final Family family, final float target,
            final Retina retina) {
        String device = family.getFamilyName();
        switch (retina) {
        case TRUE:
            device += ((family.getFamilyInt() == 1 && target >= 6.0) ? " (Retina 4-inch)" : " (Retina)");
        case INCH_3_5:
            device += " (Retina 3.5-inch)";
        case INCH_4:
            device += " (Retina 4-inch)";
		case FALSE:
		default:
        }
        return device;
    }

}
