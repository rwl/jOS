package jos.samples.content;

import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UIWindow;

public class AppDelegate extends UIApplicationDelegate {

    private jos.samples.content.screens.iphone.tabs.TabBarController iPhoneTabs;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        this.window = new UIWindow(UIScreen.mainScreen.bounds);
        this.window.makeKeyAndVisible();

        // create the tab controller
        iPhoneTabs = new jos.samples.content.screens.iphone.tabs.TabBarController();

        this.window.setRootViewController(iPhoneTabs);
        return true;
    }

}
