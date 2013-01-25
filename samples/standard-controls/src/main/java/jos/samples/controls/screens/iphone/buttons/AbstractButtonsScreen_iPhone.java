package jos.samples.controls.screens.iphone.buttons;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public abstract class AbstractButtonsScreen_iPhone extends UIViewController {

    private UIView __mt_view;

    private UIButton __mt_btnOne;

    private UIButton __mt_btnTwo;

    public AbstractButtonsScreen_iPhone() {
        super();
    }

    public AbstractButtonsScreen_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractButtonsScreen_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractButtonsScreen_iPhone(NSCoder coder) {
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

    @Connect("btnOne")
    protected UIButton btnOne() {
        this.__mt_btnOne = (UIButton) getNativeField("btnOne");
        return this.__mt_btnOne;
    }

    @Connect("btnOne")
    protected void setBtnOne(UIButton value) {
        this.__mt_btnOne = value;
        setNativeField("btnOne", value);
    }

    @Connect("btnTwo")
    protected UIButton btnTwo() {
        this.__mt_btnTwo = (UIButton) getNativeField("btnTwo");
        return this.__mt_btnTwo;
    }

    @Connect("btnTwo")
    protected void setBtnTwo(UIButton value) {
        this.__mt_btnTwo = value;
        setNativeField("btnTwo", value);
    }
}