package jos.uikit;

import jos.api.Export;
import jos.api.Register;
import jos.foundation.NSDictionary;
import jos.foundation.NSObject;


@Register(isWrapper = true)
public class UIApplicationDelegate extends NSObject {
    
    public UIWindow window;
    
    @Export(selector = "init")
    public UIApplicationDelegate() {
    }

    @Export(selector = "application:didFinishLaunchingWithOptions:")
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        return false;
    }
}
