package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public abstract class UIScrollViewDelegate extends NSObject {

    @Export(selector = "scrollViewDidScroll:")
    public void scrolled(UIScrollView view) {
    }

}
