package jos.build.types;

@SuppressWarnings("serial")
public class BuildError extends Error {

	public BuildError() {
		super();
	}

	public BuildError(String arg0) {
		super(arg0);
	}

	public BuildError(Throwable arg0) {
		super(arg0);
	}

	public BuildError(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
