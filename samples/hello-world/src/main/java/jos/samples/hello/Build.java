package jos.samples.hello;

import java.io.File;

import jos.build.Builder;
import jos.build.Configuration;
import jos.build.Application.Platform;
import jos.build.Configuration.BuildMode;

import com.google.common.collect.Maps;

public class Build {

    public static void main(String[] args) {

        final File base = new File(System.getProperty("user.dir"));

        final Configuration config = new Configuration(base, BuildMode.DEVELOPMENT);
        config.setBuildDir(new File(base, "target/jos"));
        config.setResourcesDir(new File(base, "src/main/resources"));
        config.setName("hello");

        Builder.build(config, Platform.IPHONE_SIMULATOR,
                Maps.<String, String> newHashMap());
    }

}
