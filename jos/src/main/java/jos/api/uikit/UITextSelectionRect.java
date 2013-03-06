package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITextSelectionRect {

    @Export("rect")
    public CGRect getRect() {
        throw new RuntimeException();
    }

    @Export("containsStart")
    public boolean getContainsStart() {
        throw new RuntimeException();
    }

    @Export("containsEnd")
    public boolean getContainsEnd() {
        throw new RuntimeException();
    }

    @Export("isVertical")
    public boolean getIsVertical() {
        throw new RuntimeException();
    }

}