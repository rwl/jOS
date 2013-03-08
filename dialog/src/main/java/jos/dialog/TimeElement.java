package jos.dialog;

import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIDatePickerMode;

public class TimeElement extends DateTimeElement {

    public TimeElement(String caption, DateTime date) {
        super(caption, date);
    }

    @Override
    public String FormatDate(DateTime dt) {
        return GetDateWithKind(dt).toLocalTime().toShortTimeString();
    }

    @Override
    public UIDatePicker CreatePicker() {
        UIDatePicker picker = super.CreatePicker();
        picker.setMode(UIDatePickerMode.TIME);
        return picker;
    }

}