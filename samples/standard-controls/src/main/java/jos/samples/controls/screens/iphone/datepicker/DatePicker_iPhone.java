package jos.samples.controls.screens.iphone.datepicker;

import java.util.GregorianCalendar;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIDatePickerMode;
import jos.api.uikit.UIEvent;
import jos.samples.controls.controls.ActionSheetDatePicker;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Selector;

public class DatePicker_iPhone extends AbstractDatePicker_iPhone {

    ActionSheetDatePicker actionSheetDatePicker;
    ActionSheetDatePicker actionSheetTimerPicker;

    public DatePicker_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public DatePicker_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public DatePicker_iPhone() {
        super("DatePicker_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "Date Picker";

        // setup our custom action sheet date picker
        actionSheetDatePicker = new ActionSheetDatePicker(this.view);
        actionSheetDatePicker.title("Choose Date:");
        actionSheetDatePicker.datePicker.addTarget(this, new Selector(
                "handle_actionSheetDatePickerDatePickerValueChanged"),
                UIControlEvent.ValueChanged);
        actionSheetDatePicker.datePicker.mode = UIDatePickerMode.DateAndTime;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DAY_OF_MONTH, -7);
        actionSheetDatePicker.datePicker.minimumDate = calendar.getTime();
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 14);
        actionSheetDatePicker.datePicker.maximumDate = calendar.getTime();
        this.btnChooseDate().addTarget(new EventListener() {

            @Override
            public void onEvent(Object object, int event) {
                actionSheetDatePicker.show();
            }
        }, UIControlEvent.TouchUpInside);

        // setup our countdown timer
        actionSheetTimerPicker = new ActionSheetDatePicker(this.view);
        actionSheetTimerPicker.title("Choose Time:");
        actionSheetTimerPicker.datePicker.mode = UIDatePickerMode.CountDownTimer;
    }

    protected void Handle_actionSheetDatePickerDatePickerValueChanged(
            Object sender, UIEvent e) {
        this.lblDate().text = ((UIDatePicker) sender).date.toString();
    }
}