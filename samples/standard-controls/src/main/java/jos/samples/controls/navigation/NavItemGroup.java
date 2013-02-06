package jos.samples.controls.navigation;

import java.util.List;

/**
 * A group that contains table items.
 */
public class NavItemGroup {

    public String name;

    public String footer;

    public List<NavItem> items;

    public NavItemGroup() {
    }

    public NavItemGroup(String name) {
        this.name = name;
    }
}
