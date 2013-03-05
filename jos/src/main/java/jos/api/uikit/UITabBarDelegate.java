package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UITabBarDelegate extends NSObject {
    @Export("tabBar:didSelectItem:")
    public void tabBardidSelectItem(UITabBar tabBar, UITabBarItem item) {
        throw new RuntimeException();
    }

    @Export("tabBar:willBeginCustomizingItems:")
    public void tabBarwillBeginCustomizingItems(UITabBar tabBar, NSArray items) {
        throw new RuntimeException();
    }

    @Export("tabBar:didBeginCustomizingItems:")
    public void tabBardidBeginCustomizingItems(UITabBar tabBar, NSArray items) {
        throw new RuntimeException();
    }

    @Export("tabBar:willEndCustomizingItems:changed:")
    public void tabBarwillEndCustomizingItemschanged(UITabBar tabBar, NSArray items, boolean changed) {
        throw new RuntimeException();
    }

    @Export("tabBar:didEndCustomizingItems:changed:")
    public void tabBardidEndCustomizingItemschanged(UITabBar tabBar, NSArray items, boolean changed) {
        throw new RuntimeException();
    }

}
