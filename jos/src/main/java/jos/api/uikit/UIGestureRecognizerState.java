package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIGestureRecognizerState {
    @Bind("UIGestureRecognizerStatePossible") Possible,
    @Bind("UIGestureRecognizerStateBegan") Began,
    @Bind("UIGestureRecognizerStateChanged") Changed,
    @Bind("UIGestureRecognizerStateEnded") Ended,
    @Bind("UIGestureRecognizerStateCancelled") Cancelled,
    @Bind("UIGestureRecognizerStateFailed") Failed,
    @Bind("UIGestureRecognizerStateRecognized") Recognized;
}
