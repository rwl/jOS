package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSRange;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UITextFieldDelegate extends NSObject {

    @Export("textFieldShouldBeginEditing:")
    public boolean shouldStart(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldDidBeginEditing:")
    public void started(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldShouldEndEditing:")
    public boolean shouldEnd(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldDidEndEditing:")
    public void ended(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textField:shouldChangeCharactersInRange:replacementString:")
    public boolean valueChanged(UITextField textField, NSRange range, String string) {
        throw new RuntimeException();
    }

    @Export("textFieldShouldClear:")
    public boolean shouldClear(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldShouldReturn:")
    public boolean shouldReturn(UITextField textField) {
        throw new RuntimeException();
    }

}

