package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIViewAutoresizing {
    None,
    FlexibleLeftMargin,
    FlexibleWidth,
    FlexibleRightMargin,
    FlexibleTopMargin,
    FlexibleHeight,
    @Bind("UIViewAutoresizingFlexibleBottomMargin") FlexibleBottomMargin
}
