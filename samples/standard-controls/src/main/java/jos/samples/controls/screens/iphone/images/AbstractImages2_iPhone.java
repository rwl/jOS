package jos.samples.controls.screens.iphone.images;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractImages2_iPhone extends UIViewController {

    private UIView __jos_view;

    public AbstractImages2_iPhone() {
        super();
    }

    public AbstractImages2_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractImages2_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractImages2_iPhone(NSCoder coder) {
        super(coder);
    }

    @Connect("view")
    protected UIView view() {
        this.__jos_view = ((UIView) (getNativeField("view")));
        return this.__jos_view;
    }

    @Connect("view")
    protected void setView(UIView value) {
        this.__jos_view = value;
        setNativeField("view", value);
    }
}