package jos.api.uikit;

import jos.api.foundation.NSArray;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITabBar extends UIView {
    @Export("delegate")
    public UITabBarDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UITabBarDelegate value) {
        throw new RuntimeException();
    }

    @Export("items")
    public NSArray getItems() {
        throw new RuntimeException();
    }

    @Export("setItems:")
    public void setItems(NSArray value) {
        throw new RuntimeException();
    }

    @Export("selectedItem")
    public UITabBarItem getSelectedItem() {
        throw new RuntimeException();
    }

    @Export("setSelectedItem:")
    public void setSelectedItem(UITabBarItem value) {
        throw new RuntimeException();
    }

    @Export("setItems:animated:")
    public void setItemsanimated(NSArray items, boolean animated) {
        throw new RuntimeException();
    }

    @Export("beginCustomizingItems:")
    public void beginCustomizingItems(NSArray items) {
        throw new RuntimeException();
    }

    @Export("endCustomizingAnimated:")
    public boolean endCustomizingAnimated(boolean animated) {
        throw new RuntimeException();
    }

    @Export("isCustomizing")
    public boolean isCustomizing() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("tintColor")
    public UIColor getTintColor() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("selectedImageTintColor")
    public UIColor getSelectedImageTintColor() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backgroundImage")
    public UIImage getBackgroundImage() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("selectionIndicatorImage")
    public UIImage getSelectionIndicatorImage() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("shadowImage")
    public UIImage getShadowImage() {
        throw new RuntimeException();
    }

}