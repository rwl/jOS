/*
 * Copyright (C) 2012 HipByte SPRL and contributors
 */
package jos.build;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import jos.build.Application.Platform;

public class Vendor {

	private final File path;
	public List<File> libs;
	public List<File> bs_files;

	public Vendor(final File path, final String type, final Configuration configuration,
			final Map<String, String> opts) {
		this.path = path;
	}

	public File getPath() {
		return path;
	}

	public void build(final Platform platform) {
	}

	public void clean() {
	}
}
