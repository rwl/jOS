package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Weak;

import jos.api.foundation.NSCoder;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.system.IntPtr;

public class UIScrollView extends UIView {

    @Weak
    public UIScrollViewDelegate delegate;
    public CGPoint contentOffset;
    public CGSize contentSize;
    public float zoomScale;
    public float maximumZoomScale;
    public float minimumZoomScale;

    @Export("initWithFrame:")
    public UIScrollView(CGRect frame) {
        super(frame);
    }

    public UIScrollView(IntPtr handle) {
    }

    @Export("initWithCoder:")
    public UIScrollView(NSCoder coder) {
    }

    @Export("init")
    public UIScrollView() {
    }

    @Export("scrollRectToVisible:animated:")
    public void scrollRectToVisible(CGRect frame, boolean b) {
    }

    @Export("setZoomScale:animated:")
    public void setZoomScale(int i, boolean b) {
    }

    @Export("delegate")
    public UIScrollViewDelegate getDelegate() {
        return delegate;
    }

    @Export("setDelegate:")
    public void setDelegate(UIScrollViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Export("contentOffset")
    public CGPoint getContentOffset() {
        return contentOffset;
    }

    @Export("setContentOffset:")
    public void setContentOffset(CGPoint contentOffset) {
        this.contentOffset = contentOffset;
    }

    @Export("contentSize")
    public CGSize getContentSize() {
        return contentSize;
    }

    @Export("setContentSize:")
    public void setContentSize(CGSize contentSize) {
        this.contentSize = contentSize;
    }

    @Export("zoomScale")
    public float getZoomScale() {
        return zoomScale;
    }

    @Export("setZoomScale:")
    public void setZoomScale(float zoomScale) {
        this.zoomScale = zoomScale;
    }

    @Export("maximumZoomScale")
    public float getMaximumZoomScale() {
        return maximumZoomScale;
    }

    @Export("setMaximumZoomScale:")
    public void setMaximumZoomScale(float maximumZoomScale) {
        this.maximumZoomScale = maximumZoomScale;
    }

    @Export("minimumZoomScale")
    public float getMinimumZoomScale() {
        return minimumZoomScale;
    }

    @Export("setMinimumZoomScale:")
    public void setMinimumZoomScale(float minimumZoomScale) {
        this.minimumZoomScale = minimumZoomScale;
    }

}
