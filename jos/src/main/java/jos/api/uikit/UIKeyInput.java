package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

//@BaseType(UITextInputTraits.class)
@Model
@Register(isWrapper = true)
public class UIKeyInput extends NSObject {

    @Export("hasText")
    public boolean hasText() {
        throw new RuntimeException();
    }

    @Export("insertText:")
    public void insertText(String text) {
        throw new RuntimeException();
    }

    @Export("deleteBackward")
    public void deleteBackward() {
        throw new RuntimeException();
    }

}