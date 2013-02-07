package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public abstract class UIAlertViewDelegate {

    @Export("alertView:clickedButtonAtIndex:")
    public void clicked(UIAlertView view, int buttonIndex) {
    }

    @Export("alertViewCancel:")
    public void canceled(UIAlertView alertView) {
    }

    @Export("alertView:willDismissWithButtonIndex:")
    public void willDismiss(UIAlertView alertView, int buttonIndex) {
    }

    @Export("alertView:didDismissWithButtonIndex:")
    public void dismissed(UIAlertView alertView, int buttonIndex) {
    }
}
