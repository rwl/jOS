package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CGPoint {
    public CGFloat x;
    public CGFloat y;

    public CGPoint(final CGFloat x, final CGFloat y) {
        this.x = x;
        this.y = y;
    }
}
