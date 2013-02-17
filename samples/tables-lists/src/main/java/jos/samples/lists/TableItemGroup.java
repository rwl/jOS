package jos.samples.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * A group that contains table items
 */
public class TableItemGroup {

    private String name;

    private String footer;

    private List<TableItem> items = new ArrayList<TableItem>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public List<TableItem> getItems() {
        return items;
    }

    public void setItems(List<TableItem> items) {
        this.items = items;
    }

}
