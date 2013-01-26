package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public enum UITextAlignment {
    @Bind("NSTextAlignmentLeft") Left,
    @Bind("NSTextAlignmentCenter") Center,
    @Bind("NSTextAlignmentRight") Right,
    @Bind("NSTextAlignmentJustified") Justified,
    @Bind("NSTextAlignmentNatural") Natural
}
