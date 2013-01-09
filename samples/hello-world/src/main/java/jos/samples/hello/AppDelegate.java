package jos.samples.hello;

import jos.foundation.NSDictionary;
import jos.uikit.UIApplication;
import jos.uikit.UIApplicationDelegate;
import jos.uikit.UIScreen;
import jos.uikit.UIWindow;


public class AppDelegate extends UIApplicationDelegate {

    private UIWindow window;
    private HelloViewController viewController;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        window = new UIWindow(UIScreen.mainScreen.bounds);

        viewController = new HelloViewController();
        window.rootViewController = viewController;
        window.makeKeyAndVisible();

        return true;
    }
}
