package jos.samples.controls.screens.iphone.home;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.controls.code.NavItem;
import jos.samples.controls.code.NavItemGroup;
import jos.samples.controls.code.NavItemTableSource;

public class HomeNavController extends UITableViewController {

    private List<NavItemGroup> navItems = new ArrayList<NavItemGroup>();
    private NavItemTableSource tableSource;

    public HomeNavController() {
        super(UITableViewStyle.Grouped);
    }

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        // hide the nav bar when this controller appears
        this.navigationController.setNavigationBarHidden(true, true);
    }

    @Override
    public void viewWillDisappear(boolean animated) {
        super.viewWillDisappear(animated);
        // show the nav bar when other controllers appear
        this.navigationController.setNavigationBarHidden(false, true);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // create the navigation items
        NavItemGroup navGroup = new NavItemGroup("Form Controls");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Labels", "", Labels.LabelsScreen_iPhone.class));
        navGroup.items.add(new NavItem("Text Fields", "", TextFields.TextFields_iPhone.class));
        navGroup.items.add(new NavItem("Sliders", "", Sliders.Sliders_iPhone.class));
        navGroup.items.add(new NavItem("Buttons", "", Buttons.ButtonsScreen_iPhone.class));
        navGroup.items.add(new NavItem("Switches", "", Switches.Switches_iPhone.class));
        navGroup.items.add(new NavItem("Segmented Buttons", "", SegmentedControl.SegmentedControls_iPhone.class));
        navGroup.items.add(new NavItem("Segmented Buttons 2", "", SegmentedControl.SegmentedControls2_iPhone.class));

        navGroup = new NavItemGroup ("Content Controls");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Scroll View", "", ScrollView.Controller.class));
        navGroup.items.add(new NavItem("Tap to Zoom Scroll View", "", TapToZoomScrollView.Controller.class));
        navGroup.items.add(new NavItem("Pager Control", "", PagerControl.PagerControl_iPhone.class));
        navGroup.items.add(new NavItem("Image Control", "", Images.Images_iPhone.class));
        navGroup.items.add(new NavItem("More Image Controls", "", Images.Images2_iPhone.class));

        navGroup = new NavItemGroup ("Process Controls");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Activity Spinners", "", ActivitySpinner.ActivitySpinnerScreen_iPhone.class));
        navGroup.items.add(new NavItem("Progress Bars", "", ProgressBars.ProgressBars_iPhone.class));

        navGroup = new NavItemGroup ("Popups");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Alert Views", "", AlertViews.AlertViewsScreen_iPhone.class));
        navGroup.items.add(new NavItem("Action Sheets", "", ActionSheets.ActionSheets_iPhone.class));

        navGroup = new NavItemGroup ("Pickers");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Simple Date Picker", "", DatePicker.DatePickerSimple_iPhone.class));
        navGroup.items.add(new NavItem("Date Picker", "", DatePicker.DatePicker_iPhone.class));
        navGroup.items.add(new NavItem("Simple Custom Picker", "", PickerView.PickerView1_iPhone.class));
        navGroup.items.add(new NavItem("Custom Picker with Multiple Components", "", PickerView.PickerWithMultipleComponents_iPhone.class));

        navGroup = new NavItemGroup ("Toolbars");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Toolbar 1", "", Toolbar.Toolbar1_iPhone.class));
        navGroup.items.add(new NavItem("Programmatic Toolbar", "", Toolbar.ProgrammaticToolbar_Controller.class));
        navGroup.items.add(new NavItem("Toolbar Items", "", Toolbar.ToolbarItems.class));

        // create a table source from our nav items
        tableSource = new NavItemTableSource(this.navigationController, navItems);

        // set the source on the table to our data source
        super.tableView.source = tableSource;
    }
}
