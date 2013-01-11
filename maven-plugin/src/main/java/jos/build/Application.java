package jos.build;

import java.util.logging.Logger;

public class Application {

	private static final Logger logger = Logger.getLogger(Application.class.getName());

	public static void fail(final String msg) {
		logger.severe(msg);
		System.exit(1);
	}

	public static void warn(final String msg) {
		logger.warning(msg);
	}
}
