package jos.samples.lists.screens;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.lists.navigation.NavItemGroup;

public class HomeNavController extends UITableViewController {

    List<NavItemGroup> navItems = new ArrayList<NavItemGroup> ();
    NavItemTableSource tableSource;

    public HomeNavController () {
        super(UITableViewStyle.GROUPED);
    }

    @Override
    public void viewWillAppear (boolean animated)
    {
        super.viewWillAppear (animated);
        // hide the nav bar when this controller appears
        getNavigationController().setNavigationBarHidden(true, true);
    }

    @Override
    public void viewWillDisappear (boolean animated)
    {
        super.viewWillDisappear (animated);
        // show the nav bar when other controllers appear
        getNavigationController().setNavigationBarHidden (false, true);
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        // create the navigation items
        NavItemGroup navGroup = new NavItemGroup ("Table Styles");
        navItems.add (navGroup);
        navGroup.getItems().add(new NavItem("Grouped", "", SimpleTableScreen.class, new Object[] { UITableViewStyle.GROUPED }));
        navGroup.getItems().add(new NavItem("Plain", "", SimpleTableScreen.class, new object[] { UITableViewStyle.PLAIN }));
        navGroup.getItems().add(new NavItem("Indexed Grouped", "", TableWithIndexScreen.class, new Object[] { UITableViewStyle.GROUPED }));
        navGroup.getItems().add(new NavItem("Indexed Plain", "", TableWithIndexScreen.class, new Object[] { UITableViewStyle.PLAIN }));

        navGroup = new NavItemGroup ("Cell Styles");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Default", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.DEFAULT, UITableViewCellAccessory.NONE }));
        navGroup.getItems().add(new NavItem("Subtitle", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.SUBTITLE, UITableViewCellAccessory.NONE }));
        navGroup.getItems().add(new NavItem("Value1 (Right-Aligned Subtitle)", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.VALUE1, UITableViewCellAccessory.NONE }));
        navGroup.getItems().add(new NavItem("Value2 (Contact Style)", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.VALUE2, UITableViewCellAccessory.NONE }));

        navGroup = new NavItemGroup ("Accessory Styles");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Checkmark", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.DEFAULT, UITableViewCellAccessory.Checkmark }));
        navGroup.getItems().add(new NavItem("DetailDisclosureButton", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.DEFAULT, UITableViewCellAccessory.DetailDisclosureButton }));
        navGroup.getItems().add(new NavItem("DisclosureIndicator", "", TableScreen.class
            , new Object[] { UITableViewStyle.PLAIN, UITableViewCellStyle.DEFAULT, UITableViewCellAccessory.DisclosureIndicator }));

        navGroup = new NavItemGroup ("Custom Cells");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Custom Cell from XIB", "", CustomCell1TableScreen.class));
        navGroup.getItems().add(new NavItem("Custom Cell in code", "", CustomCell12TableScreen.class));

        // create a table source from our nav items
        tableSource = new NavItemTableSource(getNavigationController(), navItems);

        // set the source on the table to our data source
        getTableView().setSource(tableSource);
    }

}
