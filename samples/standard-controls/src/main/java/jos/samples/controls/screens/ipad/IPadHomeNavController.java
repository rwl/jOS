package jos.samples.controls.screens.ipad;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.samples.controls.navigation.NavItem;
import jos.samples.controls.navigation.NavItemGroup;
import jos.samples.controls.navigation.NavItemTableDataSource;
import jos.samples.controls.navigation.NavItemTableDelegate;

public class IPadHomeNavController extends UITableViewController {

    private final List<NavItemGroup> navItems = new ArrayList<NavItemGroup>();

    private NavItemTableDataSource tableSource;

    private NavItemTableDelegate tableDelegate;

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        // hide the nav bar when this controller appears
        navigationController.setNavigationBarHidden(true, true);
    }

    @Override
    public void viewWillDisappear(boolean animated) {
        super.viewWillDisappear(animated);
        // show the nav bar when other controllers appear
        navigationController.setNavigationBarHidden(false, true);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // create the navigation items
        NavItemGroup navGroup = new NavItemGroup("Form Controls");

        navGroup = new NavItemGroup("Popups");
        navItems.add(navGroup);
        // navGroup.items.add(new NavItem("Alert Views", "",
        // AlertViewsScreen_iPhone.class));
        navGroup.getItems().add(new NavItem("Action Sheets", ActionSheets.class));

        navGroup = new NavItemGroup("Pickers");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Simple Date Picker", DatePickerSimple.class));
        // navGroup.getItems().add(new NavItem("Action Sheet Date Picker", "",
        // DatePicker.class));

        // create a table source from our nav items
        tableSource = new NavItemTableDataSource(navItems);
        tableDelegate = new NavItemTableDelegate(navigationController, navItems);

        // set the source on the table to our data source
        tableView.setDataSource(tableSource);
        tableView.setTableViewDelegate(tableDelegate);
    }

}
