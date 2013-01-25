package jos.samples.controls.screens.iphone.home;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.controls.code.NavItem;
import jos.samples.controls.code.NavItemGroup;
import jos.samples.controls.code.NavItemTableSource;
import jos.samples.controls.screens.iphone.actionsheets.ActionSheets_iPhone;
import jos.samples.controls.screens.iphone.activityspinner.ActivitySpinnerScreen_iPhone;
import jos.samples.controls.screens.iphone.alertviews.AlertViewsScreen_iPhone;
import jos.samples.controls.screens.iphone.buttons.ButtonsScreen_iPhone;
import jos.samples.controls.screens.iphone.datepicker.DatePickerSimple_iPhone;
import jos.samples.controls.screens.iphone.datepicker.DatePicker_iPhone;
import jos.samples.controls.screens.iphone.images.Images2_iPhone;
import jos.samples.controls.screens.iphone.images.Images_iPhone;
import jos.samples.controls.screens.iphone.labels.LabelsScreen_iPhone;
import jos.samples.controls.screens.iphone.pagercontrol.PagerControl_iPhone;
import jos.samples.controls.screens.iphone.pickerview.PickerView1_iPhone;
import jos.samples.controls.screens.iphone.pickerview.PickerWithMultipleComponents_iPhone;
import jos.samples.controls.screens.iphone.progressbar.ProgressBars_iPhone;
import jos.samples.controls.screens.iphone.segmentedcontrol.SegmentedControls2_iPhone;
import jos.samples.controls.screens.iphone.segmentedcontrol.SegmentedControls_iPhone;
import jos.samples.controls.screens.iphone.sliders.Sliders_iPhone;
import jos.samples.controls.screens.iphone.switches.Switches_iPhone;
import jos.samples.controls.screens.iphone.textfields.TextFields_iPhone;
import jos.samples.controls.screens.iphone.toolbar.ProgrammaticToolbar_Controller;
import jos.samples.controls.screens.iphone.toolbar.ToolbarItems;
import jos.samples.controls.screens.iphone.toolbar.Toolbar1_iPhone;

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
        navGroup.items.add(new NavItem("Labels", "", LabelsScreen_iPhone.class));
        navGroup.items.add(new NavItem("Text Fields", "", TextFields_iPhone.class));
        navGroup.items.add(new NavItem("Sliders", "", Sliders_iPhone.class));
        navGroup.items.add(new NavItem("Buttons", "", ButtonsScreen_iPhone.class));
        navGroup.items.add(new NavItem("Switches", "", Switches_iPhone.class));
        navGroup.items.add(new NavItem("Segmented Buttons", "", SegmentedControls_iPhone.class));
        navGroup.items.add(new NavItem("Segmented Buttons 2", "", SegmentedControls2_iPhone.class));

        navGroup = new NavItemGroup ("Content Controls");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Scroll View", "", jos.samples.controls.screens.iphone.scrollview.Controller.class));
        navGroup.items.add(new NavItem("Tap to Zoom Scroll View", "", jos.samples.controls.screens.iphone.taptozoomscrollview.Controller.class));
        navGroup.items.add(new NavItem("Pager Control", "", PagerControl_iPhone.class));
        navGroup.items.add(new NavItem("Image Control", "", Images_iPhone.class));
        navGroup.items.add(new NavItem("More Image Controls", "", Images2_iPhone.class));

        navGroup = new NavItemGroup ("Process Controls");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Activity Spinners", "", ActivitySpinnerScreen_iPhone.class));
        navGroup.items.add(new NavItem("Progress Bars", "", ProgressBars_iPhone.class));

        navGroup = new NavItemGroup ("Popups");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Alert Views", "", AlertViewsScreen_iPhone.class));
        navGroup.items.add(new NavItem("Action Sheets", "", ActionSheets_iPhone.class));

        navGroup = new NavItemGroup ("Pickers");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Simple Date Picker", "", DatePickerSimple_iPhone.class));
        navGroup.items.add(new NavItem("Date Picker", "", DatePicker_iPhone.class));
        navGroup.items.add(new NavItem("Simple Custom Picker", "", PickerView1_iPhone.class));
        navGroup.items.add(new NavItem("Custom Picker with Multiple Components", "", PickerWithMultipleComponents_iPhone.class));

        navGroup = new NavItemGroup ("Toolbars");
        navItems.add(navGroup);
        navGroup.items.add(new NavItem("Toolbar 1", "", Toolbar1_iPhone.class));
        navGroup.items.add(new NavItem("Programmatic Toolbar", "", ProgrammaticToolbar_Controller.class));
        navGroup.items.add(new NavItem("Toolbar Items", "", ToolbarItems.class));

        // create a table source from our nav items
        tableSource = new NavItemTableSource(this.navigationController, navItems);

        // set the source on the table to our data source
        super.tableView.source = tableSource;
    }
}
