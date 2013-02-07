package jos.samples.controls.screens.ipad;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class DatePickerSimple extends UIViewController {

    @Outlet UILabel lblDate;
    @Outlet UIDatePicker pkrDate;

    public DatePickerSimple(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export("initWithCoder:")
    public DatePickerSimple(NSCoder coder) {
        super(coder);
        initialize();
    }

    public DatePickerSimple() {
        super("DatePickerSimple_iPad", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        title = "Simple Date Picker";

        pkrDate.addTarget(new EventListener() {
            @Override
            public void onEvent(Object object, int event) {
                lblDate.text = ((UIDatePicker) object).date.toString();
            }
        }, UIControlEvent.VALUE_CHANGED);
    }

}
