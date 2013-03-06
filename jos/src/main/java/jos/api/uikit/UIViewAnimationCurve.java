package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIViewAnimationCurve {
    @Bind("UIViewAnimationCurveEaseInOut") EaseInOut,
    @Bind("UIViewAnimationCurveEaseIn") EaseIn,
    @Bind("UIViewAnimationCurveEaseOut") EaseOut,
    @Bind("UIViewAnimationCurveLinear") Linear;
}
