package jos.samples.controls.screens.ipad.home;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.samples.controls.code.NavItem;
import jos.samples.controls.code.NavItemGroup;
import jos.samples.controls.code.NavItemTableSource;
import jos.samples.controls.screens.ipad.actionsheets.ActionSheets_iPad;
import jos.samples.controls.screens.ipad.datepicker.DatePickerSimple_iPad;

public class HomeNavController extends UITableViewController {

    List<NavItemGroup> navItems = new ArrayList<NavItemGroup>();
    NavItemTableSource tableSource;

    public HomeNavController() {
        super();
    }

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
        navGroup.items.add(new NavItem("Action Sheets", "", ActionSheets_iPad.class));

        navGroup = new NavItemGroup("Pickers");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Simple Date Picker", "", DatePickerSimple_iPad.class));
        // navGroup.items.add(new NavItem("Action Sheet Date Picker", "",
        // ActionSheetDatePicker_iPad.class));

        // create a table source from our nav items
        tableSource = new NavItemTableSource(navigationController, navItems);

        // set the source on the table to our data source
        super.tableView.source = tableSource;
    }
}
