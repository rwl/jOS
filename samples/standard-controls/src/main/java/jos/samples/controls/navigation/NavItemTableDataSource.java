package jos.samples.controls.navigation;

import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessory;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewDataSource;

/**
 * Combined DataSource and Delegate for our UITableView.
 */
public class NavItemTableDataSource extends UITableViewDataSource {

    private static final String CELL_IDENTIFIER = "NavTableCellView";

    private final List<NavItemGroup> navItems;

    public NavItemTableDataSource(List<NavItemGroup> items) {
        navItems = items;
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
        UITableViewCell cell = tableView.dequeueReusableCell(CELL_IDENTIFIER);
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.Default, CELL_IDENTIFIER);
            cell.tag = (int) System.currentTimeMillis();
        }

        // set the cell properties
        cell.textLabel.text = navItems.get(indexPath.section).getItems().get(indexPath.row).getName();
        cell.accessory = UITableViewCellAccessory.DisclosureIndicator;

        // return the cell
        return cell;
    }

}
