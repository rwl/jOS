package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIViewAnimationCurve {
    @Bind("UIViewAnimationCurveEaseInOut") EASE_IN_OUT,
    @Bind("UIViewAnimationCurveEaseIn") EASE_IN,
    @Bind("UIViewAnimationCurveEaseOut") EASE_OUT,
    @Bind("UIViewAnimationCurveLinear") LINEAR;
}
