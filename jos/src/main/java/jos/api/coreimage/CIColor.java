package jos.api.coreimage;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIColor;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CIColor {

    @Export("initWithColor:")
    public NSObject initWithColor(UIColor color) {
        throw new RuntimeException();
    }

}