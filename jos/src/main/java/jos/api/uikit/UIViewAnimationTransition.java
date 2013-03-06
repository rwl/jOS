package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIViewAnimationTransition {
    @Bind("UIViewAnimationTransitionNone") None,
    @Bind("UIViewAnimationTransitionFlipFromLeft") FlipFromLeft,
    @Bind("UIViewAnimationTransitionFlipFromRight") FlipFromRight,
    @Bind("UIViewAnimationTransitionCurlUp") CurlUp,
    @Bind("UIViewAnimationTransitionCurlDown") CurlDown;
}
