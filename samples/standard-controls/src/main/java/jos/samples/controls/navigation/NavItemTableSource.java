package jos.samples.controls.navigation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jos.api.foundation.NSIndexPath;
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

    final List<NavItemGroup> navItems;

    String cellIdentifier = "NavTableCellView";

    final UINavigationController navigationController;

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
        return navItems.get(section).getItems().size();
    }

    /**
     * Called by the TableView to retrieve the header text for the particular section(group)
     */
    @Override
    public String titleForHeader(UITableView tableView, int section) {
        return navItems.get(section).getName();
    }

    /**
     * Called by the TableView to retrieve the footer text for the particular section(group)
     */
    @Override
    public String titleForFooter(UITableView tableView, int section) {
        return navItems.get(section).getFooter();
    }

    /**
     * Called by the TableView to actually build each cell.
     */
    @Override
    public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = tableView.dequeueReusableCell(this.cellIdentifier);
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.Default, this.cellIdentifier);
            cell.tag = (int) System.currentTimeMillis();
        }

        // set the cell properties
        cell.textLabel.text = navItems.get(indexPath.section).getItems().get(indexPath.row).getName();
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
        NavItem navItem = navItems.get(indexPath.section).getItems().get(indexPath.row);

        // if the nav item has a proper controller, push it on to the NavigationController
        if (navItem.getController() != null) {
            navigationController.pushViewController(navItem.getController(), true);
            // show the nav bar (we don't show it on the home page)
            navigationController.navigationBarHidden = false;
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
                        System.err.println("instance of view controller not created");
                    }
                } else {
                    System.err.println("constructor not found");
                }
            }
        }
    }

}
