package jos.api.uikit;

import jos.api.foundation.NSAttributedString;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSDictionary;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({UITextInput.class, NSCoding.class})
@Register(isWrapper = true)
public class UITextField extends UIControl {

    @Export("init")
    public UITextField() {
        super();
    }

    @Export("initWithFrame:")
    public UITextField(final CGRect frame) {
        super();
    }


    @Export("attributedText")
    public NSAttributedString getAttributedText() {
        throw new RuntimeException();
    }

    @Export("setAttributedText:")
    public void setAttributedText(NSAttributedString value) {
        throw new RuntimeException();
    }

    @Export("textColor")
    public UIColor getTextColor() {
        throw new RuntimeException();
    }

    @Export("setTextColor:")
    public void setTextColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("font")
    public UIFont getFont() {
        throw new RuntimeException();
    }

    @Export("setFont:")
    public void setFont(UIFont value) {
        throw new RuntimeException();
    }

    @Export("textAlignment")
    public NSTextAlignment getTextAlignment() {
        throw new RuntimeException();
    }

    @Export("setTextAlignment:")
    public void setTextAlignment(NSTextAlignment value) {
        throw new RuntimeException();
    }

    @Export("borderStyle")
    public UITextBorderStyle getBorderStyle() {
        throw new RuntimeException();
    }

    @Export("setBorderStyle:")
    public void setBorderStyle(UITextBorderStyle value) {
        throw new RuntimeException();
    }

    @Export("placeholder")
    public String getPlaceholder() {
        throw new RuntimeException();
    }

    @Export("setPlaceholder:")
    public void setPlaceholder(String value) {
        throw new RuntimeException();
    }

    @Export("attributedPlaceholder")
    public NSAttributedString getAttributedPlaceholder() {
        throw new RuntimeException();
    }

    @Export("setAttributedPlaceholder:")
    public void setAttributedPlaceholder(NSAttributedString value) {
        throw new RuntimeException();
    }

    @Export("clearsOnBeginEditing")
    public boolean getClearsOnBeginEditing() {
        throw new RuntimeException();
    }

    @Export("setClearsOnBeginEditing:")
    public void setClearsOnBeginEditing(boolean value) {
        throw new RuntimeException();
    }

    @Export("adjustsFontSizeToFitWidth")
    public boolean getAdjustsFontSizeToFitWidth() {
        throw new RuntimeException();
    }

    @Export("setAdjustsFontSizeToFitWidth:")
    public void setAdjustsFontSizeToFitWidth(boolean value) {
        throw new RuntimeException();
    }

    @Export("minimumFontSize")
    public float getMinimumFontSize() {
        throw new RuntimeException();
    }

    @Export("setMinimumFontSize:")
    public void setMinimumFontSize(float value) {
        throw new RuntimeException();
    }

    @Export("delegate")
    public UITextFieldDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UITextFieldDelegate value) {
        throw new RuntimeException();
    }

    @Export("background")
    public UIImage getBackground() {
        throw new RuntimeException();
    }

    @Export("setBackground:")
    public void setBackground(UIImage value) {
        throw new RuntimeException();
    }

    @Export("disabledBackground")
    public UIImage getDisabledBackground() {
        throw new RuntimeException();
    }

    @Export("setDisabledBackground:")
    public void setDisabledBackground(UIImage value) {
        throw new RuntimeException();
    }

    @Bind("isEditing")
    @Export("editing")
    public boolean getEditing() {
        throw new RuntimeException();
    }

    @Export("allowsEditingTextAttributes")
    public boolean getAllowsEditingTextAttributes() {
        throw new RuntimeException();
    }

    @Export("setAllowsEditingTextAttributes:")
    public void setAllowsEditingTextAttributes(boolean value) {
        throw new RuntimeException();
    }

    @Export("typingAttributes")
    public NSDictionary getTypingAttributes() {
        throw new RuntimeException();
    }

    @Export("setTypingAttributes:")
    public void setTypingAttributes(NSDictionary value) {
        throw new RuntimeException();
    }

    @Export("leftView")
    public UIView getLeftView() {
        throw new RuntimeException();
    }

    @Export("setLeftView:")
    public void setLeftView(UIView value) {
        throw new RuntimeException();
    }

    @Export("leftViewMode")
    public UITextFieldViewMode getLeftViewMode() {
        throw new RuntimeException();
    }

    @Export("setLeftViewMode:")
    public void setLeftViewMode(UITextFieldViewMode value) {
        throw new RuntimeException();
    }

    @Export("rightView")
    public UIView getRightView() {
        throw new RuntimeException();
    }

    @Export("setRightView:")
    public void setRightView(UIView value) {
        throw new RuntimeException();
    }

    @Export("rightViewMode")
    public UITextFieldViewMode getRightViewMode() {
        throw new RuntimeException();
    }

    @Export("setRightViewMode:")
    public void setRightViewMode(UITextFieldViewMode value) {
        throw new RuntimeException();
    }

    @Export("inputAccessoryView")
    public UIView getInputAccessoryView() {
        throw new RuntimeException();
    }

    @Export("setInputAccessoryView:")
    public void setInputAccessoryView(UIView value) {
        throw new RuntimeException();
    }

    @Export("clearsOnInsertion")
    public boolean getClearsOnInsertion() {
        throw new RuntimeException();
    }

    @Export("setClearsOnInsertion:")
    public void setClearsOnInsertion(boolean value) {
        throw new RuntimeException();
    }

    @Export("text")
    public String getText() {
        throw new RuntimeException();
    }

    @Export("setText:")
    public void setText(String text) {
        throw new RuntimeException();
    }

    @Export("clearButtonMode")
    public UITextFieldViewMode clearButtonMode() {
        throw new RuntimeException();
    }

    @Export("setClearButtonMode:")
    public void setClearButtonMode(UITextFieldViewMode value) {
        throw new RuntimeException();
    }

    @Export("borderRectForBounds:")
    public CGRect borderRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("textRectForBounds:")
    public CGRect textRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("placeholderRectForBounds:")
    public CGRect placeholderRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("editingRectForBounds:")
    public CGRect editingRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("clearButtonRectForBounds:")
    public CGRect clearButtonRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("leftViewRectForBounds:")
    public CGRect leftViewRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("rightViewRectForBounds:")
    public CGRect rightViewRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("drawTextInRect:")
    public void drawTextInRect(CGRect rect) {
        throw new RuntimeException();
    }

    @Export("drawPlaceholderInRect:")
    public void drawPlaceholderInRect(CGRect rect) {
        throw new RuntimeException();
    }

    @Export("inputView")
    public UIView inputView() {
        throw new RuntimeException();
    }

}
