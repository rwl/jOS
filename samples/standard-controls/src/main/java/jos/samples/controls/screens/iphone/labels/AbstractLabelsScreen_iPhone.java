package jos.samples.controls.screens.iphone.labels;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractLabelsScreen_iPhone extends UIViewController {

    private UIView __jos_view;

    public AbstractLabelsScreen_iPhone() {
        super();
    }

    public AbstractLabelsScreen_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractLabelsScreen_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractLabelsScreen_iPhone(NSCoder coder) {
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