package jos.samples.controls.screens.ipad.datepicker;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class ActionSheetDatePicker_iPad extends UIViewController {

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
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        this.title = "Date Picker";

        // setup our custom action sheet date picker
        actionSheetDatePicker = new ActionSheetDatePicker (this.view);
        actionSheetDatePicker.title = "Choose Date:";
        actionSheetDatePicker.datePicker.valueChanged += handle_actionSheetDatePickerDatePickerValueChanged;
        actionSheetDatePicker.datePicker.mode = UIDatePickerMode.DateAndTime;
        actionSheetDatePicker.datePicker.minimumDate = DateTime.today.addDays(-7);
        actionSheetDatePicker.datePicker.maximumDate = DateTime.today.addDays(7);
        this.btnChooseDate.touchUpInside += (s, e) => { actionSheetDatePicker.show(); };

        // setup our countdown timer
        actionSheetTimerPicker = new ActionSheetDatePicker(this.view);
        actionSheetTimerPicker.title = "Choose Time:";
        actionSheetTimerPicker.datePicker.mode = UIDatePickerMode.CountDownTimer;
    }

    protected void handle_actionSheetDatePickerDatePickerValueChanged(
            Ibject sender, EventArgs e) {
        this.lblDate.text = ((UIDatePicker) sender).date.toString();
    }
}
