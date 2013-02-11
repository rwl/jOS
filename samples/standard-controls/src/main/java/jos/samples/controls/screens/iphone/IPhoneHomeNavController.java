package jos.samples.controls.screens.iphone;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.controls.navigation.NavItem;
import jos.samples.controls.navigation.NavItemGroup;
import jos.samples.controls.navigation.NavItemTableDataSource;
import jos.samples.controls.navigation.NavItemTableDelegate;

public class IPhoneHomeNavController extends UITableViewController {

    private final List<NavItemGroup> navItems = new ArrayList<NavItemGroup>();

    private NavItemTableDataSource tableSource;

    private NavItemTableDelegate tableDelegate;

    public IPhoneHomeNavController() {
        super(UITableViewStyle.GROUPED);
    }

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        // hide the nav bar when this controller appears
        getNavigationController().setNavigationBarHidden(true, true);
    }

    @Override
    public void viewWillDisappear(boolean animated) {
        super.viewWillDisappear(animated);
        // show the nav bar when other controllers appear
        getNavigationController().setNavigationBarHidden(false, true);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // create the navigation items
        NavItemGroup navGroup = new NavItemGroup("Form Controls");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Labels", LabelsScreen.class));
        navGroup.getItems().add(new NavItem("Text Fields", TextFields.class));
        navGroup.getItems().add(new NavItem("Sliders", Sliders.class));
        navGroup.getItems().add(new NavItem("Buttons", ButtonsScreen.class));
        navGroup.getItems().add(new NavItem("Switches", Switches.class));
        navGroup.getItems().add(new NavItem("Segmented Buttons", SegmentedControls.class));
        navGroup.getItems().add(new NavItem("Segmented Buttons 2", SegmentedControls2.class));

        navGroup = new NavItemGroup("Content Controls");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Scroll View", ScrollView.class));
        navGroup.getItems().add(new NavItem("Tap to Zoom Scroll View", TapToZoom.class));
        navGroup.getItems().add(new NavItem("Pager Control", PagerControl.class));
        navGroup.getItems().add(new NavItem("Image Control", Images.class));
        navGroup.getItems().add(new NavItem("More Image Controls", Images2.class));

        navGroup = new NavItemGroup("Process Controls");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Activity Spinners", ActivitySpinnerScreen.class));
        navGroup.getItems().add(new NavItem("Progress Bars", ProgressBars.class));

        navGroup = new NavItemGroup("Popups");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Alert Views", AlertViewsScreen.class));
        navGroup.getItems().add(new NavItem("Action Sheets", ActionSheets.class));

        navGroup = new NavItemGroup("Pickers");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Simple Date Picker", DatePickerSimple.class));
        navGroup.getItems().add(new NavItem("Date Picker", DatePicker.class));
        navGroup.getItems().add(new NavItem("Simple Custom Picker", PickerView1.class));
        navGroup.getItems().add(new NavItem("Custom Picker with Multiple Components", PickerWithMultipleComponents.class));

        navGroup = new NavItemGroup("Toolbars");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Toolbar 1", Toolbar1.class));
        navGroup.getItems().add(new NavItem("Programmatic Toolbar", ProgrammaticToolbar.class));
        navGroup.getItems().add(new NavItem("Toolbar Items", ToolbarItems.class));

        // create a table source and delegate using our nav items
        tableSource = new NavItemTableDataSource(navItems);
        tableDelegate = new NavItemTableDelegate(getNavigationController(), navItems);

        // set the source on the table to our data source
        getTableView().setDataSource(tableSource);
        getTableView().setTableViewDelegate(tableDelegate);
    }

}
