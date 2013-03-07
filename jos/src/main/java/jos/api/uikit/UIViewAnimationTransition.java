package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIViewAnimationTransition {
    @Bind("UIViewAnimationTransitionNone") NONE,
    @Bind("UIViewAnimationTransitionFlipFromLeft") FLIP_FROM_LEFT,
    @Bind("UIViewAnimationTransitionFlipFromRight") FLIP_FROM_RIGHT,
    @Bind("UIViewAnimationTransitionCurlUp") CURL_UP,
    @Bind("UIViewAnimationTransitionCurlDown") CURL_DOWN;
}
