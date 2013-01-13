package jos.uikit;

import jos.api.Export;
import jos.api.Register;
import jos.api.StorageSemantic;
import jos.graphicsimaging.CGRect;

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
}
