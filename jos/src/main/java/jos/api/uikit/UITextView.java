package jos.api.uikit;

import jos.api.foundation.NSAttributedString;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSRange;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({UITextInput.class})
@Register(isWrapper = true)
public class UITextView extends UIScrollView {

    @Export("delegate")
    public UITextViewDelegate getTextViewDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UITextViewDelegate value) {
        throw new RuntimeException();
    }

    @Export("text")
    public String getText() {
        throw new RuntimeException();
    }

    @Export("setText:")
    public void setText(String value) {
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

    @Export("textColor")
    public UIColor getTextColor() {
        throw new RuntimeException();
    }

    @Export("setTextColor:")
    public void setTextColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("textAlignment")
    public int getTextAlignment() {
        throw new RuntimeException();
    }

    @Export("setTextAlignment:")
    public void setTextAlignment(int value) {
        throw new RuntimeException();
    }

    @Export("selectedRange")
    public NSRange getSelectedRange() {
        throw new RuntimeException();
    }

    @Export("setSelectedRange:")
    public void setSelectedRange(NSRange value) {
        throw new RuntimeException();
    }

    @Bind("isEditable")
    @Export("editable")
    public boolean getEditable() {
        throw new RuntimeException();
    }

    @Export("setEditable:")
    public void setEditable(boolean value) {
        throw new RuntimeException();
    }

    @Export("dataDetectorTypes")
    public UIDataDetectorTypes getDataDetectorTypes() {
        throw new RuntimeException();
    }

    @Export("setDataDetectorTypes:")
    public void setDataDetectorTypes(UIDataDetectorTypes value) {
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

    @Export("attributedText")
    public NSAttributedString getAttributedText() {
        throw new RuntimeException();
    }

    @Export("setAttributedText:")
    public void setAttributedText(NSAttributedString value) {
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

    @Export("hasText")
    public boolean hasText() {
        throw new RuntimeException();
    }

    @Export("scrollRangeToVisible:")
    public void scrollRangeToVisible(NSRange range) {
        throw new RuntimeException();
    }

    @Export("inputView")
    public UIView inputView() {
        throw new RuntimeException();
    }

}
