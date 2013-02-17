package jos.samples.lists.screens;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.lists.TableItem;
import jos.samples.lists.TableItemGroup;
import jos.samples.lists.TableSource;
import jos.samples.lists.cells.CustomCellController2;

public class CustomCell12TableScreen extends UITableViewController {

    protected CustomCellTableSource tableSource;
    protected String cellType;

    /**
     * You specify the table style in the constructor when using a UITableViewController
     */
    public CustomCell12TableScreen () {
        super(UITableViewStyle.PLAIN);
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        setTitle("Custom Cells");

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
        tGroup = new TableItemGroup("Places");
        tGroup.getItems().add(new TableItem("Images/Beach.png", "Fiji",
                "A nice beach"));
        tGroup.getItems().add(new TableItem("Images/Shanghai.png", "Beijing",
                "AKA Shanghai"));
        tableItems.add(tGroup);

        // Section 2
        tGroup = new TableItemGroup("Other");
        tGroup.getItems().add(new TableItem("Images/Seeds.png", "Seedlings",
                "Tiny Plants"));
        tGroup.getItems().add(new TableItem("Images/Plants.png", "Plants",
                "Green plants"));
        tableItems.add(tGroup);

        // For custom cells, comment out the first and uncomment the second.
        tableSource = new CustomCellTableSource(tableItems);
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation (UIInterfaceOrientation oOrientation)
    {
        return true;
    }

    public class CustomCellTableSource extends TableSource
    {
        // we need to keep a list of our cell controllers, since the table only has
        // references to the cells, we'll link the two via a TickCount value
        protected Map<Integer, CustomCellController2> cellControllers = new HashMap<Integer, CustomCellController2>();

        public CustomCellTableSource (List<TableItemGroup> items)
        {
            super(items);
            cellIdentifier = "MyCustomCell1";
        }

        @Override
        public float getHeightForRow (UITableView tableView, NSIndexPath indexPath)
        {
            return 85;
        }

        @Override
        public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath)
        {
            // declare vars
            UITableViewCell cell = tableView.dequeueReusableCell(cellIdentifier);
            TableItem item = tableItems.get(indexPath.getSection()).getItems().get(indexPath.getRow());
            CustomCellController2 cellController = null;

            // if there are no cells to reuse, create a new one
            if (cell == null) {
                cellController = new CustomCellController2();
                cell = cellController.getCell();
                cell.setTag(Environment.getTickCount());
                cellControllers.put(cell.getTag(), cellController);
            } else // if we did get one, we also need to lookup the controller
            {
                cellController = cellControllers.get(cell.getTag());
            }

            // set the properties on the cell
            cellController.setHeading(item.getHeading());
            cellController.setSubHeading(item.getSubHeading());

            // if the item has a valid image
            if (item.getImageName() != null && !item.getImageName().isEmpty()) {
                if (new File(item.getImageName()).exists()) {
                    cellController.setImage(UIImage.fromBundle(item.getImageName()));
                }
            }

            return cell;
        }
    }
}
