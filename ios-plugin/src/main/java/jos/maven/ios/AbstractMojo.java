package jos.maven.ios;

import java.io.File;

import jos.build.Configuration;
import jos.build.types.BuildMode;

import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

public abstract class AbstractMojo extends org.apache.maven.plugin.AbstractMojo {

    @Component
    MavenProject project;

    @Parameter(defaultValue = "${basedir}/src/main/objc", required = true)
    File sourceDirectory;

    @Parameter(defaultValue = "${project.build.directory}", required = true)
    File targetDirectory;

    @Parameter(defaultValue = "${basedir}/src/main/resources", required = true)
    File resourcesDirectory;

    @Parameter(defaultValue = "${project.artifactId}", required = true)
    String name;

    Configuration getConfig(final BuildMode buildMode) {
        final Configuration config = new Configuration(project.getBasedir(),
                buildMode);
        config.setBuildDir(targetDirectory);
        config.setResourcesDir(resourcesDirectory);
        config.setName(name);
        return config;
    }

}
