package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITextAlignment {
    @Bind("NSTextAlignmentLeft") LEFT,
    @Bind("NSTextAlignmentCenter") CENTER,
    @Bind("NSTextAlignmentRight") RIGHT,
    @Bind("NSTextAlignmentJustified") JUSTIFIED,
    @Bind("NSTextAlignmentNatural") NATURAL
}
