package jos.api.graphicsimaging;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGImageRef extends NSObject {

    public float width;
    public float height;

    public CGImageRef(float width, float height) {
        this.width = width;
        this.height = height;
    }

}
