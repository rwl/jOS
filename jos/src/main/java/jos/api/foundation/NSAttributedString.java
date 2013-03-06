package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSMutableCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class NSAttributedString extends NSObject {
    @Export("string")
    public String string() {
        throw new RuntimeException();
    }

    @Export("length")
    public int length() {
        throw new RuntimeException();
    }

    @Export("attributedSubstringFromRange:")
    public NSAttributedString attributedSubstringFromRange(NSRange range) {
        throw new RuntimeException();
    }

    /*@Export("attributesAtIndex:longestEffectiveRange:inRange:")
    public NSDictionary attributesAtIndexlongestEffectiveRangeinRange(int location, NSRangePointer range, NSRange rangeLimit) {
        throw new RuntimeException();
    }

    @Export("attribute:atIndex:longestEffectiveRange:inRange:")
    public NSObject attributeatIndexlongestEffectiveRangeinRange(String attrName, int location, NSRangePointer range, NSRange rangeLimit) {
        throw new RuntimeException();
    }*/

    @Export("isEqualToAttributedString:")
    public boolean isEqualToAttributedString(NSAttributedString other) {
        throw new RuntimeException();
    }

    @Export("initWithString:")
    public NSObject initWithString(String str) {
        throw new RuntimeException();
    }

    @Export("initWithString:attributes:")
    public NSObject initWithStringattributes(String str, NSDictionary attrs) {
        throw new RuntimeException();
    }

    @Export("initWithAttributedString:")
    public NSObject initWithAttributedString(NSAttributedString attrStr) {
        throw new RuntimeException();
    }

}