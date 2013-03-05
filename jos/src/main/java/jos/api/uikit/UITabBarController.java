package jos.api.uikit;

import jos.api.foundation.NSCoding;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.NativeArray;

@BaseType({UIViewController.class, UITabBarDelegate.class, NSCoding.class})
@Model
public class UITabBarController extends UIViewController {
    @Export("viewControllers")
    public @NativeArray UIViewController[] getViewControllers() {
        throw new RuntimeException();
    }

    @Export("setViewControllers:")
    public void setViewControllers(@NativeArray UIViewController[] value) {
        throw new RuntimeException();
    }

    @Export("selectedViewController")
    public UIViewController getSelectedViewController() {
        throw new RuntimeException();
    }

    @Export("setSelectedViewController:")
    public void setSelectedViewController(UIViewController value) {
        throw new RuntimeException();
    }

    @Export("selectedIndex")
    public int getSelectedIndex() {
        throw new RuntimeException();
    }

    @Export("setSelectedIndex:")
    public void setSelectedIndex(int value) {
        throw new RuntimeException();
    }

    @Export("moreNavigationController")
    public UINavigationController getMoreNavigationController() {
        throw new RuntimeException();
    }

    @Export("customizableViewControllers")
    public @NativeArray UIViewController[] getCustomizableViewControllers() {
        throw new RuntimeException();
    }

    @Export("setCustomizableViewControllers:")
    public void setCustomizableViewControllers(@NativeArray UIViewController[] value) {
        throw new RuntimeException();
    }

    @Export("tabBar")
    public UITabBar getTabBar() {
        throw new RuntimeException();
    }

    @Export("delegate")
    public UITabBarControllerDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UITabBarControllerDelegate value) {
        throw new RuntimeException();
    }

    @Export("setViewControllers:animated:")
    public void setViewControllersanimated(NativeArray viewControllers, boolean animated) {
    }

}