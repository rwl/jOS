package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIActivityIndicatorViewStyle {
    @Bind("UIActivityIndicatorViewStyleWhiteLarge") WHITE_LARGE,
    @Bind("UIActivityIndicatorViewStyleWhite") WHITE,
    @Bind("UIActivityIndicatorViewStyleGray") GRAY
}
