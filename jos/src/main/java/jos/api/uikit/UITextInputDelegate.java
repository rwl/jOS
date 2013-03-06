package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UITextInputDelegate extends NSObject {

    @Export("selectionWillChange:")
    public void selectionWillChange(UITextInput textInput) {
        throw new RuntimeException();
    }

    @Export("selectionDidChange:")
    public void selectionDidChange(UITextInput textInput) {
        throw new RuntimeException();
    }

    @Export("textWillChange:")
    public void textWillChange(UITextInput textInput) {
        throw new RuntimeException();
    }

    @Export("textDidChange:")
    public void textDidChange(UITextInput textInput) {
        throw new RuntimeException();
    }

}