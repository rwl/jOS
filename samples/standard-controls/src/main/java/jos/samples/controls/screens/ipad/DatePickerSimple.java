package jos.samples.controls.screens.ipad;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class DatePickerSimple extends UIViewController {

    @Outlet UILabel lblDate;

    @Outlet UIDatePicker pkrDate;

    public DatePickerSimple() {
        super("DatePickerSimple_iPad", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Simple Date Picker");

        /*pkrDate.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject object, UIEvent event) {
                lblDate.text = ((UIDatePicker) object).getDate().toString();
            }
        }, UIControlEvent.VALUE_CHANGED);*/
        pkrDate.addTarget(this, new Selector("handle_pkrDateValueChanged:"),
                UIControlEvent.VALUE_CHANGED);
    }

    @Export("handle_pkrDateValueChanged:")
    protected void handle_pkrDateValueChanged(NSObject object) {
        lblDate.setText(((UIDatePicker) object).getDate().toString());
    }

}
