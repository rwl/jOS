package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UITextInputTokenizer extends NSObject {

    @Export("rangeEnclosingPosition:withGranularity:inDirection:")
    public UITextRange rangeEnclosingPositionwithGranularityinDirection(UITextPosition position, UITextGranularity granularity, UITextDirection direction) {
        throw new RuntimeException();
    }

    @Export("isPosition:atBoundary:inDirection:")
    public boolean isPositionatBoundaryinDirection(UITextPosition position, UITextGranularity granularity, UITextDirection direction) {
        throw new RuntimeException();
    }

    @Export("positionFromPosition:toBoundary:inDirection:")
    public UITextPosition positionFromPositiontoBoundaryinDirection(UITextPosition position, UITextGranularity granularity, UITextDirection direction) {
        throw new RuntimeException();
    }

    @Export("isPosition:withinTextUnit:inDirection:")
    public boolean isPositionwithinTextUnitinDirection(UITextPosition position, UITextGranularity granularity, UITextDirection direction) {
        throw new RuntimeException();
    }

}