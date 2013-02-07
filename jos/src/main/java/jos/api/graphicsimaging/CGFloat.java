package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGFloat {

    public float value;

    public CGFloat(final float value) {
        this.value = value;
    }

}
