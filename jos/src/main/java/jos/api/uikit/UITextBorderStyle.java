package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITextBorderStyle {
    @Bind("UITextBorderStyleNone") NONE,
    @Bind("UITextBorderStyleLine") LINE,
    @Bind("UITextBorderStyleBezel") BEZEL,
    @Bind("UITextBorderStyleRoundedRect") ROUNDED_RECT
}
