/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

import com.google.common.collect.Maps;

import jos.build.Configuration.BuildMode;

public class Application {

	private static final Logger logger = Logger.getLogger(Application.class
			.getName());

	public static boolean VERBOSE = false;

	private static BuildMode config_mode;
	private static Map<BuildMode, Configuration> configs;
	private static Builder builder;

	public static BuildMode config_mode() {
		if (config_mode == null) {
			if (System.getenv().containsKey("mode")) {
				final BuildMode mode = BuildMode.valueOf(System.getenv().get(
						"mode"));
				switch (mode) {
				case DEVELOPMENT:
				case RELEASE:
					config_mode = mode;
				default:
					fail("Invalid value for build mode `" + mode
							+ "' (must be DEVELOPMENT or RELEASE)");
					config_mode = BuildMode.DEVELOPMENT;
				}
			} else {
				config_mode = BuildMode.DEVELOPMENT;
			}
		}
		return config_mode;
	}

	public static Configuration config_without_setup() {
		if (configs == null) {
			configs = Maps.newHashMap();
		}
		if (!configs.containsKey(config_mode)) {
			configs.put(config_mode(),
					new Configuration(new File(System.getProperty("user.dir")),
							config_mode()));
		}
		return configs.get(config_mode());
	}

	public static Configuration config() {
		final Configuration c = config_without_setup();
		c.setup();
		return c;
	}

	public static Builder builder() {
		if (builder == null) {
			builder = new Builder();
		}
		return builder;
	}

	public static void build(final String platform) {
		build(platform, Collections.<String, String> emptyMap());
	}

	public static void build(final String platform, Map<String, String> opts) {
		builder().build(config(), platform, opts);
	}

	public static void archive() {
		builder.archive(config());
	}

	public static void codesign(final String platform) {
		builder().codesign(config(), platform);
	}

	public static void fail(final String msg) {
		logger.severe(msg);
		System.exit(1);
	}

	public static void warn(final String msg) {
		logger.warning(msg);
	}

	public static void info(final String msg) {
		if (!VERBOSE) {
			logger.info(msg);
		}
	}

	private Application() {
	}
}
