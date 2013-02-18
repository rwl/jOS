package jos.samples.lists;

import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UINavigationController;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UIWindow;
import jos.samples.lists.screens.HomeNavController;

public class AppDelegate extends UIApplicationDelegate {

    UINavigationController navController;
    HomeNavController iPhoneHome;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {

        // create our window
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible ();

        // create our navigation controller
        navController = new UINavigationController();

        // create the home screen and add it to the nav controller
        iPhoneHome = new HomeNavController();
        navController.pushViewController(iPhoneHome, false);

        window.setRootViewController(navController);

        return true;
    }

}
