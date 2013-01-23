package jos.samples.controls.screens.iphone.datepicker;

import jos.api.uikit.UIViewController;

public class DatePicker_iPhone extends UIViewController {

    ActionSheetDatePicker actionSheetDatePicker;
    ActionSheetDatePicker actionSheetTimerPicker;

    public DatePicker_iPhone (IntPtr handle) {
        super(handle);
        initialize ();
    }

    @Export(selector = "initWithCoder:")
    public DatePicker_iPhone (NSCoder coder) {
        super(coder);
        initialize ();
    }

    public DatePicker_iPhone () {
        super("DatePicker_iPhone", null);
        initialize ();
    }

    void initialize ()
    {
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
        actionSheetDatePicker.datePicker.minimumDate = DateTime.today.addDays (-7);
        actionSheetDatePicker.datePicker.maximumDate = DateTime.today.addDays (7);
        this.btnChooseDate.TouchUpInside += (s, e) => {
            actionSheetDatePicker.Show ();
        };

        // setup our countdown timer
        actionSheetTimerPicker = new ActionSheetDatePicker (this.view);
        actionSheetTimerPicker.title = "Choose Time:";
        actionSheetTimerPicker.datePicker.mode = UIDatePickerMode.countDownTimer;
    }

    protected void Handle_actionSheetDatePickerDatePickerValueChanged (Object sender, EventArgs e)
    {
        this.lblDate.text = (sender as UIDatePicker).date.toString ();
    }
}
