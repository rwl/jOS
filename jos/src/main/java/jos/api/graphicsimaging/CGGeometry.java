package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public abstract class CGGeometry {

    @Function
    @Export("CGRectMake:y:width:height:")
    public static CGRect makeRect(float x, float y, float width, float height) {
        return null;
    }

    @Function
    @Export("CGSizeMake:height:")
    public static CGSize makeSize(float width, float height) {
        return null;
    }

    @Function
    @Export("CGPointMake:y:")
    public static CGPoint makePoint(float x, float y) {
        return null;
    }

}
