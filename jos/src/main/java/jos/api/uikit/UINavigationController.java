package jos.api.uikit;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UINavigationController extends UIViewController {

    public boolean navigationBarHidden;
    public UINavigationBar navigationBar;

    public UINavigationController() {
        super();
    }

    public void pushViewController(UIViewController iPhoneHome, boolean animated) {
    }

    public void setNavigationBarHidden(boolean b, boolean c) {
    }

}