package jos.maven.j2objc;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.google.common.collect.Lists;
import com.google.devtools.j2objc.J2ObjC;

@Mojo(name = "translate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.COMPILE)
public class TranslateMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.compileClasspathElements}", required = true, readonly = true)
    @SuppressWarnings("rawtypes")
    private List classpathElements;

    @Parameter(defaultValue = "${project.build.sourceDirectory}", required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${basedir}/src/main/objc", required = true)
    private File outputDirectory;

    @Parameter
    private boolean ignoreMissingImports;

    @Parameter
    private String prefix;

    @Parameter(defaultValue = "false")
    private boolean verbose;

    @Parameter(defaultValue = "false")
    private boolean useARC;

    @Parameter(defaultValue = "false")
    private boolean noPackageDirectories;

    public void execute() throws MojoExecutionException, MojoFailureException {
        final List<String> args = Lists.newArrayList();

        if (ignoreMissingImports) {
            args.add("--ignore-missing-imports");
        }

        if (!StringUtils.isEmpty(prefix)) {
            args.add("--prefix");
            args.add(prefix);
        }

        if (verbose) {
            args.add("-v");
        }

        if (useARC) {
            args.add("-use-arc");
        }

        if (noPackageDirectories) {
            args.add("--no-package-directories");
        }

        args.add("-classpath");
        args.add(StringUtils.join(classpathElements, ":"));

        args.add("-d");
        try {
            args.add(outputDirectory.getCanonicalPath());
        } catch (final IOException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }

        final Collection<File> files = FileUtils.listFiles(sourceDirectory,
                FileFilterUtils.suffixFileFilter(".java"),
                DirectoryFileFilter.DIRECTORY);
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
