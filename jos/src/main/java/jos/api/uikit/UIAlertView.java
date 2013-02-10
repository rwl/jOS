package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIAlertView extends UIView {

    public UIAlertViewDelegate delegate;

    public String message;

    @Export("initWithFrame:")
    public UIAlertView(CGRect frame) {
        super(frame);
    }

    @Export("initWithTitle:message:delegate:cancelButtonTitle:otherButtonTitles:")
    public UIAlertView(String title, String message, NSObject delegate,
            String cancelButtonTitle, String... otherButtonTitles) {
        super(null);
    }

    @Export("init")
    public UIAlertView() {
    }

    @Export("show")
    public void show() {
    }

    @Export("dismissWithClickedButtonIndex:animated:")
    public void dismissWithClickedButtonIndex(int i, boolean animated) {
    }

    @Export("delegate")
    public UIAlertViewDelegate getDelegate() {
        return delegate;
    }

    @Export("setDelegate:")
    public void setDelegate(UIAlertViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Export("message")
    public String getMessage() {
        return message;
    }

    @Export("setMessage:")
    public void setMessage(String message) {
        this.message = message;
    }

}
