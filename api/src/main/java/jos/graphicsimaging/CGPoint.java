package jos.graphicsimaging;

import jos.api.Register;

@Register(isWrapper = true)
public class CGPoint {
    public CGFloat x;
    public CGFloat y;

    public CGPoint(final CGFloat x, final CGFloat y) {
        this.x = x;
        this.y = y;
    }
}
