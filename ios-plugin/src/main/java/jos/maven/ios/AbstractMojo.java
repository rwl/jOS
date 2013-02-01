package jos.maven.ios;

import java.io.File;

import jos.build.Configuration;
import jos.build.types.BuildMode;

import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.google.common.collect.Lists;

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

    @Parameter
    File[] libraries;

    @Parameter
    File[] includes;

    @Parameter
    String delegateClassName;

    Configuration getConfig(final BuildMode buildMode) {
        final Configuration config = new Configuration(project.getBasedir(),
                buildMode);
        config.setSourceDir(sourceDirectory);
        config.setBuildDir(targetDirectory);
        config.setResourcesDir(resourcesDirectory);
        config.setName(name);
        if (libraries != null) {
        	config.setLibs(Lists.newArrayList(libraries));
        }
        if (includes != null) {
        	config.setHeaders(Lists.newArrayList(includes));
        }
        if (delegateClassName != null) {
        	config.setDelegateClassName(delegateClassName);
        }
        return config;
    }

}
