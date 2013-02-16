package jos.samples.content;

import com.google.devtools.j2objc.J2ObjC;

public class Translate {

    public static void main(String[] args) {
        J2ObjC.main(new String[] {
                "--prefix", "jos.samples.content.screens.iphone=CC",
                "-v",
                //"-use-arc",
                "--no-package-directories",
                "-d", System.getProperty("user.dir") + "/src/xcode",
                "-sourcepath", System.getProperty("user.dir") + "/src/main/java",
                "-classpath", System.getProperty("java.class.path"),
                "src/main/java/jos/samples/content/screens/iphone/ .java"
        });
    }

}
