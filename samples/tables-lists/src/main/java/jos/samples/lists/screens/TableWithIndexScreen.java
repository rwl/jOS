package jos.samples.lists.screens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jos.api.uikit.UITableViewController;
import jos.api.uikit.UITableViewStyle;
import jos.samples.lists.TableItem;
import jos.samples.lists.TableItemGroup;
import jos.samples.lists.TableSourceWithIndex;

public class TableWithIndexScreen extends UITableViewController {

    protected TableSourceWithIndex tableSource;

    /**
     * You specify the table style in the constructor when using a UITableViewController
     */
    public TableWithIndexScreen (UITableViewStyle tableStyle) {
        super(tableStyle);
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        setTitle("Table with Index");

        createTableItems ();
        tableView.setSource(tableSource);
    }

    /**
     * Creates a set of table items.
     */
    protected void createTableItems ()
    {
        List<TableItemGroup> tableItems = new ArrayList<TableItemGroup>();
        Map<String, Integer> indexSectionMap = new HashMap<String, Integer>();

        // declare vars
        TableItemGroup tGroup;

        // Section
        tGroup = new TableItemGroup("A");
        tGroup.getItems().add(new TableItem("Apple"));
        tGroup.getItems().add(new TableItem("Artichoke"));
        tableItems.add(tGroup);
        indexSectionMap.put("A", 0);

        // Section
        tGroup = new TableItemGroup("B");
        tGroup.getItems().add(new TableItem("Banana"));
        tGroup.getItems().add(new TableItem("Berries"));
        tableItems.add(tGroup);
        indexSectionMap.put("B", 1);

        // Section
        tGroup = new TableItemGroup("C");
        tGroup.getItems().add(new TableItem("Cucumber"));
        tGroup.getItems().add(new TableItem("Cantalopes"));
        tableItems.Add (tGroup);
        indexSectionMap.put("C", 2);

        // Section
        tGroup = new TableItemGroup("D");
        tGroup.getItems().add(new TableItem("Daikon"));
        tableItems.add(tGroup);
        indexSectionMap.put("D", 3);

        // Section
        tGroup = new TableItemGroup("E");
        tGroup.getItems().add(new TableItem("Eggplant"));
        tGroup.getItems().add(new TableItem("Elderberry"));
        tableItems.add(tGroup);
        indexSectionMap.put("E", 4);

        // Section
        tGroup = new TableItemGroup("F");
        tGroup.getItems().add(new TableItem("Fig"));
        tableItems.add(tGroup);
        indexSectionMap.put("F", 5);

        // Section
        tGroup = new TableItemGroup("G");
        tGroup.getItems().add(new TableItem("Grape"));
        tGroup.getItems().add(new TableItem("Guava"));
        tableItems.add(tGroup);
        indexSectionMap.put("G", 6);

        // Section
        tGroup = new TableItemGroup("H");
        tGroup.getItems().add(new TableItem("Honeydew"));
        tGroup.getItems().add(new TableItem("Huckleberry"));
        tableItems.add(tGroup);
        indexSectionMap.put("H", 7);

        // Section
        tGroup = new TableItemGroup("I");
        tGroup.getItems().add(new TableItem("Indian Fig"));
        tableItems.add(tGroup);
        indexSectionMap.put("I", 8);

        // Section
        tGroup = new TableItemGroup("J");
        tGroup.getItems().add(new TableItem("Jackfruit"));
        tableItems.add(tGroup);
        indexSectionMap.put("J", 9);

        // Section
        tGroup = new TableItemGroup("K");
        tGroup.getItems().add(new TableItem("Kiwi"));
        tGroup.getItems().add(new TableItem("Kumquat"));
        tableItems.add(tGroup);
        indexSectionMap.put("K", 10);


        indexSectionMap.put("L", 10);
        indexSectionMap.put("M", 10);
        indexSectionMap.put("N", 10);
        indexSectionMap.put("O", 10);
        indexSectionMap.put("P", 10);
        indexSectionMap.put("Q", 10);
        indexSectionMap.put("R", 10);
        indexSectionMap.put("S", 10);
        indexSectionMap.put("T", 10);
        indexSectionMap.put("U", 10);
        indexSectionMap.put("V", 10);
        indexSectionMap.put("W", 10);
        indexSectionMap.put("X", 10);
        indexSectionMap.put("Y", 10);
        indexSectionMap.put("Z", 10);

        // For custom cells, comment out the first and uncomment the second.
        tableSource = new TableSourceWithIndex(tableItems, indexSectionMap);
    }

}
