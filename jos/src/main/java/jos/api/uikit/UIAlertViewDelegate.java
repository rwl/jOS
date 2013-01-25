package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public abstract class UIAlertViewDelegate {

    @Export(selector = "alertView:clickedButtonAtIndex:")
    public void clicked(UIAlertView view, int buttonIndex) {
    }

    @Export(selector = "alertViewCancel:")
    public void canceled(UIAlertView alertView) {
    }

    @Export(selector = "alertView:willDismissWithButtonIndex:")
    public void willDismiss(UIAlertView alertView, int buttonIndex) {
    }

    @Export(selector = "alertView:didDismissWithButtonIndex:")
    public void dismissed(UIAlertView alertView, int buttonIndex) {
    }
}
