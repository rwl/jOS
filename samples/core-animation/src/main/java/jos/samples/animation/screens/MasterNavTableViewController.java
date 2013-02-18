package jos.samples.animation.screens;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.animation.navigation.NavItem;
import jos.samples.animation.navigation.NavItemGroup;
import jos.samples.animation.navigation.NavItemTableDelegate.RowClickListener;

public class MasterNavTableViewController extends UITableViewController {

    RowClickListener rowClickListener;

    List<NavItemGroup> navItems = new ArrayList<NavItemGroup>();
    NavItemTableSource tableSource;

    public MasterNavTableViewController() {
        super(UITableViewStyle.GROUPED);
    }

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        // hide the nav bar when this controller appears
        //navigationController.setNavigationBarHidden(true, true);
    }

    @Override
    public void viewWillDisappear(boolean animated) {
        super.viewWillDisappear(animated);
        // show the nav bar when other controllers appear
        //navigationController.setNavigationBarHidden(false, true);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // create the navigation items
        NavItemGroup navGroup = new NavItemGroup("UIView Animations");
        navItems.add(navGroup);
        navGroup.getItems().add(new NavItem("Basic Animation", "", BasicUIViewAnimationScreen.class));
        navGroup.getItems().add(new NavItem("Animation Customizer", "", CustomizableAnimationViewerScreen.class));
        navGroup.getItems().add(new NavItem("Transitions", "", Controller.class));
        navGroup.getItems().add(new NavItem("Implicit Layer Animation", "", ImplicitAnimationScreen.class));
        navGroup.getItems().add(new NavItem("Explicit Layer Animation", "", LayerAnimationScreen.class));

        // create a table source from our nav items
        tableSource = new NavItemTableSource(navItems);

        // set the source on the table to our data source
        tableView.setSource(tableSource);

        tableSource.setRowClicked(new RowClickListener() {
            @Override
            public void onEvent(NavItem item) {
                if (rowClicked != null) {
                    rowClicked.onEvent(item);
                }
            }
        });
    }

    public RowClickListener setRowClickListener(RowClickListener rowClickListener) {
        this.rowClickListener = rowClickListener;
    }

}
