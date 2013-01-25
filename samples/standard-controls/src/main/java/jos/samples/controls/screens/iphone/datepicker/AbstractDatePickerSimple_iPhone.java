package jos.samples.controls.screens.iphone.datepicker;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractDatePickerSimple_iPhone extends UIViewController {

    private UIView __jos_view;

    private UILabel __jos_lblDate;

    private UIDatePicker __jos_pkrDate;

    public AbstractDatePickerSimple_iPhone() {
        super();
    }

    public AbstractDatePickerSimple_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractDatePickerSimple_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractDatePickerSimple_iPhone(NSCoder coder) {
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