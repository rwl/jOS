package jos.samples.hello;

import jos.foundation.NSDictionary;
import jos.uikit.UIApplication;
import jos.uikit.UIApplicationDelegate;
import jos.uikit.UIScreen;
import jos.uikit.UIWindow;


public class AppDelegate extends UIApplicationDelegate {

    private HelloViewController viewController;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        this.window = new UIWindow(UIScreen.mainScreen.bounds);

        viewController = new HelloViewController();
        this.window.rootViewController = viewController;
        this.window.makeKeyAndVisible();

        return true;
    }
}
