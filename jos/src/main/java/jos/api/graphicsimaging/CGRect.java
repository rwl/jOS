package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CGRect {

    public CGPoint point;
    public CGSize size;

    public CGRect(final CGPoint point, final CGSize size) {
        this.point = point;
        this.size = size;
    }
}
