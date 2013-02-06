package jos.samples.controls.navigation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UIImage;
import jos.api.uikit.UINavigationController;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessory;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewSource;
import jos.api.uikit.UIViewController;

/**
 * Combined DataSource and Delegate for our UITableView.
 */
public class NavItemTableSource extends UITableViewSource {

    protected List<NavItemGroup> navItems;
    String cellIdentifier = "NavTableCellView";
    UINavigationController navigationController;

    public NavItemTableSource(UINavigationController navigationController, List<NavItemGroup> items) {
        navItems = items;
        this.navigationController = navigationController;
    }

    /**
     * Called by the TableView to determine how many sections(groups) there are.
     */
    @Override
    public int numberOfSections(UITableView tableView) {
        return navItems.size();
    }

    /**
     * Called by the TableView to determine how many cells to create for that particular section.
     */
    @Override
    public int rowsInSection(UITableView tableview, int section) {
        return navItems.get(section).items.size();
    }

    /**
     * Called by the TableView to retrieve the header text for the particular section(group)
     */
    @Override
    public String titleForHeader(UITableView tableView, int section) {
        return navItems.get(section).name;
    }

    /**
     * Called by the TableView to retrieve the footer text for the particular section(group)
     */
    @Override
    public String titleForFooter(UITableView tableView, int section) {
        return navItems.get(section).footer;
    }

    /**
     * Called by the TableView to actually build each cell.
     */
    @Override
    public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath) {
        NavItem navItem = navItems.get(indexPath.section).items.get(indexPath.row);
        UIImage navIcon = null;

        UITableViewCell cell = tableView.dequeueReusableCell(this.cellIdentifier);
        if (cell == null) {
            cell = new UITableViewCell (UITableViewCellStyle.Default, this.cellIdentifier);
            cell.tag = (int) System.currentTimeMillis();
        }

        // set the cell properties
        cell.textLabel.text = navItems.get(indexPath.section).items.get(indexPath.row).name;
        cell.accessory = UITableViewCellAccessory.DisclosureIndicator;

        // return the cell
        return cell;
    }


    /**
     * Is called when a row is selected.
     */
    @Override
    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {
        // get a reference to the nav item
        NavItem navItem = navItems.get(indexPath.section).items.get(indexPath.row);

        // if the nav item has a proper controller, push it on to the NavigationController
        // NOTE: we could also raise an event here, to loosely couple this, but isn't neccessary,
        // because we'll only ever use this this way
        if (navItem.controller != null) {
            navigationController.pushViewController(navItem.controller, true);
            // show the nav bar (we don't show it on the home page)
            navigationController.navigationBarHidden = false;
        } else {
            if (navItem.controllerType != null) {
                Constructor<? extends UIViewController> ctor = null;

                // if the nav item has constructor aguments
                try {
                    if (navItem.getControllerConstructorArgs().length > 0) {
                        // look for the constructor
                        ctor = navItem.controllerType.getConstructor(navItem.controllerConstructorTypes);
                    } else {
                        // search for the default constructor
                        ctor = navItem.controllerType.getConstructor();
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                // if we found the constructor
                if (ctor != null) {
                    UIViewController instance = null;

                    try {
                        if (navItem.getControllerConstructorArgs().length > 0) {
                            // instance the view controller
                            instance = (UIViewController) ctor.newInstance(navItem.getControllerConstructorArgs());
                        } else {
                            // instance the view controller
                            instance = (UIViewController) ctor.newInstance(new Object[] {null});
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    if (instance != null) {
                        // save the object
                        navItem.controller = instance;

                        // push the view controller onto the stack
                        navigationController.pushViewController(navItem.controller, true);
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
