package jos.maven.ios;

import jos.build.Simulator;
import jos.build.types.BuildError;
import jos.build.types.BuildMode;
import jos.build.types.Family;
import jos.build.types.Retina;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "simulator")
public class SimulatorMojo extends AbstractMojo {

	@Parameter
	String simulatorFamily;

    @Parameter(defaultValue = "false")
    boolean retina;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
	        final Simulator simulator = new Simulator(getConfig(BuildMode.DEVELOPMENT));
	        if (simulatorFamily != null) {
	        	try {
	        		simulator.setFamily(Family.valueOf(simulatorFamily.toUpperCase()));
	        	} catch (final IllegalArgumentException e) {
	        		throw new MojoExecutionException("Invalid device family: " + simulatorFamily, e);
	        	}
	        }
	        if (retina) {
	        	simulator.setRetina(Retina.TRUE);
	        }
	        simulator.launch();
		} catch (final BuildError e) {
			throw new MojoExecutionException("Compilation error occurred", e);
		}
    }

}
