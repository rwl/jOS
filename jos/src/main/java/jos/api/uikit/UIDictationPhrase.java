package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIDictationPhrase {

    @Export("alternativeInterpretations")
    public NSArray getAlternativeInterpretations() {
        throw new RuntimeException();
    }

    @Export("text")
    public NSString text() {
        throw new RuntimeException();
    }

}