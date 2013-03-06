package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIFont extends NSObject {

    @Export("fontWithName:size:")
    public static UIFont fromName(String string, int i) {
        return null;
    }

    @Export("boldSystemFontOfSize:")
    public static UIFont boldSystemFontOfSize(int size) {
        return null;
    }

    @Export("buttonFontSize")
    public static float buttonFontSize() {
        throw new RuntimeException();
    }

    @Export("systemFontSize")
    public static float systemFontSize() {
        throw new RuntimeException();
    }

}
