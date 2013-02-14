package jos.maven.ios;

import jos.build.Builder;
import jos.build.types.BuildMode;
import jos.build.types.Platform;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "bundle", defaultPhase = LifecyclePhase.PACKAGE)
public class BundleMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        new Builder(getConfig(BuildMode.DEVELOPMENT), Platform.IPHONE_SIMULATOR).bundle();
    }

}
