package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Abstract;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UITextInputTraits extends NSObject {

    @Abstract
    @Export("autocorrectionType")
    public UITextAutocorrectionType getAutocorrectionType() {
        throw new RuntimeException();
    }

    @Export("setAutocorrectionType:")
    public void setAutocorrectionType(UITextAutocorrectionType value) {
        throw new RuntimeException();
    }

    @Abstract
    @Export("spellCheckingType")
    public UITextSpellCheckingType getSpellCheckingType() {
        throw new RuntimeException();
    }

    @Export("setSpellCheckingType:")
    public void setSpellCheckingType(UITextSpellCheckingType value) {
        throw new RuntimeException();
    }

    @Abstract
    @Export("keyboardType")
    public UIKeyboardType getKeyboardType() {
        throw new RuntimeException();
    }

    @Export("setKeyboardType:")
    public void setKeyboardType(UIKeyboardType value) {
        throw new RuntimeException();
    }

    @Abstract
    @Export("keyboardAppearance")
    public UIKeyboardAppearance getKeyboardAppearance() {
        throw new RuntimeException();
    }

    @Export("setKeyboardAppearance:")
    public void setKeyboardAppearance(UIKeyboardAppearance value) {
        throw new RuntimeException();
    }

    @Abstract
    @Export("returnKeyType")
    public UIReturnKeyType getReturnKeyType() {
        throw new RuntimeException();
    }

    @Export("setReturnKeyType:")
    public void setReturnKeyType(UIReturnKeyType value) {
        throw new RuntimeException();
    }

    @Abstract
    @Export("enablesReturnKeyAutomatically")
    public boolean getEnablesReturnKeyAutomatically() {
        throw new RuntimeException();
    }

    @Export("setEnablesReturnKeyAutomatically:")
    public void setEnablesReturnKeyAutomatically(boolean value) {
        throw new RuntimeException();
    }

    @Abstract
    @Bind("isSecureTextEntry")
    @Export("secureTextEntry")
    public boolean getSecureTextEntry() {
        throw new RuntimeException();
    }

    @Export("setSecureTextEntry:")
    public void setSecureTextEntry(boolean value) {
        throw new RuntimeException();
    }

    @Export("autocapitalizationType")
    public UITextAutocapitalizationType autocapitalizationType() {
        throw new RuntimeException();
    }

}

