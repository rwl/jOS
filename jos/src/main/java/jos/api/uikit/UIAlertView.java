package jos.api.uikit;

import jos.api.foundation.NSCoder;
import jos.api.graphicsimaging.CGRect;
import jos.api.system.IntPtr;

public class UIAlertView extends UIView {

    public UIAlertViewDelegate delegate;

    public UIAlertView(CGRect frame) {
        super(frame);
    }

    public UIAlertView(String string, String string2, Object object,
            String string3, Object object2) {
        super(null);
    }

    public UIAlertView(IntPtr handle) {
    }

    public UIAlertView() {
    }

    public UIAlertView(NSCoder coder) {
    }

    public void show() {
    }

    public void dismissWithClickedButtonIndex(int i, boolean animated) {
    }
}
