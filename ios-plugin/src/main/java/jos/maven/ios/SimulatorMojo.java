package jos.maven.ios;

import jos.build.Builder;
import jos.build.Configuration;
import jos.build.Simulator;
import jos.build.types.BuildMode;
import jos.build.types.Platform;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "simulator")
public class SimulatorMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {

        final Configuration config = getConfig(BuildMode.DEVELOPMENT);

        final Builder builder = new Builder(config, Platform.IPHONE_SIMULATOR);
        builder.compile();
        builder.bundle();

        final Simulator simulator = new Simulator(config);
        simulator.launch();
    }

}
