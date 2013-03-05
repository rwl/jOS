package jos.samples.content.screens.iphone.tabs;

import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UINavigationController;
import jos.api.uikit.UITabBarController;
import jos.api.uikit.UITabBarItem;
import jos.api.uikit.UITabBarSystemItem;
import jos.api.uikit.UIViewController;
import jos.samples.content.screens.iphone.browsers.BrowsersHome;
import jos.samples.content.screens.iphone.customizingnavbar.CustomizingNavBarScreen;
import jos.samples.content.screens.iphone.extra.CustomizableTabScreen;
import jos.samples.content.screens.iphone.maps.MapsHome;
import jos.samples.content.screens.iphone.search.SearchScreen;

public class TabBarController extends UITabBarController {

    UINavigationController browsersTabNavController;
    BrowsersHome browsersHome;
    SearchScreen searchScreen;
    UINavigationController mapsTabNavController;
    MapsHome mapsHome;
    UINavigationController customizeNavBarNavController;
    CustomizingNavBarScreen customizingNavBarScreen;

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        // browsers tab
        // in this case, we create a navigation controller and then add our screen
        // to that
        browsersTabNavController = new UINavigationController();
        browsersTabNavController.setTabBarItem(new UITabBarItem());
        browsersTabNavController.getTabBarItem().setTitle("Browsers");
        browsersHome = new BrowsersHome();
        browsersTabNavController.pushViewController(browsersHome, false);

        // maps tab
        mapsTabNavController = new UINavigationController();
        mapsTabNavController.setTabBarItem(new UITabBarItem());
        mapsTabNavController.getTabBarItem().setTitle("Maps");
        mapsHome = new MapsHome();
        mapsTabNavController.pushViewController(mapsHome, false);

        // search
        searchScreen = new SearchScreen();
        searchScreen.setTabBarItem(new UITabBarItem(UITabBarSystemItem.SEARCH, 1));

        // custom nav bar
        customizeNavBarNavController = new UINavigationController();
        customizeNavBarNavController.setTabBarItem(new UITabBarItem());
        customizeNavBarNavController.getTabBarItem().setTitle("Nav");
        customizingNavBarScreen = new CustomizingNavBarScreen();
        customizeNavBarNavController.pushViewController(customizingNavBarScreen, false);

        // set a badge, just for fun
        customizeNavBarNavController.getTabBarItem().setBadgeValue("3");

        // create our array of controllers
        UIViewController[] viewControllers = new UIViewController[] {
            browsersTabNavController,
            mapsTabNavController,
            searchScreen,
            customizeNavBarNavController,
            new CustomizableTabScreen("1"),
            new CustomizableTabScreen("2"),
            new CustomizableTabScreen("3"),
            new CustomizableTabScreen("4"),
            new CustomizableTabScreen("5")
        };

        // create an array of customizable controllers from just the
        // ones we want to customize.
        UIViewController[] customizableControllers = new UIViewController[] {
            viewControllers[2],
            viewControllers[3],
            viewControllers[4],
            viewControllers[5],
            viewControllers[6]
        };

        // attach the view controllers
        setViewControllers(viewControllers);

        // tell the tab bar which controllers are allowed to customize. if we
        // don't set this, it assumes all controllers are customizable.
        setCustomizableViewControllers(customizableControllers);

        // set our selected item
        setSelectedViewController(browsersTabNavController);
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation orientation) {
        return true;
    }
}
