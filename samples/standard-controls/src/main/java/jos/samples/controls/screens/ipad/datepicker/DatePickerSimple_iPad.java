package jos.samples.controls.screens.ipad.datepicker;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class DatePickerSimple_iPad extends UIViewController {

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
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        title = "Simple Date Picker";

        pkrDate.valueChanged += (s, e) => {
            this.lblDate.text = ((UIDatePicker) s).date.toString();
        };
    }
}
