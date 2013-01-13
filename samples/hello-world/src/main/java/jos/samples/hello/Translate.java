package jos.samples.hello;

import jos.j2objc.JOSPlugin;

import com.google.devtools.j2objc.J2ObjC;
import com.google.devtools.j2objc.Options;

public class Translate {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        Options.getPlugins().add(new JOSPlugin());

        J2ObjC.main(new String[] {"-sourcepath",
                "/home/rwl/java/jOS/jos/samples/hello-world/src/main/java",
                "-classpath",
                System.getProperty("java.class.path"),
                //                "src/main/java/jos/samples/hello/Hello.java",
                "src/main/java/jos/samples/hello/AppDelegate.java",
        "src/main/java/jos/samples/hello/HelloViewController.java"});
    }
}
