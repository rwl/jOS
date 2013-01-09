package jos.graphicsimaging;

import jos.api.Register;

@Register(isWrapper = true)
public class CGRect {
    
    public CGPoint point;
    public CGSize size;
    
    public CGRect(final CGPoint point, final CGSize size) {
        this.point = point;
        this.size = size;
    }
}
