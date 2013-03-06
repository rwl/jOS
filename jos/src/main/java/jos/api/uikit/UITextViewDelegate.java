package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSRange;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@BaseType(UIScrollViewDelegate.class)
@Model
@Register(isWrapper = true)
public class UITextViewDelegate extends NSObject {
    @Export("textViewShouldBeginEditing:")
    public boolean textViewShouldBeginEditing(UITextView textView) {
        throw new RuntimeException();
    }

    @Export("textViewShouldEndEditing:")
    public boolean textViewShouldEndEditing(UITextView textView) {
        throw new RuntimeException();
    }

    @Export("textViewDidBeginEditing:")
    public void textViewDidBeginEditing(UITextView textView) {
        throw new RuntimeException();
    }

    @Export("textViewDidEndEditing:")
    public void textViewDidEndEditing(UITextView textView) {
        throw new RuntimeException();
    }

    @Export("textView:shouldChangeTextInRange:replacementText:")
    public boolean textViewshouldChangeTextInRangereplacementText(UITextView textView, NSRange range, String text) {
        throw new RuntimeException();
    }

    @Export("textViewDidChange:")
    public void textViewDidChange(UITextView textView) {
        throw new RuntimeException();
    }

    @Export("textViewDidChangeSelection:")
    public void textViewDidChangeSelection(UITextView textView) {
        throw new RuntimeException();
    }

}