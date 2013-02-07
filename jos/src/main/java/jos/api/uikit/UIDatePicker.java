package jos.api.uikit;

import java.util.Date;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIDatePicker extends UIControl {

    @Export("initWithFrame:")
    public UIDatePicker(CGRect frame) {
    }

    public UIDatePickerMode mode;
    public Date minimumDate;
    public Date maximumDate;
    public Date date;

    @Export("mode")
    public UIDatePickerMode getMode() {
        return mode;
    }

    @Export("setMode:")
    public void setMode(UIDatePickerMode mode) {
        this.mode = mode;
    }

    @Export("minimumDate")
    public Date getMinimumDate() {
        return minimumDate;
    }

    @Export("setMinimumDate:")
    public void setMinimumDate(Date minimumDate) {
        this.minimumDate = minimumDate;
    }

    @Export("maximumDate")
    public Date getMaximumDate() {
        return maximumDate;
    }

    @Export("setMaximumDate:")
    public void setMaximumDate(Date maximumDate) {
        this.maximumDate = maximumDate;
    }

    @Export("date")
    public Date getDate() {
        return date;
    }

    @Export("setDate:")
    public void setDate(Date date) {
        this.date = date;
    }

}
