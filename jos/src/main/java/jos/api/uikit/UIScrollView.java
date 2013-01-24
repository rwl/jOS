package jos.api.uikit;

import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;

public class UIScrollView extends UIView {

    public UIScrollViewDelegate delegate;
    public CGPoint contentOffset;
    public CGSize contentSize;

    public UIScrollView(CGRect frame) {
        super(frame);
    }

    public void scrollRectToVisible(CGRect frame, boolean b) {
    }

}
