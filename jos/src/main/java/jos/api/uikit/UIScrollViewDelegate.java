package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public abstract class UIScrollViewDelegate extends NSObject {

    @Export("scrollViewDidScroll:")
    public void scrolled(UIScrollView scrollView) {
    }

    @Export("viewForZoomingInScrollView:")
    public UIView viewForZoomingInScrollView(UIScrollView scrollView) {
        return null;
    }

}
