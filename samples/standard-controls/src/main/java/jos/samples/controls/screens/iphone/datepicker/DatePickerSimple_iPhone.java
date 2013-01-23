package jos.samples.controls.screens.iphone.datepicker;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class DatePickerSimple_iPhone extends UIViewController {

    public DatePickerSimple_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public DatePickerSimple_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public DatePickerSimple_iPhone() {
        super("DatePickerSimple_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        title = "Simple Date Picker";

        //pkrDate.valueChanged += (s, e) => { this.lblDate.Text = (s as UIDatePicker).Date.ToString (); };
    }
}
