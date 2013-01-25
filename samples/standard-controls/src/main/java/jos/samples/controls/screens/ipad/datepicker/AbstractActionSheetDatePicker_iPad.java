package jos.samples.controls.screens.ipad.datepicker;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public abstract class AbstractActionSheetDatePicker_iPad extends UIViewController {

    private UIView __jos_view;
    private UIButton __jos_btnChooseDate;
    private UILabel __jos_lblDate;

    public AbstractActionSheetDatePicker_iPad() {
        super();
    }

    public AbstractActionSheetDatePicker_iPad(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractActionSheetDatePicker_iPad(IntPtr handle) {
        super(handle);
    }

    public AbstractActionSheetDatePicker_iPad(NSCoder coder) {
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
        this.__jos_btnChooseDate = (UIButton) getNativeField("btnChooseDate");
        return this.__jos_btnChooseDate;
    }

    @Connect("btnChooseDate")
    protected void setBtnChooseDate(UIButton value) {
        this.__jos_btnChooseDate = value;
        setNativeField("btnChooseDate", value);
    }

    @Connect("lblDate")
    protected UILabel lblDate() {
        this.__jos_lblDate = (UILabel) getNativeField("lblDate");
        return this.__jos_lblDate;
    }

    @Connect("lblDate")
    protected void setLblDate(UILabel value) {
        this.__jos_lblDate = value;
        setNativeField("lblDate", value);
    }
}