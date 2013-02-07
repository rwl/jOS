package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGImage {

    public float width;
    public float height;

    public CGImage(float width, float height) {
        this.width = width;
        this.height = height;
    }

}
