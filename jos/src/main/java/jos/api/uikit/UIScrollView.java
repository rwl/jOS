package jos.api.uikit;

import jos.api.foundation.NSCoder;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.system.IntPtr;

public class UIScrollView extends UIView {

    public UIScrollViewDelegate delegate;
    public CGPoint contentOffset;
    public CGSize contentSize;
    public float zoomScale;
    public float maximumZoomScale;
    public float minimumZoomScale;

    public UIScrollView(CGRect frame) {
        super(frame);
    }

    public UIScrollView(IntPtr handle) {
    }

    public UIScrollView(NSCoder coder) {
    }

    public UIScrollView() {
    }

    public void scrollRectToVisible(CGRect frame, boolean b) {
    }

    public void setZoomScale(int i, boolean b) {
    }
}
