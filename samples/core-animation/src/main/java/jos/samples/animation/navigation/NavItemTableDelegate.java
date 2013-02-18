package jos.samples.animation.navigation;

import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewDelegate;


public class NavItemTableDelegate extends UITableViewDelegate {

    public interface RowClickListener {
        void onEvent(NavItem item);
    }

    private RowClickListener rowClickListener;

    private final List<NavItemGroup> navItems;

    public NavItemTableDelegate(List<NavItemGroup> items) {
        navItems = items;
    }

    /**
     * Is called when a row is selected.
     */
    @Override
    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {
        // get a reference to the nav item
        NavItem navItem = navItems.get(indexPath.getSection()).getItems().get(indexPath.getRow());

        if (rowClickListener != null) {
            rowClickListener.onEvent(navItem);
        }
    }

    public void setRowClickedListener(RowClickListener listener) {
        this.rowClickListener = listener;
    }

}
