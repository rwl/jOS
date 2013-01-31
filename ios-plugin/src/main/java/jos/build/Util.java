package jos.build;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import jos.build.types.BuildError;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Function;

public class Util {

    private static final Logger logger = Logger.getLogger(Util.class.getName());

    protected static final Function<File, String> absolutePathFunction = new Function<File, String>() {
		@Override
		public String apply(final File file) {
			return file.getAbsolutePath();
		}
	};

	protected static String sh(final String cmd) {
		String result = "";
		try {
			final Process p = Runtime.getRuntime().exec(cmd);
			result = IOUtils.toString(p.getInputStream());

			if (p.waitFor() != 0) {
				if (!result.isEmpty()) {
					logger.severe(result);
				}
				final String stderr = IOUtils.toString(p.getErrorStream());
				if (!stderr.isEmpty()) {
					logger.severe(stderr);
				}
				throw new BuildError("Error executing command: " + cmd);
			}
		} catch (final IOException e) {
			throw new BuildError("Failed to execute command: " + cmd, e);
		} catch (final InterruptedException e) {
			throw new BuildError("Command interrupted: " + cmd, e);
		}
		return result;
	}

	protected static String sh(final List<String> args) {
		return sh(args.toArray(new String[args.size()]));
	}

	protected static String sh(final String... cmd) {
		String result = "";
		try {
			final Process p = Runtime.getRuntime().exec(cmd);
			result = IOUtils.toString(p.getInputStream());

			if (p.waitFor() != 0) {
				if (!result.isEmpty()) {
					logger.severe(result);
				}
				final String stderr = IOUtils.toString(p.getErrorStream());
				if (!stderr.isEmpty()) {
					logger.severe(stderr);
				}
				throw new BuildError("Problem executing command: " + StringUtils.join(cmd, " "));
			}
		} catch (final IOException e) {
			throw new BuildError("Failed to execute command: " + StringUtils.join(cmd, " "), e);
		} catch (final InterruptedException e) {
			throw new BuildError("Command interrupted: " + StringUtils.join(cmd, " "), e);
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
            throw new BuildError("Failed to execute command (" + dir.getPath() + "): " + cmd, e);
        }
        return result;
    }

	protected static boolean system(final List<String> args) {
		return system(args.toArray(new String[args.size()]));
	}

    protected static boolean system(final String... args) {
        boolean result = false;
        try {
            final Process p = Runtime.getRuntime().exec(args);
            result = p.exitValue() == 0;
        } catch (final IOException e) {
            throw new BuildError("Failed to execute command: "
            		+ StringUtils.join(args, " "), e);
        }
        return result;
    }

    protected static String read(final File file) {
        String contents = "";
        try {
            contents = FileUtils.readFileToString(file);
        } catch (final IOException e) {
        	throw new BuildError("Problem reading from file: " + file.getPath(), e);
        }
        return contents;
    }

    protected static void write(final File file, final String data) {
        try {
            FileUtils.writeStringToFile(file, data);
        } catch (final IOException e) {
        	throw new BuildError("Problem writing to file: " + file.getPath(), e);
        }
    }

	private Util() {
	}

}
