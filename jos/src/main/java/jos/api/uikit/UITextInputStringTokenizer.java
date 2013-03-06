package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(UITextInputTokenizer.class)
@Register(isWrapper = true)
public class UITextInputStringTokenizer extends UITextInputTokenizer {

    @Export("initWithTextInput:")
    public NSObject initWithTextInput(UITextInput textInput) {
        throw new RuntimeException();
    }

}