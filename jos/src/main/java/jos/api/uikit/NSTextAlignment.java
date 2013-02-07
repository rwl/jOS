package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true, header = "UIKit/UIKit.h")
public enum NSTextAlignment {
    @Bind("NSTextAlignmentLeft") LEFT,
    @Bind("NSTextAlignmentCenter") ENTER,
    @Bind("NSTextAlignmentRight") RIGHT,
    @Bind("NSTextAlignmentJustified") JUSTIFIED,
    @Bind("NSTextAlignmentNatural") NATURAL
}
