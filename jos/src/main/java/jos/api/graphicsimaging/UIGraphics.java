package jos.api.graphicsimaging;

import jos.api.uikit.UIImage;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public abstract class UIGraphics {

    @Function
    @Export("UIGraphicsGetCurrentContext")
    public static CGContextRef getCurrentContext() {
        throw new RuntimeException();
    }

    @Function
    @Export("UIGraphicsBeginImageContext")
    public static void beginImageContext(CGSize size) {
        throw new RuntimeException();
    }

    @Function
    @Export("UIGraphicsGetImageFromCurrentImageContext")
    public static UIImage getImageFromCurrentImageContext() {
        throw new RuntimeException();
    }

    @Function
    @Export("UIGraphicsEndImageContext")
    public static void endImageContext() {
        throw new RuntimeException();
    }

}
