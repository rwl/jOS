package jos.samples.controls.screens.iphone.activityspinner;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractActivitySpinnerScreen_iPhone extends UIViewController {

    private UIView __mt_view;

    public AbstractActivitySpinnerScreen_iPhone() {
        super();
    }

    public AbstractActivitySpinnerScreen_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractActivitySpinnerScreen_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractActivitySpinnerScreen_iPhone(NSCoder coder) {
        super(coder);
    }

    @Connect("view")
    protected UIView view() {
        this.__mt_view = (UIView) getNativeField("view");
        return this.__mt_view;
    }

    @Connect("view")
    protected void setView(UIView value) {
        this.__mt_view = value;
        setNativeField("view", value);
    }

}