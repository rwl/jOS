package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UILabel extends UIView {

    public String text;
    public UITextAlignment textAlignment;
    public UIColor textColor;
    public UIFont font;
    public boolean adjustsFontSizeToFitWidth;
    public int minimumFontSize;
    public UILineBreakMode lineBreakMode;
    public int lines;

    @Export(selector = "initWithFrame:")
    public UILabel(CGRect frame) {
        super(frame);
    }

    public UILabel() {
    }

}
