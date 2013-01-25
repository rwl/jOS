package jos.samples.controls.screens.iphone.toolbar;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractToolbar1_iPhone extends UIViewController {

    private UIView __jos_view;

    private UIBarButtonItem __mt_btnOne;

    private UIBarButtonItem __mt_btnTwo;

    private UIBarButtonItem __mt_btnThree;

    private UIBarButtonItem __mt_btnFour;

    public AbstractToolbar1_iPhone() {
        super();
    }

    public AbstractToolbar1_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractToolbar1_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractToolbar1_iPhone(NSCoder coder) {
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

    @Connect("btnFour")
    protected UIBarButtonItem btnFour() {
        this.__mt_btnFour = (UIBarButtonItem) getNativeField("btnFour");
        return this.__mt_btnFour;
    }
    @Connect("btnFour")
    protected void setBtnFour(UIBarButtonItem value) {
        this.__mt_btnFour = value;
        setNativeField("btnFour", value);
    }

    @Connect("btnOne")
    protected UIBarButtonItem btnOne() {
        this.__mt_btnOne = (UIBarButtonItem) getNativeField("btnOne");
        return this.__mt_btnOne;
    }

    @Connect("btnOne")
    protected void setBtnOne(UIBarButtonItem value) {
        this.__mt_btnOne = value;
        setNativeField("btnOne", value);
    }

    @Connect("btnThree")
    protected UIBarButtonItem btnThree() {
        this.__mt_btnThree = (UIBarButtonItem) getNativeField("btnThree");
        return this.__mt_btnThree;
    }

    @Connect("btnThree")
    protected void setBtnThree(UIBarButtonItem value) {
        this.__mt_btnThree = value;
        setNativeField("btnThree", value);
    }

    @Connect("btnTwo")
    protected UIBarButtonItem btnTwo() {
        this.__mt_btnTwo = (UIBarButtonItem) getNativeField("btnTwo");
        return this.__mt_btnTwo;
    }

    @Connect("btnTwo")
    protected void setBtnTwo(UIBarButtonItem value) {
        this.__mt_btnTwo = value;
        setNativeField("btnTwo", value);
    }
}