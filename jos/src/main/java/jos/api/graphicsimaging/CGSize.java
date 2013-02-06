package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGSize {
    public float width;
    public float height;

    public CGSize(final float width, final float height) {
        this.width = width;
        this.height = height;
    }
}
