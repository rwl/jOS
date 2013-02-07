package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;

@Model
@Register(isWrapper = true)
public class UIApplicationDelegate extends NSObject {

    public UIWindow window;

    @Export("window")
    public UIWindow getWindow() {
        return window;
    }

    @Export("setWindow:")
    public void setWindow(UIWindow window) {
        this.window = window;
    }

    @Export("init")
    public UIApplicationDelegate() {
    }

    @Export("application:didFinishLaunchingWithOptions:")
    public boolean finishedLaunching(UIApplication application, NSDictionary launchOptions) {
        return false;
    }

    @Export("applicationWillResignActive:")
    public void onResignActivation(UIApplication application) {
    }

    @Export("applicationDidEnterBackground:")
    public void didEnterBackground(UIApplication application) {
    }

    @Export("applicationWillEnterForeground:")
    public void willEnterForeground(UIApplication application) {
    }

    @Export("applicationWillTerminate:")
    public void willTerminate(UIApplication application) {
    }

}
