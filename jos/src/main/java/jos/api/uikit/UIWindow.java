package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.StorageSemantic;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIWindow extends UIView {

    @Export(semantic = StorageSemantic.RETAIN)
    public UIViewController rootViewController;

    @Export(selector = "initWithFrame:")
    public UIWindow(final CGRect frame) {
        super(frame);
    }

    //    @Export
    public void makeKeyAndVisible() {
    }

    @Export(selector = "rootViewController")
    public UIViewController getRootViewController() {
        return rootViewController;
    }

    @Export(selector = "setRootViewController:")
    public void setRootViewController(UIViewController rootViewController) {
        this.rootViewController = rootViewController;
    }
}
