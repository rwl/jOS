package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UILabel extends UIView {

    public String text;
    public NSTextAlignment textAlignment;

    public UILabel(CGRect frame) {
        super(frame);
    }

}
