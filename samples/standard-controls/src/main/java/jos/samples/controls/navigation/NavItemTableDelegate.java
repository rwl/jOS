package jos.samples.controls.navigation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UINavigationController;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewDelegate;
import jos.api.uikit.UIViewController;


public class NavItemTableDelegate extends UITableViewDelegate {

    private final List<NavItemGroup> navItems;

    private final UINavigationController navigationController;

    public NavItemTableDelegate(UINavigationController navigationController, List<NavItemGroup> items) {
        navItems = items;
        this.navigationController = navigationController;
    }

    /**
     * Is called when a row is selected.
     */
    @Override
    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {
        // get a reference to the nav item
        NavItem navItem = navItems.get(indexPath.getSection()).getItems().get(indexPath.getRow());

        // if the nav item has a proper controller, push it on to the NavigationController
        if (navItem.getController() != null) {
            navigationController.pushViewController(navItem.getController(), true);
            // show the nav bar (we don't show it on the home page)
            navigationController.setNavigationBarHidden(false);
        } else {
            if (navItem.getControllerType() != null) {
                Constructor<? extends UIViewController> ctor = null;
                try {
                    ctor = navItem.getControllerType().getConstructor();
                } catch (SecurityException e1) {
                } catch (NoSuchMethodException e1) {
                }

                // if we found the constructor
                if (ctor != null) {
                    UIViewController instance = null;

                    try {
                        instance = (UIViewController) ctor.newInstance();
                    } catch (IllegalArgumentException e) {
                    } catch (InstantiationException e) {
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e) {
                    }

                    if (instance != null) {
                        // save the object
                        navItem.setController(instance);

                        // push the view controller onto the stack
                        navigationController.pushViewController(navItem.getController(), true);
                    } else {
                        System.out.println("instance of view controller not created");
                    }
                } else {
                    System.out.println("constructor not found");
                }
            }
        }
    }

}
