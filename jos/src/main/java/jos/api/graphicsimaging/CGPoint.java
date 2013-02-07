package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGPoint {
    public float x;
    public float y;

    public CGPoint(final float x, final float y) {
        this.x = x;
        this.y = y;
    }
}
