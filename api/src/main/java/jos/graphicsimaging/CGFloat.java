package jos.graphicsimaging;

import jos.api.Register;

@Register(isWrapper = true)
public class CGFloat {
    public float value;

    public CGFloat(final float value) {
        this.value = value;
    }
}
