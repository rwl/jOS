package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public abstract class UIScrollViewDelegate extends NSObject {

    @Export("scrollViewDidScroll:")
    public void scrolled(UIScrollView view) {
    }

    @Export("viewForZoomingInScrollView:scrollView")
    public UIView viewForZoomingInScrollView(UIScrollView view) {
        return null;
    }
}
