package jos.samples.hello;

import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UIWindow;


public class AppDelegate extends UIApplicationDelegate {

    private HelloViewController viewController;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        this.window = new UIWindow(UIScreen.mainScreen.bounds);
        setWindow(new UIWindow(UIScreen.mainScreen.bounds));

        viewController = new HelloViewController();
        getWindow().rootViewController = viewController;
        getWindow().makeKeyAndVisible();

        System.out.println(toString());

        return true;
    }

    @Override
    public String toString() {
        return "AppDelegate [viewController=" + viewController + "]";
    }
}
