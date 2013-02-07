package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UIColor extends NSObject {

    @Export("initWithRed:green:blue:alpha:")
    public UIColor(float r, float g, int b, int a) {
    }

    @Bind("lightGrayColor")
    public static UIColor LIGHT_GRAY;

    @Bind("whiteColor")
    public static UIColor WHITE;

    @Bind("blueColor")
    public static UIColor BLUE;

    @Bind("clearColor")
    public static UIColor CLEAR;

    @Bind("lightTextColor")
    public static UIColor LIGHT_TEXT_COLOR;

}
