package jos.samples.controls.screens.iphone.progressbar;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIProgressView;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractProgressBars_iPhone extends UIViewController {

    private UIView __jos_view;

    private UIProgressView __jos_btnProgress1;

    public AbstractProgressBars_iPhone() {
        super();
    }

    public AbstractProgressBars_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractProgressBars_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractProgressBars_iPhone(NSCoder coder) {
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

    @Connect("btnProgress1")
    protected UIProgressView btnProgress1() {
        this.__jos_btnProgress1 = (UIProgressView) getNativeField("btnProgress1");
        return this.__jos_btnProgress1;
    }

    @Connect("btnProgress1")
    protected void setBtnProgress1(UIProgressView value) {
        this.__jos_btnProgress1 = value;
        setNativeField("btnProgress1", value);
    }
}