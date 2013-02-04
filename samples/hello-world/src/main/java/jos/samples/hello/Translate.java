package jos.samples.hello;

import com.google.devtools.j2objc.J2ObjC;

public class Translate {

    public static void main(String[] args) {
        System.out.println("SRCPATH " + System.getProperty("user.dir") + "/src/main/java");
        System.out.println("CLASSPATH " + System.getProperty("java.class.path"));

        J2ObjC.main(new String[] {
                "--prefix", "jos.samples.hello=J",
                "-v",
                //"-use-arc",
                "--no-package-directories",
                "-sourcepath", System.getProperty("user.dir") + "/src/main/java",
                "-classpath", System.getProperty("java.class.path"),
                "src/main/java/jos/samples/hello/AppDelegate.java",
                "src/main/java/jos/samples/hello/HelloViewController.java",
                "src/main/java/jos/samples/hello/HelloView.java"
        });
    }

}
