package jos.maven;

import java.io.File;

import jos.build.Application.Platform;
import jos.build.Builder;
import jos.build.Configuration;
import jos.build.Configuration.BuildMode;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.google.common.collect.Maps;

@Mojo(name = "build", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class BuildMojo extends AbstractMojo {

    @Component
    private MavenProject project;

    /*
     * @Component private MavenSession session;
     *
     * @Component private MojoExecution mojo;
     *
     * @Component // for Maven 3 only private PluginDescriptor plugin;
     *
     * @Component private Settings settings;
     */

    @Parameter(defaultValue = "${basedir}/src/main/objc", required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${project.build.directory}/jos", required = true)
    private File targetDirectory;

    @Parameter(defaultValue = "${basedir}/src/main/resources", required = true)
    private File resourcesDirectory;

    @Parameter(defaultValue = "${project.artifactId}", required = true)
    private String name;

    public void execute() throws MojoExecutionException, MojoFailureException {

        final Configuration config = new Configuration(project.getBasedir(),
                BuildMode.DEVELOPMENT);
        config.setBuildDir(targetDirectory);
        config.setResourcesDir(resourcesDirectory);
        config.setName(name);

        new Builder().build(config, Platform.IPHONE_SIMULATOR,
                Maps.<String, String> newHashMap());
    }

}
