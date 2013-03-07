package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CGBitmapContext {

    @Function
    @Export("CGBitmapContextCreate")
    public static CGContextRef CGBitmapContextCreate(Object data, int width,
            int height, int bitsPerComponent, int bytesPerRow,
            CGColorSpaceRef space, int bitmapInfo) {
        throw new RuntimeException();
    }

}
