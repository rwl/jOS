package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIDatePickerMode {
    @Bind("UIDatePickerModeTime") TIME,
    @Bind("UIDatePickerModeDate") DATE,
    @Bind("UIDatePickerModeDateAndTime") DATE_AND_TIME,
    @Bind("UIDatePickerModeCountDownTimer") COUNTDOWN_TIMER
}
