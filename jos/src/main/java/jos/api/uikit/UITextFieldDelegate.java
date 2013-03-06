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
    public boolean textFieldShouldBeginEditing(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldDidBeginEditing:")
    public void textFieldDidBeginEditing(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldShouldEndEditing:")
    public boolean textFieldShouldEndEditing(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldDidEndEditing:")
    public void textFieldDidEndEditing(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textField:shouldChangeCharactersInRange:replacementString:")
    public boolean textFieldshouldChangeCharactersInRangereplacementString(UITextField textField, NSRange range, String string) {
        throw new RuntimeException();
    }

    @Export("textFieldShouldClear:")
    public boolean textFieldShouldClear(UITextField textField) {
        throw new RuntimeException();
    }

    @Export("textFieldShouldReturn:")
    public boolean textFieldShouldReturn(UITextField textField) {
        throw new RuntimeException();
    }

}

