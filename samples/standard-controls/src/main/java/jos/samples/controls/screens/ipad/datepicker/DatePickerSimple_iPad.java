package jos.samples.controls.screens.ipad.datepicker;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;

public class DatePickerSimple_iPad extends AbstractDatePickerSimple_iPad {

    public DatePickerSimple_iPad(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public DatePickerSimple_iPad(NSCoder coder) {
        super(coder);
        initialize();
    }

    public DatePickerSimple_iPad() {
        super("DatePickerSimple_iPad", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        title = "Simple Date Picker";

        pkrDate().addTarget(new EventListener() {
            @Override
            public void onEvent(Object object, int event) {
                lblDate().text = ((UIDatePicker) object).date.toString();
            }
        }, UIControlEvent.ValueChanged);
    }
}
