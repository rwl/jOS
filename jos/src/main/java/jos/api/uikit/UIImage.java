package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGImageRef;
import jos.api.graphicsimaging.CGSize;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIImage extends NSObject {

    @Export("imageNamed:")
    public static UIImage fromBundle(String string) {
        return null;
    }

    @Export("imageWithContentsOfFile:")
    public static UIImage fromFile(String string) {
        return null;
    }

    @Export("imageWithCGImage:")
    public static UIImage fromImage(CGImageRef cgImage) {
        return null;
    }

    public CGImageRef CGImage;
    public CGSize size;

    @Export("CGImage")
    public CGImageRef getImage() {
        return CGImage;
    }

    @Export("size")
    public CGSize getSize() {
        return size;
    }

}
