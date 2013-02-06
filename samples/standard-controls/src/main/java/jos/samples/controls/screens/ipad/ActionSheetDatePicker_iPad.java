package jos.samples.controls.screens.ipad;

import java.util.GregorianCalendar;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

import jos.api.foundation.NSCoder;
import jos.api.foundation.NSObject;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIDatePickerMode;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;
import jos.samples.controls.controls.ActionSheetDatePicker;

public class ActionSheetDatePicker_iPad extends UIViewController {

    @Outlet UIButton btnChooseDate;
    @Outlet UILabel lblDate;

    ActionSheetDatePicker actionSheetDatePicker;
    ActionSheetDatePicker actionSheetTimerPicker;

    public ActionSheetDatePicker_iPad(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public ActionSheetDatePicker_iPad(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ActionSheetDatePicker_iPad() {
        super("ActionSheetDatePicker_iPad", null);
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
        this.btnChooseDate.addTarget(new EventListener() {

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

    protected void handle_actionSheetDatePickerDatePickerValueChanged(
            NSObject sender, UIEvent e) {
        this.lblDate.text = ((UIDatePicker) sender).date.toString();
    }

}
