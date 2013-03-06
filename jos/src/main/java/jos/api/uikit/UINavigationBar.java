package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class UINavigationBar extends UIView {

    @Export("barStyle")
    public UIBarStyle getBarStyle() {
        throw new RuntimeException();
    }

    @Export("setBarStyle:")
    public void setBarStyle(UIBarStyle value) {
        throw new RuntimeException();
    }

    @Export("delegate")
    public NSObject getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(NSObject value) {
        throw new RuntimeException();
    }

    @Bind("isTranslucent")
    @Export("translucent")
    public boolean getTranslucent() {
        throw new RuntimeException();
    }

    @Export("setTranslucent:")
    public void setTranslucent(boolean value) {
        throw new RuntimeException();
    }

    @Export("topItem")
    public UINavigationItem getTopItem() {
        throw new RuntimeException();
    }

    @Export("backItem")
    public UINavigationItem getBackItem() {
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

    @Appearance
    @Export("tintColor")
    public UIColor getTintColor() {
        throw new RuntimeException();
    }

    @Export("setTintColor:")
    public void setTintColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("pushNavigationItem:animated:")
    public void pushNavigationItem(UINavigationItem item, boolean animated) {
        throw new RuntimeException();
    }

    @Export("popNavigationItemAnimated:")
    public UINavigationItem popNavigationItemAnimated(boolean animated) {
        throw new RuntimeException();
    }

    @Export("setItems:animated:")
    public void setItemsanimated(NSArray items, boolean animated) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackgroundImage:forBarMetrics:")
    public void setBackgroundImage(UIImage image, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backgroundImageForBarMetrics:")
    public UIImage backgroundImageForBarMetrics(UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("shadowImage")
    public UIImage shadowImage() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("titleTextAttributes")
    public NSDictionary titleTextAttributes() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setTitleVerticalPositionAdjustment:forBarMetrics:")
    public void setTitleVerticalPositionAdjustmentforBarMetrics(float adjustment, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("titleVerticalPositionAdjustmentForBarMetrics:")
    public float titleVerticalPositionAdjustmentForBarMetrics(UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }
}
