package jos.samples.controls.screens.iphone.switches;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UISwitch;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractSwitches_iPhone extends UIViewController {

    private UIView __jos_view;

    private UISwitch __mt_swchOne;

    private UISwitch __mt_swchTwo;

    public AbstractSwitches_iPhone() {
        super();
    }

    public AbstractSwitches_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractSwitches_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractSwitches_iPhone(NSCoder coder) {
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

    @Connect("swchOne")
    protected UISwitch swchOne() {
        this.__mt_swchOne = (UISwitch) getNativeField("swchOne");
        return this.__mt_swchOne;
    }

    @Connect("swchOne")
    protected void setSwchOne(UISwitch value) {
        this.__mt_swchOne = value;
        setNativeField("swchOne", value);
    }

    @Connect("swchTwo")
    protected UISwitch swchTwo() {
        this.__mt_swchTwo = (UISwitch) getNativeField("swchTwo");
        return this.__mt_swchTwo;
    }

    @Connect("swchTwo")
    protected void setSwchTwo(UISwitch value) {
        this.__mt_swchTwo = value;
        setNativeField("swchTwo", value);
    }
}