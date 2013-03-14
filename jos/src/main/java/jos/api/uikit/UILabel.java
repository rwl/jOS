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
    public float minimumFontSize;
    public NSLineBreakMode lineBreakMode;
    public int numberOfLines;

    @Export("initWithFrame:")
    public UILabel(CGRect frame) {
        super(frame);
    }

    @Export("init")
    public UILabel() {
    }

    @Export("text")
    public String getText() {
        return text;
    }

    @Export("setText:")
    public void setText(String text) {
        this.text = text;
    }

    @Export("textAlignment")
    public UITextAlignment getTextAlignment() {
        return textAlignment;
    }

    @Export("setTextAlignment:")
    public void setTextAlignment(UITextAlignment textAlignment) {
        this.textAlignment = textAlignment;
    }

    @Export("textColor")
    public UIColor getTextColor() {
        return textColor;
    }

    @Export("setTextColor:")
    public void setTextColor(UIColor textColor) {
        this.textColor = textColor;
    }

    @Export("font")
    public UIFont getFont() {
        return font;
    }

    @Export("setFont:")
    public void setFont(UIFont font) {
        this.font = font;
    }

    @Export("adjustsFontSizeToFitWidth")
    public boolean isAdjustsFontSizeToFitWidth() {
        return adjustsFontSizeToFitWidth;
    }

    @Export("setAdjustsFontSizeToFitWidth:")
    public void setAdjustsFontSizeToFitWidth(boolean adjustsFontSizeToFitWidth) {
        this.adjustsFontSizeToFitWidth = adjustsFontSizeToFitWidth;
    }

    @Export("minimumFontSize")
    public float getMinimumFontSize() {
        return minimumFontSize;
    }

    @Export("setMinimumFontSize:")
    public void setMinimumFontSize(float minimumFontSize) {
        this.minimumFontSize = minimumFontSize;
    }

    @Export("lineBreakMode")
    public NSLineBreakMode getLineBreakMode() {
        return lineBreakMode;
    }

    @Export("setLineBreakMode:")
    public void setLineBreakMode(UILineBreakMode lineBreakMode) {
        throw new RuntimeException();
    }

    @Export("numberOfLines")
    public int getNumberOfLines() {
        return numberOfLines;
    }

    @Export("setNumberOfLines:")
    public void setLines(int lines) {
        this.numberOfLines = lines;
    }

}
