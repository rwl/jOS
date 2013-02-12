package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CGRect {

    public CGPoint origin;
    public CGSize size;

    public CGRect(final CGPoint point, final CGSize size) {
        this.origin = point;
        this.size = size;
    }
}
