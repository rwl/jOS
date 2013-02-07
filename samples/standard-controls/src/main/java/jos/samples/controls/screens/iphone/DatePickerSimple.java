package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Outlet;

public class DatePickerSimple extends UIViewController {

    @Outlet
    UILabel lblDate;

    @Outlet
    UIDatePicker pkrDate;

    public DatePickerSimple() {
        super("DatePickerSimple_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Simple Date Picker");

        pkrDate.addTarget(new EventListener() {
            @Override
            public void onEvent(Object object, int event) {
                lblDate.setText(((UIDatePicker) object).getDate().toString());
            }
        }, UIControlEvent.VALUE_CHANGED);
    }

}
