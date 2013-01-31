package jos.samples.hello;

import java.io.File;

import jos.build.Builder;
import jos.build.Configuration;
import jos.build.types.BuildMode;
import jos.build.types.Platform;

public class Build {

    public static void main(String[] args) {

        final File base = new File(System.getProperty("user.dir"));

        final Configuration config = new Configuration(base, BuildMode.DEVELOPMENT);
        config.setBuildDir(new File(base, "target"));
        config.setResourcesDir(new File(base, "src/main/resources"));
        config.setName("Hello");

        final Builder builder = new Builder(config, Platform.IPHONE_SIMULATOR);
        builder.compile();
        builder.bundle();

        /*final Simulator sim = new Simulator(config);
        sim.launch();*/
    }

}
