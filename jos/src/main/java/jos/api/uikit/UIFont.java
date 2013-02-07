package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

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

}
