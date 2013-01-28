/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

import jos.build.Configuration.BuildMode;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class
            .getName());

    public static enum Platform {
        IPHONE_OS ("iPhoneOS"),
        IPHONE_SIMULATOR ("iPhoneSimulator");

        private final String platform;

        private Platform(final String platform) {
            this.platform = platform;
        }

        public String getPlatform() {
            return platform;
        }
    }

    public static enum Architecture {
        I386 ("x86"),
        X86_64 ("x86-64"),
        ARM ("arm");

        private final String arch;

        private Architecture(final String arch) {
            this.arch = arch;
        }

        public String getArch() {
            return arch;
        }
    }

    public static boolean VERBOSE = false;

    private static BuildMode configMode;
    private static Map<BuildMode, Configuration> configs;

    public static BuildMode getConfigMode() {
        if (configMode == null) {
            if (System.getenv().containsKey("mode")) {
                final BuildMode mode = BuildMode.valueOf(System.getenv().get(
                        "mode"));
                switch (mode) {
                case DEVELOPMENT:
                case RELEASE:
                    configMode = mode;
                default:
                    fail("Invalid value for build mode `" + mode
                            + "' (must be DEVELOPMENT or RELEASE)");
                    configMode = BuildMode.DEVELOPMENT;
                }
            } else {
                configMode = BuildMode.DEVELOPMENT;
            }
        }
        return configMode;
    }

    public static Configuration getConfigWithoutSetup() {
        if (configs == null) {
            configs = Maps.newHashMap();
        }
        if (!configs.containsKey(getConfigMode())) {
            configs.put(getConfigMode(),
                    new Configuration(new File(System.getProperty("user.dir")),
                            getConfigMode()));
        }
        return configs.get(getConfigMode());
    }

    public static Configuration getConfig() {
        final Configuration c = getConfigWithoutSetup();
        c.setup();
        return c;
    }

    public static File build(final Platform platform) {
        return build(platform, Collections.<String, String> emptyMap());
    }

    public static File build(final Platform platform, Map<String, String> opts) {
        return Builder.build(getConfig(), platform, opts);
    }

    public static void archive() {
        Builder.archive(getConfig());
    }

    public static void codeSign(final Platform platform) {
        Builder.codeSign(getConfig(), platform);
    }

    public static void fail(final String msg) {
        logger.severe(msg);
        System.exit(1);
    }

    public static void warn(final String msg) {
        logger.warning(msg);
    }

    public static void info(final String msg) {
        info("", msg);
    }

    public static void info(String what, final String msg) {
        if (!VERBOSE) {
            if (!StringUtils.isEmpty(what)) {
                what = " " + (char) 27 + "[1m" + String.format("%10s", what)
                        + (char) 27 + "[0m"; // bold
            }
            logger.info(what + msg);
        }
    }

    public static void info(String what, final File path) {
        info(what, path.getPath());
    }

    public static String sh(final String cmd) {
        String result = "";
        try {
            final Process p = Runtime.getRuntime().exec(cmd);
            result = IOUtils.toString(p.getInputStream());
        } catch (final IOException e) {
            fail("Failed to execute command: " + cmd);
        }
        return result;
    }

    protected static String sh(final String cmd, final File dir) {
        assert dir.isDirectory();
        final ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(dir);
        String result = "";
        try {
            final Process p = pb.start();
            result = IOUtils.toString(p.getInputStream());
        } catch (final IOException e) {
            fail("Failed to execute command (" + dir.getPath() + "): " + cmd);
        }
        return result;
    }

    public static boolean system(final String cmd) {
        boolean result = false;
        try {
            final Process p = Runtime.getRuntime().exec(cmd);
            result = p.exitValue() == 0;
        } catch (final IOException e) {
            fail("Failed to execute command: " + cmd);
        }
        return result;
    }

    protected static String read(final File file) {
        String contents = "";
        try {
            contents = FileUtils.readFileToString(file);
        } catch (final IOException e) {
            fail("Problem encountered reading file: " + file.getPath());
        }
        return contents;
    }

    protected static void write(final File file, final String data) {
        try {
            FileUtils.writeStringToFile(file, data);
        } catch (final IOException e) {
            fail("Problem encountered writing file: " + file.getPath());
        }
    }

    private Application() {
    }
}
