package jos.samples.lists.screens;

import java.util.ArrayList;
import java.util.List;

import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewStyle;
import jos.api.uikit.UIViewController;
import jos.samples.lists.TableItemGroup;
import jos.samples.lists.TableSource;

public class TableScreen extends UITableViewController {

    protected TableSource tableSource;
    protected UITableViewCellStyle cellStyle;
    protected UITableViewCellAccessory cellAccessory;

    /**
     * You specify the table style in the constructor when using a UITableViewController
     */
    public TableScreen(UITableViewStyle tableStyle, UITableViewCellStyle cellStyle,
            UITableViewCellAccessory cellAccessory)
    {
        super(tableStyle);
        this.cellStyle = cellStyle;
        this.cellAccessory = cellAccessory;
    }

    @Override
    public void viewDidLoad ()
    {
        super.ViewDidLoad ();

        setTitle(cellStyle.toString () + " Style");

        createTableItems ();
        tableView.setSource(tableSource);

    }

    /**
     * Creates a set of table items.
     */
    protected void createTableItems ()
    {
        List<TableItemGroup> tableItems = new ArrayList<TableItemGroup> ();

        // declare vars
        TableItemGroup tGroup;

        // Section 1
        tGroup = new TableItemGroup(/*name*/ "Places");
        tGroup.getItems().add(new TableItem(/*cellStyle*/ cellStyle, /*cellAccessory*/ cellAccessory,
                    /*imageName*/ "Images/Beach.png", /*heading*/ "Fiji", /*subHeading*/ "A nice beach"));
        tGroup.getItems().add(new TableItem(/*cellStyle*/ cellStyle, /*cellAccessory*/ cellAccessory,
                    /*imageName*/ "Images/Shanghai.png", /*heading*/ "Beijing", /*subHeading*/ "AKA Shanghai"));
        tableItems.add(tGroup);

        // Section 2
        tGroup = new TableItemGroup("Other");
        tGroup.getItems().add(new TableItem(cellStyle, cellAccessory,
                    "Images/Seeds.png", "Seedlings", "Tiny Plants"));
        tGroup.getItems().add(new TableItem(cellStyle, cellAccessory,
                    "Images/Plants.png", "Plants", "Green plants"));
        tableItems.add(tGroup);

        tableSource = new TableSource(tableItems);
    }
}
