package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UIColor extends NSObject {

    public static UIColor lightGrayColor;
    public static UIColor clearColor;
    @Bind("whiteColor")
    public static UIColor white;

}
