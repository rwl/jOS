package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGColorSpace {

    @Function
    @Export("CreateDeviceRGB")
    public static CGColorSpaceRef createDeviceRGB() {
        throw new RuntimeException();
    }

}
