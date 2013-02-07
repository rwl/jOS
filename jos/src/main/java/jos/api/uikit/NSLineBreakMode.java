package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true, header = "UIKit/UIKit.h")
public enum NSLineBreakMode {
    @Bind("NSLineBreakByCharWrapping") CHARACTER_WRAP,
    @Bind("NSLineBreakByClipping") CLIP,
    @Bind("NSLineBreakByTruncatingHead") HEAD_TRUNCATION,
    @Bind("NSLineBreakByTruncatingMiddle") MIDDLE_TRUNCATION,
    @Bind("NSLineBreakByTruncatingTail") TAIL_TRUNCATION,
    @Bind("NSLineBreakByWordWrapping") WORD_WRAP
}
