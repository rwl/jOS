package jos.samples.controls.screens.iphone.datepicker;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractDatePicker_iPhone extends UIViewController {

    private UIView __jos_view;

    private UIButton __mt_btnChooseDate;

    private UILabel __mt_lblDate;

    public AbstractDatePicker_iPhone() {
        super();
    }

    public AbstractDatePicker_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractDatePicker_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractDatePicker_iPhone(NSCoder coder) {
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

    @Connect("btnChooseDate")
    protected UIButton btnChooseDate() {
        this.__mt_btnChooseDate = (UIButton) getNativeField("btnChooseDate");
        return this.__mt_btnChooseDate;
    }

    @Connect("btnChooseDate")
    protected void setBtnChooseDate(UIButton value) {
        this.__mt_btnChooseDate = value;
        setNativeField("btnChooseDate", value);
    }

    @Connect("lblDate")
    protected UILabel lblDate() {
        this.__mt_lblDate = (UILabel) getNativeField("lblDate");
        return this.__mt_lblDate;
    }

    @Connect("lblDate")
    protected void setLblDate(UILabel value) {
        this.__mt_lblDate = value;
        setNativeField("lblDate", value);
    }
}