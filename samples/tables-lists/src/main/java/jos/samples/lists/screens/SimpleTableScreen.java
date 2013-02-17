package jos.samples.lists.screens;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.lists.TableItem;
import jos.samples.lists.TableItemGroup;
import jos.samples.lists.TableSource;

public class SimpleTableScreen extends UITableViewController {

    protected TableSource tableSource;

    /**
     * You specify the table style in the constructor when using a UITableViewController
     */
    public SimpleTableScreen (UITableViewStyle tableStyle) {
        super(tableStyle)'
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        if (tableView.getStyle() == UITableViewStyle.GROUPED) {
            setTitle("Grouped Table");
        } else if (tableView.getStyle() == UITableViewStyle.PLAIN) {
            setTitle("Plain Table");
        }

        createTableItems();
        getTableView().setSource(tableSource);

    }

    /**
     * Creates a set of table items.
     */
    protected void createTableItems ()
    {
        List<TableItemGroup> tableItems = new ArrayList<TableItemGroup>();

        // declare vars
        TableItemGroup tGroup;

        // Section 1
        tGroup = new TableItemGroup("Section 0 Header", "Section 0 Footer");
        tGroup.getItems().add(new TableItem("Row 0"));
        tGroup.getItems().add(new TableItem("Row 1"));
        tGroup.getItems().add(new TableItem("Row 2"));
        tableItems.add(tGroup);

        // Section 2
        tGroup = new TableItemGroup("Section 1 Header", "Section 1 Footer");
        tGroup.getItems().add(new TableItem("Row 0"));
        tGroup.getItems().add(new TableItem("Row 1"));
        tGroup.getItems().add(new TableItem("Row 2"));
        tableItems.add(tGroup);

        // Section 3
        tGroup = new TableItemGroup("Section 2 Header", "Section 2 Footer");
        tGroup.getItems().add(new TableItem("Row 0"));
        tGroup.getItems().add(new TableItem("Row 1"));
        tGroup.getItems().add(new TableItem("Row 2"));
        tableItems.add(tGroup);

        // For custom cells, comment out the first and uncomment the second.
        tableSource = new TableSource (tableItems);
    }

}
