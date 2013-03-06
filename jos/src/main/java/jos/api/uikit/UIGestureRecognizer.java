package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGPoint;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@Register(isWrapper = true)
public class UIGestureRecognizer {

    @Export("state")
    public UIGestureRecognizerState getState() {
        throw new RuntimeException();
    }

    @Export("delegate")
    public UIGestureRecognizer getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UIGestureRecognizer value) {
        throw new RuntimeException();
    }

    @Bind("isEnabled")
    @Export("enabled")
    public boolean getEnabled() {
        throw new RuntimeException();
    }

    @Export("setEnabled:")
    public void setEnabled(boolean value) {
        throw new RuntimeException();
    }

    @Export("cancelsTouchesInView")
    public boolean getCancelsTouchesInView() {
        throw new RuntimeException();
    }

    @Export("setCancelsTouchesInView:")
    public void setCancelsTouchesInView(boolean value) {
        throw new RuntimeException();
    }

    @Export("delaysTouchesBegan")
    public boolean getDelaysTouchesBegan() {
        throw new RuntimeException();
    }

    @Export("setDelaysTouchesBegan:")
    public void setDelaysTouchesBegan(boolean value) {
        throw new RuntimeException();
    }

    @Export("delaysTouchesEnded")
    public boolean getDelaysTouchesEnded() {
        throw new RuntimeException();
    }

    @Export("setDelaysTouchesEnded:")
    public void setDelaysTouchesEnded(boolean value) {
        throw new RuntimeException();
    }

    @Export("handleGesture")
    public void handleGesture() {
        throw new RuntimeException();
    }

    @Export("handleGesture:")
    public void handleGesture(UIGestureRecognizer gestureRecognizer) {
        throw new RuntimeException();
    }

    @Export("initWithTarget:action:")
    public NSObject initWithTargetaction(NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("addTarget:action:")
    public void addTargetaction(NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("removeTarget:action:")
    public void removeTargetaction(NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("view")
    public UIView getView() {
        throw new RuntimeException();
    }

    @Export("requireGestureRecognizerToFail:")
    public void requireGestureRecognizerToFail(UIGestureRecognizer otherGestureRecognizer) {
        throw new RuntimeException();
    }

    @Export("locationInView:")
    public CGPoint locationInView(UIView view) {
        throw new RuntimeException();
    }

    @Export("numberOfTouches")
    public int numberOfTouches() {
        throw new RuntimeException();
    }

    @Export("locationOfTouch:inView:")
    public CGPoint locationOfTouchinView(int touchIndex, UIView view) {
        throw new RuntimeException();
    }

}
