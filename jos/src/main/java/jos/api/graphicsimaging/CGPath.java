package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGPath {

    @Function
    @Export("CGPathCreateMutable")
    public static CGPath createPath() {
        throw new RuntimeException();
    }

    @Function
    @Export("CGPathMoveToPoint")
    public static void moveToPoint(CGPath path,
            CGAffineTransform m, float x, float y) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGPathAddCurveToPoint")
    public static void addCurveToPoint(CGPath path,
            CGAffineTransform m, float cp1x, float cp1y,
            float cp2x, float cp2y, float x, float y) {
        throw new RuntimeException();
    }

}
