package jos.dialog;

import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIDatePickerMode;

public class DateElement extends DateTimeElement {

    public DateElement(String caption, DateTime date) {
        super(caption, date);
        fmt.setDateStyle(NSDateFormatterStyle.MEDIUM);
    }

    @Override
    public String FormatDate(DateTime dt) {
        return fmt.toString(GetDateWithKind(dt));
    }

    @Override
    public UIDatePicker CreatePicker() {
        UIDatePicker picker = super.CreatePicker();
        picker.setMode(UIDatePickerMode.DATE);
        return picker;
    }

}