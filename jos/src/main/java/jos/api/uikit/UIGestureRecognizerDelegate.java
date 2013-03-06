package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIGestureRecognizerDelegate extends NSObject {

    @Export("gestureRecognizerShouldBegin:")
    public boolean gestureRecognizerShouldBegin(UIGestureRecognizer gestureRecognizer) {
        throw new RuntimeException();
    }

    @Export("gestureRecognizershouldRecognizeSimultaneouslyWithGestureRecognizer:")
    public UIGestureRecognizer gestureRecognizershouldRecognizeSimultaneously(UIGestureRecognizer otherGestureRecognizer) {
        throw new RuntimeException();
    }

    @Export("gestureRecognizer:shouldReceiveTouch:")
    public boolean gestureRecognizershouldReceiveTouch(UIGestureRecognizer gestureRecognizer, UITouch touch) {
        throw new RuntimeException();
    }

}
