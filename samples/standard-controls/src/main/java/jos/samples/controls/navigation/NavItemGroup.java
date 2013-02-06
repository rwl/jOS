package jos.samples.controls.navigation;

import java.util.ArrayList;
import java.util.List;

/**
 * A group that contains table items.
 */
public class NavItemGroup {

    private final String name;

    private final String footer;

    private final List<NavItem> items;

    public NavItemGroup(String name) {
        this.name = name;
        this.footer = "";
        this.items = new ArrayList<NavItem>();
    }

    public String getName() {
        return name;
    }

    public String getFooter() {
        return footer;
    }

    public List<NavItem> getItems() {
        return items;
    }

}
