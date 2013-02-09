package jos.samples.controls;

import com.google.devtools.j2objc.J2ObjC;

import junit.framework.TestCase;

public class TranslationTest extends TestCase {

    public void testTranslation() {

        System.out.println("SRCPATH " + System.getProperty("user.dir") + "/src/main/java");
        System.out.println("CLASSPATH " + System.getProperty("java.class.path"));

        J2ObjC.main(new String[] {
                "--prefix", "jos.samples.controls.screens.iphone=SC",
                "-v",
                //"-use-arc",
                "--no-package-directories",
                "-d", System.getProperty("user.dir") + "/src/xcode",
                "-sourcepath", System.getProperty("user.dir") + "/src/main/java",
                "-classpath", System.getProperty("java.class.path"),
                //"src/main/java/jos/samples/controls/AppDelegate.java",
                "src/main/java/jos/samples/controls/screens/iphone/ButtonsScreen.java"
        });
    }

}
