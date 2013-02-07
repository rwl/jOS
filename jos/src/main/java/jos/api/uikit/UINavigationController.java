package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UINavigationController extends UIViewController {

    public boolean navigationBarHidden;

    @Export("navigationBarHidden")
    public boolean isNavigationBarHidden() {
        return navigationBarHidden;
    }

    @Export("setNavigationBarHidden:")
    public void setNavigationBarHidden(boolean navigationBarHidden) {
        this.navigationBarHidden = navigationBarHidden;
    }

    public UINavigationBar navigationBar;

    @Export("navigationBar")
    public UINavigationBar getNavigationBar() {
        return navigationBar;
    }

    @Export("init")
    public UINavigationController() {
        super();
    }

    @Export("pushViewController:animated:")
    public void pushViewController(UIViewController iPhoneHome, boolean animated) {
    }

    @Export("setNavigationBarHidden:animated:")
    public void setNavigationBarHidden(boolean hidden, boolean animated) {
    }

}
