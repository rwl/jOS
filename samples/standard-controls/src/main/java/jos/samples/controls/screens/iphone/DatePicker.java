package jos.samples.controls.screens.iphone;

import java.util.GregorianCalendar;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIDatePickerMode;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;
import jos.samples.controls.controls.ActionSheetDatePicker;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class DatePicker extends UIViewController {

    @Outlet
    UIView view;

    @Outlet
    UIButton btnChooseDate;

    @Outlet
    UILabel lblDate;

    ActionSheetDatePicker datePicker, timerPicker;

    public DatePicker() {
        super("DatePicker_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Date Picker");

        // setup our custom action sheet date picker
        datePicker = new ActionSheetDatePicker(view);
        datePicker.setTitle("Choose Date:");
        datePicker.getDatePicker().addTarget(this, new Selector(
                "handleActionSheetDatePickerValueChanged:"),
                UIControlEvent.VALUE_CHANGED);
        datePicker.getDatePicker().setMode(UIDatePickerMode.DATE_AND_TIME);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DAY_OF_MONTH, -7);
        datePicker.getDatePicker().setMinimumDate(calendar.getTime());
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 14);
        datePicker.getDatePicker().setMaximumDate(calendar.getTime());
        /*btnChooseDate.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject object, UIEvent event) {
                datePicker.show();
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);*/
        btnChooseDate.addTarget(this, new Selector("handleBtnChooseDate"),
                UIControlEvent.TOUCH_UP_INSIDE);

        // setup our countdown timer
        timerPicker = new ActionSheetDatePicker(view);
        timerPicker.setTitle("Choose Time:");
        timerPicker.getDatePicker().setMode(UIDatePickerMode.COUNTDOWN_TIMER);
    }

    @Export("handleActionSheetDatePickerValueChanged:")
    protected void handleActionSheetDatePickerValueChanged(
            NSObject sender) {
        this.lblDate.text = ((UIDatePicker) sender).date.toString();
    }

    protected void handleBtnChooseDate() {
        datePicker.show();
    }

}
