package jos.maven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.google.devtools.j2objc.J2ObjC;

@Mojo(name = "translate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JOSMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.sourceDirectory}"/*, property = "sourceDirectory"*/, required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${basedir}/src/main/objc"/*, property = "outputDirectory"*/, required = true)
    private File outputDirectory;

    @Parameter
    private boolean ignoreMissingImports;

	public void execute() throws MojoExecutionException, MojoFailureException {
		final Collection<File> files = FileUtils.listFiles(sourceDirectory,
				FileFilterUtils.suffixFileFilter(".java"),
//				  new RegexFileFilter("*.java"),
				  DirectoryFileFilter.DIRECTORY);
		final List<String> args = new ArrayList<String>();

		args.add("-d");
		try {
			args.add(outputDirectory.getCanonicalPath());
		} catch (final IOException e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}

		if (ignoreMissingImports) {
			args.add("--ignore-missing-imports");
		}

		try {
			args.add(outputDirectory.getCanonicalPath());
			for (final File file : files) {
				args.add(file.getCanonicalPath());
			}
		} catch (final IOException e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}

		J2ObjC.main(args.toArray(new String[args.size()]));
	}
}
