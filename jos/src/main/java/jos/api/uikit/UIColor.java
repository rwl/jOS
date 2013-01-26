package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UIColor extends NSObject {

    @Bind("lightGrayColor")
    public static UIColor lightGray;

    @Bind("whiteColor")
    public static UIColor white;

    @Bind("blueColor")
    public static UIColor blue;

    @Bind("clearColor")
    public static UIColor clear;

    public static UIColor lightTextColor;

    public static UIColor fromRGB(float f, float g, float i) {
        return null;
    }
}
