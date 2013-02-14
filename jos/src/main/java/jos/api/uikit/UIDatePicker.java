package jos.api.uikit;

import jos.api.foundation.NSDate;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIDatePicker extends UIControl {

    @Export("initWithFrame:")
    public UIDatePicker(CGRect frame) {
    }

    public UIDatePickerMode datePickerMode;
    public NSDate minimumDate;
    public NSDate maximumDate;
    public NSDate date;

    @Export("datePickerMode")
    public UIDatePickerMode getMode() {
        return datePickerMode;
    }

    @Export("setDatePickerMode:")
    public void setMode(UIDatePickerMode mode) {
        this.datePickerMode = mode;
    }

    @Export("minimumDate")
    public NSDate getMinimumDate() {
        return minimumDate;
    }

    @Export("setMinimumDate:")
    public void setMinimumDate(NSDate minimumDate) {
        this.minimumDate = minimumDate;
    }

    @Export("maximumDate")
    public NSDate getMaximumDate() {
        return maximumDate;
    }

    @Export("setMaximumDate:")
    public void setMaximumDate(NSDate maximumDate) {
        this.maximumDate = maximumDate;
    }

    @Export("date")
    public NSDate getDate() {
        return date;
    }

    @Export("setDate:")
    public void setDate(NSDate date) {
        this.date = date;
    }

}
