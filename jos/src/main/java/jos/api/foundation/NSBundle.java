package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSBundle extends NSObject {

    public static NSBundle mainBundle;

    @Export("mainBundle")
    public static NSBundle getMainBundle() {
        return mainBundle;
    }

    public String bundlePath;

    @Export("bundlePath")
    public String getBundlePath() {
        return bundlePath;
    }

}
