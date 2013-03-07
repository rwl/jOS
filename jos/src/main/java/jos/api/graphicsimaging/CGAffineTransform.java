package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGAffineTransform {
    CGFloat a, b, c, d;
    CGFloat tx, ty;

    @Function
    @Export("CGAffineTransformIdentity")
    public static CGAffineTransform makeIdentity() {
        throw new RuntimeException();
    }

    @Function
    @Export("CGAffineTransformScale")
    public static CGAffineTransform scale(CGAffineTransform t,
            float sx, float sy) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGAffineTransformTranslate")
    public static CGAffineTransform translate(CGAffineTransform t,
            float tx, float ty) {
        throw new RuntimeException();
    }

}
