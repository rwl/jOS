package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public abstract class UIAlertViewDelegate extends NSObject {

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
