package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public class UIViewAnimationOptions {

    @Bind("UIViewAnimationOptionLayoutSubviews")
    public static final int Layout_Subviews = 1 << 0;

    @Bind("UIViewAnimationOptionAllowUserInteraction")
    public static final int ALLOW_USER_INTERACTION = 1 << 1;

    @Bind("UIViewAnimationOptionBeginFromCurrentState")
    public static final int BEGIN_FROM_CURRENT_STATE = 1 << 2;

    @Bind("UIViewAnimationOptionRepeat")
    public static final int REPEAT = 1 << 3;

    @Bind("UIViewAnimationOptionAutoreverse")
    public static final int AUTOREVERSE = 1 << 4;

    @Bind("UIViewAnimationOptionOverrideInheritedDuration")
    public static final int OVERRIDE_INHERITED_DURATION = 1 << 5;

    @Bind("UIViewAnimationOptionOverrideInheritedCurve")
    public static final int OVERRIDE_INHERITED_CURVE = 1 << 6;

    @Bind("UIViewAnimationOptionAllowAnimatedContent")
    public static final int ALLOW_ANIMATED_CONTENT = 1 << 7;

    @Bind("UIViewAnimationOptionShowHideTransitionViews")
    public static final int SHOW_HIDE_TRANSITION_VIEWS = 1 << 8;

    @Bind("UIViewAnimationOptionCurveEaseInOut")
    public static final int CURVE_EASE_IN_OUT = 0 << 16;

    @Bind("UIViewAnimationOptionCurveEaseIn")
    public static final int CURVE_EASE_IN = 1 << 16;

    @Bind("UIViewAnimationOptionCurveEaseOut")
    public static final int CURVE_EASE_OUT = 2 << 16;

    @Bind("UIViewAnimationOptionCurveLinear")
    public static final int CURVE_LINEAR = 3 << 16;

    @Bind("UIViewAnimationOptionTransitionNone")
    public static final int TRANSITION_NONE = 0 << 20;

    @Bind("UIViewAnimationOptionTransitionFlipFromLeft")
    public static final int TRANSITION_FLIP_FROM_LEFT = 1 << 20;

    @Bind("UIViewAnimationOptionTransitionFlipFromRight")
    public static final int TRANSITION_FLIP_FROM_RIGHT = 2 << 20;

    @Bind("UIViewAnimationOptionTransitionCurlUp")
    public static final int TRANSITION_CURL_UP = 3 << 20;

    @Bind("UIViewAnimationOptionTransitionCurlDown")
    public static final int TRANSITION_CURL_DOWN = 4 << 20;

    @Bind("UIViewAnimationOptionTransitionCrossDissolve")
    public static final int TRANSITION_CROSS_DISSOLVE = 5 << 20;

    @Bind("UIViewAnimationOptionTransitionFlipFromTop")
    public static final int TRANSITION_FLIP_FROM_TOP = 6 << 20;

    @Bind("UIViewAnimationOptionTransitionFlipFromBottom")
    public static final int TRANSITION_FLIP_FROM_BOTTOM = 7 << 20;
}
