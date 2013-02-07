package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIActivityIndicatorView extends UIView {

    @Export("initWithActivityIndicatorStyle:")
    public UIActivityIndicatorView(UIActivityIndicatorViewStyle style) {
    }

    @Export("startAnimating")
    public void startAnimating() {
    }

}
