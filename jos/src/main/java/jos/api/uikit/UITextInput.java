package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSComparisonResult;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSRange;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Abstract;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@BaseType(UIKeyInput.class)
@Model
@Register(isWrapper = true)
public class UITextInput extends NSObject {
    @Abstract
    @Export("markedTextStyle")
    public NSDictionary getMarkedTextStyle() {
        throw new RuntimeException();
    }

    @Export("setMarkedTextStyle:")
    public void setMarkedTextStyle(NSDictionary value) {
        throw new RuntimeException();
    }

    @Abstract
    @Export("endOfDocument")
    public UITextPosition getEndOfDocument() {
        throw new RuntimeException();
    }

    @Export("textInRange:")
    public String textInRange(UITextRange range) {
        throw new RuntimeException();
    }

    @Export("replaceRange:withText:")
    public void replaceRangewithText(UITextRange range, String text) {
        throw new RuntimeException();
    }

    @Export("selectedTextRange")
    public UITextRange selectedTextRange() {
        throw new RuntimeException();
    }

    @Export("markedTextRange")
    public UITextRange markedTextRange() {
        throw new RuntimeException();
    }

    @Export("setMarkedText:selectedRange:")
    public void setMarkedTextselectedRange(String markedText, NSRange selectedRange) {
        throw new RuntimeException();
    }

    @Export("unmarkText")
    public void unmarkText() {
        throw new RuntimeException();
    }

    @Export("beginningOfDocument")
    public UITextPosition beginningOfDocument() {
        throw new RuntimeException();
    }

    @Export("textRangeFromPosition:toPosition:")
    public UITextRange textRangeFromPositiontoPosition(UITextPosition fromPosition, UITextPosition toPosition) {
        throw new RuntimeException();
    }

    @Export("positionFromPosition:offset:")
    public UITextPosition positionFromPositionoffset(UITextPosition position, int offset) {
        throw new RuntimeException();
    }

    @Export("positionFromPosition:inDirection:offset:")
    public UITextPosition positionFromPositioninDirectionoffset(UITextPosition position, UITextLayoutDirection direction, int offset) {
        throw new RuntimeException();
    }

    @Export("comparePosition:toPosition:")
    public NSComparisonResult comparePositiontoPosition(UITextPosition position, UITextPosition other) {
        throw new RuntimeException();
    }

    @Export("offsetFromPosition:toPosition:")
    public int offsetFromPositiontoPosition(UITextPosition from, UITextPosition toPosition) {
        throw new RuntimeException();
    }

    @Export("inputDelegate")
    public UITextInputDelegate inputDelegate() {
        throw new RuntimeException();
    }

    @Export("tokenizer")
    public UITextInputTokenizer tokenizer() {
        throw new RuntimeException();
    }

    @Export("positionWithinRange:farthestInDirection:")
    public UITextPosition positionWithinRangefarthestInDirection(UITextRange range, UITextLayoutDirection direction) {
        throw new RuntimeException();
    }

    @Export("characterRangeByExtendingPosition:inDirection:")
    public UITextRange characterRangeByExtendingPositioninDirection(UITextPosition position, UITextLayoutDirection direction) {
        throw new RuntimeException();
    }

    @Export("baseWritingDirectionForPosition:inDirection:")
    public UITextWritingDirection baseWritingDirectionForPositioninDirection(UITextPosition position, UITextStorageDirection direction) {
        throw new RuntimeException();
    }

    @Export("setBaseWritingDirection:forRange:")
    public void setBaseWritingDirectionforRange(UITextWritingDirection writingDirection, UITextRange range) {
        throw new RuntimeException();
    }

    @Export("firstRectForRange:")
    public CGRect firstRectForRange(UITextRange range) {
        throw new RuntimeException();
    }

    @Export("caretRectForPosition:")
    public CGRect caretRectForPosition(UITextPosition position) {
        throw new RuntimeException();
    }

    @Export("selectionRectsForRange:")
    public NSArray selectionRectsForRange(UITextRange range) {
        throw new RuntimeException();
    }

    @Export("closestPositionToPoint:")
    public UITextPosition closestPositionToPoint(CGPoint point) {
        throw new RuntimeException();
    }

    @Export("closestPositionToPoint:withinRange:")
    public UITextPosition closestPositionToPointwithinRange(CGPoint point, UITextRange range) {
        throw new RuntimeException();
    }

    @Export("characterRangeAtPoint:")
    public UITextRange characterRangeAtPoint(CGPoint point) {
        throw new RuntimeException();
    }

    @Export("shouldChangeTextInRange:replacementText:")
    public boolean shouldChangeTextInRangereplacementText(UITextRange range, String text) {
        throw new RuntimeException();
    }

    @Export("textStylingAtPosition:inDirection:")
    public NSDictionary textStylingAtPositioninDirection(UITextPosition position, UITextStorageDirection direction) {
        throw new RuntimeException();
    }

    @Export("positionWithinRange:atCharacterOffset:")
    public UITextPosition positionWithinRangeatCharacterOffset(UITextRange range, int offset) {
        throw new RuntimeException();
    }

    @Export("characterOffsetOfPosition:withinRange:")
    public int characterOffsetOfPositionwithinRange(UITextPosition position, UITextRange range) {
        throw new RuntimeException();
    }

    @Export("textInputView")
    public UIView textInputView() {
        throw new RuntimeException();
    }

    @Export("selectionAffinity")
    public UITextStorageDirection selectionAffinity() {
        throw new RuntimeException();
    }

    @Export("insertDictationResult:")
    public void insertDictationResult(NSArray dictationResult) {
        throw new RuntimeException();
    }

    @Export("dictationRecordingDidEnd")
    public void dictationRecordingDidEnd() {
        throw new RuntimeException();
    }

    @Export("dictationRecognitionFailed")
    public void dictationRecognitionFailed() {
        throw new RuntimeException();
    }

    @Export("insertDictationResultPlaceholder")
    public NSObject insertDictationResultPlaceholder() {
        throw new RuntimeException();
    }

    @Export("frameForDictationResultPlaceholder:")
    public CGRect frameForDictationResultPlaceholder(NSObject placeholder) {
        throw new RuntimeException();
    }

    @Export("removeDictationResultPlaceholder:willInsertResult:")
    public void removeDictationResultPlaceholderwillInsertResult(NSObject placeholder, boolean willInsertResult) {
        throw new RuntimeException();
    }

}