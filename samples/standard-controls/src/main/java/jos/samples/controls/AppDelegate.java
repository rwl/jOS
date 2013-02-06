package jos.samples.controls;

import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UINavigationController;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UIUserInterfaceIdiom;
import jos.api.uikit.UIWindow;

public class AppDelegate extends UIApplicationDelegate {

    private UIWindow window;
    private UINavigationController mainNavController;
    private jos.samples.controls.screens.iphone.home.HomeNavController iPhoneHome;
    private jos.samples.controls.screens.ipad.home.HomeNavController iPadHome;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        window = new UIWindow(UIScreen.mainScreen.bounds);
        window.makeKeyAndVisible();

        mainNavController = new UINavigationController();

        if (UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiom.Phone) {
            iPhoneHome = new jos.samples.controls.screens.iphone.home.HomeNavController();
            mainNavController.pushViewController(iPhoneHome, false);
        } else {
            iPadHome = new jos.samples.controls.screens.ipad.home.HomeNavController();
            mainNavController.pushViewController(iPadHome, false);
        }

        window.rootViewController = mainNavController;
        return true;
    }

}
