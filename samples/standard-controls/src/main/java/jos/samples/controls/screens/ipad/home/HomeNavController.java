package jos.samples.controls.screens.ipad.home;

import java.util.List;

import jos.api.uikit.UIViewController;
import jos.samples.controls.code.NavItem;
import jos.samples.controls.code.NavItemGroup;

public class HomeNavController extends UIViewController {

    List<NavItemGroup> navItems = new ArrayList<NavItemGroup>();
    NavItemTableSource tableSource;

    public HomeNavController() {
        super();
    }

    @Override
    public void viewWillAppear(boolean animated)
    {
        super.viewWillAppear(animated);
        // hide the nav bar when this controller appears
        NavigationController.setNavigationBarHidden(true, true);
    }

    public override void ViewWillDisappear (bool animated)
    {
        base.ViewWillDisappear (animated);
        // show the nav bar when other controllers appear
        navigationController.setNavigationBarHidden(false, true);
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        // create the navigation items
        NavItemGroup navGroup = new NavItemGroup ("Form Controls");

        navGroup = new NavItemGroup ("Popups");
        navItems.add (navGroup);
        //navGroup.items.add (new NavItem ("Alert Views", "", typeof(AlertViews.AlertViewsScreen_iPhone)));
        navGroup.items.add (new NavItem ("Action Sheets", "", typeof(ActionSheets.ActionSheets_iPad)));

        navGroup = new NavItemGroup ("Pickers");
        navItems.add (navGroup);
        navGroup.items.add (new NavItem ("Simple Date Picker", "", typeof(DatePicker.DatePickerSimple_iPad)));
        //navGroup.items.add (new NavItem ("Action Sheet Date Picker", "", typeof(DatePicker.ActionSheetDatePicker_iPad)));

        // create a table source from our nav items
        tableSource = new NavItemTableSource (navigationController, navItems);

        // set the source on the table to our data source
        super.tableView.source = tableSource;
    }
}
