package jos.samples.controls.screens.ipad.datepicker;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Connect;

public abstract class AbstractDatePickerSimple_iPad extends UIViewController {

    private UIView __jos_view;
    private UILabel __jos_lblDate;
    private UIDatePicker __jos_pkrDate;

    public AbstractDatePickerSimple_iPad() {
        super();
    }

    public AbstractDatePickerSimple_iPad(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractDatePickerSimple_iPad(IntPtr handle) {
        super(handle);
    }

    public AbstractDatePickerSimple_iPad(NSCoder coder) {
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

    @Connect("pkrDate")
    protected UIDatePicker pkrDate() {
        this.__jos_pkrDate = (UIDatePicker) getNativeField("pkrDate");
        return this.__jos_pkrDate;
    }

    @Connect("pkrDate")
    protected void setPkrDate(UIDatePicker value) {
        this.__jos_pkrDate = value;
        setNativeField("pkrDate", value);
    }
}