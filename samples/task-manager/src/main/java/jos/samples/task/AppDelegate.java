package jos.samples.task;

import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UINavigationController;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UITableViewController;
import jos.api.uikit.UIUserInterfaceIdiom;
import jos.api.uikit.UIWindow;
import jos.samples.task.screens.iphone.IPhoneController;

public class AppDelegate extends UIApplicationDelegate {

    UINavigationController _navController;
    UITableViewController _homeViewController;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        // create a new window instance based on the screen size
        window = new UIWindow(UIScreen.getMainScreen().getBounds());

        // make the window visible
        window.makeKeyAndVisible();

        // create our nav controller
        this._navController = new UINavigationController();

        // create our home controller based on the device
        if (UIDevice.getCurrentDevice().getUserInterfaceIdiom() == UIUserInterfaceIdiom.PHONE) {
            this._homeViewController = new IPhoneController();
        } else {
            // this._viewController = new Hello_UniversalViewController("Hello_UniversalViewController_iPad", null);
        }

        // push the view controller onto the nav controller and show the window
        _navController.pushViewController(_homeViewController, false);
        window.setRootViewController(_navController);
        window.makeKeyAndVisible();

        return true;
    }

}
