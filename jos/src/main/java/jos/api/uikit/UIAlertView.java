package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

public class UIAlertView extends UIView {

    public UIAlertViewDelegate delegate;

    public UIAlertView(CGRect frame) {
        super(frame);
    }

    public UIAlertView(String string, String string2, Object object,
            String string3, Object object2) {
        super(null);
    }

    public void show() {
    }
}
