package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSBundle;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UINavigationController extends UIViewController {

    @Export("initWithNibName:bundle:")
    public UINavigationController(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    @Export("topViewController")
    public UIViewController getTopViewController() {
        throw new RuntimeException();
    }

    @Export("visibleViewController")
    public UIViewController getVisibleViewController() {
        throw new RuntimeException();
    }

    @Export("viewControllers")
    public NSArray getViewControllers() {
        throw new RuntimeException();
    }

    @Export("setViewControllers:")
    public void setViewControllers(NSArray value) {
        throw new RuntimeException();
    }

    @Bind("isNavigationBarHidden")
    @Export("navigationBarHidden")
    public boolean getNavigationBarHidden() {
        throw new RuntimeException();
    }

    @Export("setNavigationBarHidden:")
    public void setNavigationBarHidden(boolean value) {
        throw new RuntimeException();
    }

    @Export("navigationBar")
    public UINavigationBar getNavigationBar() {
        throw new RuntimeException();
    }

    @Bind("isToolbarHidden")
    @Export("toolbarHidden")
    public boolean isToolbarHidden() {
        throw new RuntimeException();
    }

    @Export("setToolbarHidden:")
    public void setToolbarHidden(boolean value) {
        throw new RuntimeException();
    }

    @Export("toolbar")
    public UIToolbar getToolbar() {
        throw new RuntimeException();
    }

    @Export("delegate")
    public UINavigationControllerDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UINavigationControllerDelegate value) {
        throw new RuntimeException();
    }

    @Export("initWithNavigationBarClass:toolbarClass:")
    public NSObject initWithNavigationBarClasstoolbarClass(Class navigationBarClass, Class toolbarClass) {
        throw new RuntimeException();
    }

    @Export("initWithRootViewController:")
    public NSObject initWithRootViewController(UIViewController rootViewController) {
        throw new RuntimeException();
    }

    @Export("pushViewController:animated:")
    public void pushViewController(UIViewController viewController, boolean animated) {
        throw new RuntimeException();
    }

    @Export("popViewControllerAnimated:")
    public UIViewController popViewControllerAnimated(boolean animated) {
        throw new RuntimeException();
    }

    @Export("popToViewController:animated:")
    public NSArray popToViewControlleranimated(UIViewController viewController, boolean animated) {
        throw new RuntimeException();
    }

    @Export("popToRootViewControllerAnimated:")
    public NSArray popToRootViewControllerAnimated(boolean animated) {
        throw new RuntimeException();
    }

    @Export("setViewControllers:animated:")
    public void setViewControllersanimated(NSArray viewControllers, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setNavigationBarHidden:animated:")
    public void setNavigationBarHiddenanimated(boolean hidden, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setToolbarHidden:animated:")
    public void setToolbarHiddenanimated(boolean hidden, boolean animated) {
        throw new RuntimeException();
    }

}
