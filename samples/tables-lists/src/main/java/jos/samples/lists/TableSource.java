package jos.samples.lists;

import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewDataSource;

/**
 * Combined DataSource and Delegate for our UITableView
 */
public class TableSource extends UITableViewDataSource {

    protected static String cellIdentifier = "TableCell";

    protected List<TableItemGroup> tableItems;

    public TableSource(List<TableItemGroup> items) {
        tableItems = items;
    }

    /**
     * Called by the TableView to determine how many sections(groups) there are.
     */
    @Override
    public int numberOfSections(UITableView tableView) {
        return tableItems.size();
    }

    /**
     * Called by the TableView to determine how many cells to create for that
     * particular section.
     */
    @Override
    public int rowsInSection(UITableView tableview, int section) {
        return tableItems.get(section).getItems().size();
    }

    /**
     * Called by the TableView to retrieve the header text for the particular
     * section(group)
     */
    @Override
    public String titleForHeader(UITableView tableView, int section) {
        return tableItems.get(section).getName();
    }

    /**
     * Called by the TableView to retrieve the footer text for the particular
     * section(group)
     */
    @Override
    public String titleForFooter(UITableView tableView, int section) {
        return tableItems.get(section).getFooter();
    }

    @Override
    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {
        new UIAlertView("Row Selected", tableItems.get(indexPath.getSection())
                .getItems().get(indexPath.getRow()).getHeading(), null, "OK",
                null).show();
    }

    @Override
    public void rowDeselected(UITableView tableView, NSIndexPath indexPath) {
        System.out.println("Row " + indexPath.getRow().toString()
                + " deselected");
    }

    @Override
    public void accessoryButtonTapped(UITableView tableView,
            NSIndexPath indexPath) {
        System.out.println("Accessory for Section, "
                + indexPath.getSection().toString() + " and Row, "
                + indexPath.getRow().toString() + " tapped");
    }

    /**
     * Called by the TableView to get the actual UITableViewCell to render for
     * the particular section and row
     */
    @Override
    public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath) {
        // declare vars
        UITableViewCell cell = tableView.dequeueReusableCell(cellIdentifier);
        TableItem item = tableItems.get(indexPath.getSection()).getItems()
                .get(indexPath.getRow());

        // if there are no cells to reuse, create a new one
        if (cell == null) {
            cell = new UITableViewCell(item.getCellStyle(), cellIdentifier);
        }

        // set the item text
        cell.getTextLabel().setText(
                tableItems.get(indexPath.getSection()).getItems()
                        .get(indexPath.getRow()).getHeading());

        // if it's a cell style that supports a subheading, set it
        if (item.getCellStyle() == UITableViewCellStyle.SUBTITLE
                || item.getCellStyle() == UITableViewCellStyle.VALUE1
                || item.getCellStyle() == UITableViewCellStyle.VALUE2) {
            cell.getDetailTextLabel().setText(item.getSubHeading());
        }

        // if the item has a valid image, and it's not the contact style
        // (doesn't support images)
        if (item.getImageName() != null && !item.getImageName().isEmpty()
                && item.getCellStyle() != UITableViewCellStyle.VALUE2) {
            if (new File(item.getImageName()).exists()) {
                cell.getImageView().setImage(
                        UIImage.fromBundle(item.getImageName()));
            }
        }

        // set the accessory
        cell.setAccessory(item.getCellAccessory());

        return cell;
    }

}
