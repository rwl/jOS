package jos.samples.hello;

import java.io.File;

import jos.maven.Builder;
import jos.maven.Configuration;
import jos.maven.Simulator;
import jos.maven.types.Platform;
import jos.maven.types.BuildMode;

public class Build {

    public static void main(String[] args) {

        final File base = new File(System.getProperty("user.dir"));

        final Configuration config = new Configuration(base, BuildMode.DEVELOPMENT);
        config.setBuildDir(new File(base, "target"));
        config.setResourcesDir(new File(base, "src/main/resources"));
        config.setName("Hello");

        Builder.build(config, Platform.IPHONE_SIMULATOR);
        
        final Simulator sim = new Simulator(config);
        sim.launch();
    }

}
