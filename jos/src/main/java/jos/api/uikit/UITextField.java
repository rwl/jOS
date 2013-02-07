package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UITextField extends UIControl {

    public UIFont font;
    public UITextBorderStyle borderStyle;
    public String placeholder;

    @Export("initWithFrame:")
    public UITextField(CGRect frame) {
    }

    @Export("font")
    public UIFont getFont() {
        return font;
    }

    @Export("setFont:")
    public void setFont(UIFont font) {
        this.font = font;
    }

    @Export("borderStyle")
    public UITextBorderStyle getBorderStyle() {
        return borderStyle;
    }

    @Export("setBorderStyle:")
    public void setBorderStyle(UITextBorderStyle borderStyle) {
        this.borderStyle = borderStyle;
    }

    @Export("placeholder")
    public String getPlaceholder() {
        return placeholder;
    }

    @Export("setPlaceholder:")
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

}
