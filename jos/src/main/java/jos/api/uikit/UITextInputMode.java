package jos.api.uikit;

import jos.api.foundation.NSArray;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITextInputMode {

    @Export("primaryLanguage")
    public String getPrimaryLanguage() {
        throw new RuntimeException();
    }

    @Export("currentInputMode")
    public static UITextInputMode currentInputMode() {
        throw new RuntimeException();
    }

    @Export("activeInputModes")
    public static NSArray activeInputModes() {
        throw new RuntimeException();
    }

}

