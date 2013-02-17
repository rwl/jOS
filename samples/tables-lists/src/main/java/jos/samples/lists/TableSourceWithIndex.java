package jos.samples.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jos.api.uikit.UITableView;

/**
 * A sample table source implementation that supports a table index
 */
public class TableSourceWithIndex extends TableSource {

    Map<String, Integer> indexSectionMap = null;

    public TableSourceWithIndex(List<TableItemGroup> items,
            Map<String, Integer> indexSectionMap) {
        super(items);
        this.indexSectionMap = indexSectionMap;
    }

    /**
     * Called by the table view to get a list of the index section titles
     */
    @Override
    public String[] sectionIndexTitles(UITableView tableView) {
        return new ArrayList<String>(indexSectionMap.keySet())
                .toArray(new String[indexSectionMap.keySet().size()]);
    }

    /**
     * Called by the table view when a user clicks on an index section. used to
     * retrieve the appropriate section in the table for that particular index.
     */
    @Override
    public int sectionFor(UITableView tableView, String title, int atIndex) {
        return indexSectionMap.get(title);
    }

}
