package jos.api.foundation;

import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.NSLineBreakMode;
import jos.api.uikit.UIBaselineAdjustment;
import jos.api.uikit.UIFont;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSMutableCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSString extends NSObject {

    @Export("length")
    public int length() {
        throw new RuntimeException();
    }

    @Export("characterAtIndex:")
    public char characterAtIndex(int index) {
        throw new RuntimeException();
    }

    @Export("substringFromIndex:")
    public String substringFromIndex(int from) {
        throw new RuntimeException();
    }

    @Export("substringToIndex:")
    public String substringToIndex(int to) {
        throw new RuntimeException();
    }

    @Export("substringWithRange:")
    public String substringWithRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("compare:")
    public NSComparisonResult compare(NSString str) {
        throw new RuntimeException();
    }

    @Export("compare:options:")
    public NSComparisonResult compareoptions(String string, NSStringCompareOptions mask) {
        throw new RuntimeException();
    }

    @Export("compare:options:range:")
    public NSComparisonResult compareoptionsrange(String string, NSStringCompareOptions mask, NSRange compareRange) {
        throw new RuntimeException();
    }

    @Export("compare:options:range:locale:")
    public NSComparisonResult compareoptionsrangelocale(String string, NSStringCompareOptions mask, NSRange compareRange, NSObject locale) {
        throw new RuntimeException();
    }

    @Export("caseInsensitiveCompare:")
    public NSComparisonResult caseInsensitiveCompare(String string) {
        throw new RuntimeException();
    }

    @Export("localizedCompare:")
    public NSComparisonResult localizedCompare(String string) {
        throw new RuntimeException();
    }

    @Export("localizedCaseInsensitiveCompare:")
    public NSComparisonResult localizedCaseInsensitiveCompare(String string) {
        throw new RuntimeException();
    }

    @Export("localizedStandardCompare:")
    public NSComparisonResult localizedStandardCompare(String string) {
        throw new RuntimeException();
    }

    @Export("isEqualToString:")
    public boolean isEqualToString(String aString) {
        throw new RuntimeException();
    }

    @Export("hasPrefix:")
    public boolean hasPrefix(String aString) {
        throw new RuntimeException();
    }

    @Export("hasSuffix:")
    public boolean hasSuffix(String aString) {
        throw new RuntimeException();
    }

    @Export("rangeOfString:")
    public NSRange rangeOfString(NSString str) {
        throw new RuntimeException();
    }

    @Export("rangeOfString:options:")
    public NSRange rangeOfStringoptions(String aString, NSStringCompareOptions mask) {
        throw new RuntimeException();
    }

    @Export("rangeOfString:options:range:")
    public NSRange rangeOfStringoptionsrange(String aString, NSStringCompareOptions mask, NSRange searchRange) {
        throw new RuntimeException();
    }

    @Export("rangeOfString:options:range:locale:")
    public NSRange rangeOfStringoptionsrangelocale(String aString, NSStringCompareOptions mask, NSRange searchRange, NSLocale locale) {
        throw new RuntimeException();
    }

    @Export("rangeOfComposedCharacterSequenceAtIndex:")
    public NSRange rangeOfComposedCharacterSequenceAtIndex(int index) {
        throw new RuntimeException();
    }

    @Export("rangeOfComposedCharacterSequencesForRange:")
    public NSRange rangeOfComposedCharacterSequencesForRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("stringByAppendingString:")
    public String stringByAppendingString(String aString) {
        throw new RuntimeException();
    }

    @Export("stringByAppendingFormat:")
    public String stringByAppendingFormat(String format) {
        throw new RuntimeException();
    }

    @Export("doubleValue")
    public double doubleValue() {
        throw new RuntimeException();
    }

    @Export("floatValue")
    public float floatValue() {
        throw new RuntimeException();
    }

    @Export("intValue")
    public int intValue() {
        throw new RuntimeException();
    }

    @Export("integerValue")
    public int integerValue() {
        throw new RuntimeException();
    }

    @Export("longLongValue")
    public long longLongValue() {
        throw new RuntimeException();
    }

    @Export("boolValue")
    public boolean boolValue() {
        throw new RuntimeException();
    }

    @Export("componentsSeparatedByString:")
    public NSArray componentsSeparatedByString(NSString str) {
        throw new RuntimeException();
    }

    @Export("commonPrefixWithString:options:")
    public String commonPrefixWithStringoptions(String aString, NSStringCompareOptions mask) {
        throw new RuntimeException();
    }

    @Export("uppercaseString")
    public NSString uppercaseString() {
        throw new RuntimeException();
    }

    @Export("lowercaseString")
    public String lowercaseString() {
        throw new RuntimeException();
    }

    @Export("capitalizedString")
    public String capitalizedString() {
        throw new RuntimeException();
    }

    @Export("uppercaseStringWithLocale:")
    public String uppercaseStringWithLocale(NSLocale locale) {
        throw new RuntimeException();
    }

    @Export("lowercaseStringWithLocale:")
    public String lowercaseStringWithLocale(NSLocale locale) {
        throw new RuntimeException();
    }

    @Export("capitalizedStringWithLocale:")
    public String capitalizedStringWithLocale(NSLocale locale) {
        throw new RuntimeException();
    }

    @Export("stringByPaddingToLength:withString:startingAtIndex:")
    public String stringByPaddingToLengthwithStringstartingAtIndex(int newLength, String padString, int padIndex) {
        throw new RuntimeException();
    }

    @Export("getLineStart:end:contentsEnd:forRange:")
    public void getLineStartendcontentsEndforRange(int startPtr, int lineEndPtr, int contentsEndPtr, NSRange range) {
        throw new RuntimeException();
    }

    @Export("lineRangeForRange:")
    public NSRange lineRangeForRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("getParagraphStart:end:contentsEnd:forRange:")
    public void getParagraphStartendcontentsEndforRange(int startPtr, int parEndPtr, int contentsEndPtr, NSRange range) {
        throw new RuntimeException();
    }

    @Export("paragraphRangeForRange:")
    public NSRange paragraphRangeForRange(NSRange range) {
        throw new RuntimeException();
    }

    @Export("description")
    public String description() {
        throw new RuntimeException();
    }

    @Export("hash")
    public int hash() {
        throw new RuntimeException();
    }

    @Export("fastestEncoding")
    public NSStringEncoding fastestEncoding() {
        throw new RuntimeException();
    }

    @Export("smallestEncoding")
    public NSStringEncoding smallestEncoding() {
        throw new RuntimeException();
    }

    @Export("dataUsingEncoding:allowLossyConversion:")
    public NSData dataUsingEncodingallowLossyConversion(NSStringEncoding encoding, boolean lossy) {
        throw new RuntimeException();
    }

    @Export("dataUsingEncoding:")
    public NSData dataUsingEncoding(NSStringEncoding encoding) {
        throw new RuntimeException();
    }

    @Export("canBeConvertedToEncoding:")
    public boolean canBeConvertedToEncoding(NSStringEncoding encoding) {
        throw new RuntimeException();
    }

    @Export("maximumLengthOfBytesUsingEncoding:")
    public int maximumLengthOfBytesUsingEncoding(NSStringEncoding enc) {
        throw new RuntimeException();
    }

    @Export("lengthOfBytesUsingEncoding:")
    public int lengthOfBytesUsingEncoding(NSStringEncoding enc) {
        throw new RuntimeException();
    }

    @Export("decomposedStringWithCanonicalMapping")
    public String decomposedStringWithCanonicalMapping() {
        throw new RuntimeException();
    }

    @Export("precomposedStringWithCanonicalMapping")
    public String precomposedStringWithCanonicalMapping() {
        throw new RuntimeException();
    }

    @Export("decomposedStringWithCompatibilityMapping")
    public String decomposedStringWithCompatibilityMapping() {
        throw new RuntimeException();
    }

    @Export("precomposedStringWithCompatibilityMapping")
    public String precomposedStringWithCompatibilityMapping() {
        throw new RuntimeException();
    }

    @Export("stringByFoldingWithOptions:locale:")
    public String stringByFoldingWithOptionslocale(NSStringCompareOptions options, NSLocale locale) {
        throw new RuntimeException();
    }

    @Export("stringByReplacingOccurrencesOfString:withString:options:range:")
    public String stringByReplacingOccurrencesOfStringwithStringoptionsrange(String target, String replacement, NSStringCompareOptions options, NSRange searchRange) {
        throw new RuntimeException();
    }

    @Export("stringByReplacingOccurrencesOfString:withString:")
    public String stringByReplacingOccurrencesOfStringwithString(String target, String replacement) {
        throw new RuntimeException();
    }

    @Export("stringByReplacingCharactersInRange:withString:")
    public String stringByReplacingCharactersInRangewithString(NSRange range, String replacement) {
        throw new RuntimeException();
    }

    @Export("defaultCStringEncoding")
    public NSStringEncoding defaultCStringEncoding() {
        throw new RuntimeException();
    }

    @Export("availableStringEncodings")
    public static NSStringEncoding availableStringEncodings() {
        throw new RuntimeException();
    }

    @Export("localizedNameOfStringEncoding:")
    public static String localizedNameOfStringEncoding(NSStringEncoding encoding) {
        throw new RuntimeException();
    }

    @Export("init")
    public NSString() {
        throw new RuntimeException();
    }

    @Export("initWithCharactersNoCopy:length:freeWhenDone:")
    public NSString(char characters, int length, boolean freeBuffer) {
        throw new RuntimeException();
    }

    @Export("initWithString:")
    public NSString(String aString) {
        throw new RuntimeException();
    }

    @Export("initWithFormat:locale:")
    public NSString(String format, NSObject locale) {
        throw new RuntimeException();
    }

    @Export("initWithData:encoding:")
    public NSString(NSData data, NSStringEncoding encoding) {
        throw new RuntimeException();
    }

    @Export("string")
    public static NSObject string() {
        throw new RuntimeException();
    }

    @Export("stringWithString:")
    public static NSObject stringWithString(String string) {
        throw new RuntimeException();
    }

    @Export("stringWithFormat:")
    public static NSObject stringWithFormat(String format) {
        throw new RuntimeException();
    }

    @Export("localizedStringWithFormat:")
    public static NSObject localizedStringWithFormat(String format) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfFile:encoding:error:")
    public NSObject initWithContentsOfFileencodingerror(String path, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("stringWithContentsOfURL:encoding:error:")
    public static NSObject stringWithContentsOfURLencodingerror(NSUrl url, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("stringWithContentsOfFile:encoding:error:")
    public static NSObject stringWithContentsOfFileencodingerror(String path, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfURL:usedEncoding:error:")
    public NSObject initWithContentsOfURL(NSUrl url, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfFile:usedEncoding:error:")
    public NSObject initWithContentsOfFileusedEncodingerror(String path, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("stringWithContentsOfURL:usedEncoding:error:")
    public static NSObject stringWithContentsOfURLusedEncodingerror(NSUrl url, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("stringWithContentsOfFile:usedEncoding:error:")
    public static NSObject stringWithContentsOfFileusedEncodingerror(String path, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("writeToURL:atomically:encoding:error:")
    public boolean writeToURLatomicallyencodingerror(NSUrl url, boolean useAuxiliaryFile, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }

    @Export("writeToFile:atomically:encoding:error:")
    public boolean writeToFileatomicallyencodingerror(String path, boolean useAuxiliaryFile, NSStringEncoding enc, NSError error) {
        throw new RuntimeException();
    }


    @Export("propertyList")
    public NSObject propertyList() {
        throw new RuntimeException();
    }

    @Export("propertyListFromStringsFileFormat")
    public NSDictionary propertyListFromStringsFileFormat() {
        throw new RuntimeException();
    }


    @Export("sizeWithFont:")
    public CGSize sizeWithFont(UIFont font) {
        throw new RuntimeException();
    }

    @Export("sizeWithFont:forWidth:lineBreakMode:")
    public CGSize sizeWithFontforWidthlineBreakMode(UIFont font, float width, NSLineBreakMode lineBreakMode) {
        throw new RuntimeException();
    }

    @Export("drawAtPoint:withFont:")
    public CGSize drawAtPointwithFont(CGPoint point, UIFont font) {
        throw new RuntimeException();
    }

    @Export("drawAtPoint:forWidth:withFont:lineBreakMode:")
    public CGSize drawAtPointforWidthwithFontlineBreakMode(CGPoint point, float width, UIFont font, NSLineBreakMode lineBreakMode) {
        throw new RuntimeException();
    }

    @Export("sizeWithFont:constrainedToSize:")
    public CGSize sizeWithFontconstrainedToSize(UIFont font, CGSize size) {
        throw new RuntimeException();
    }

    @Export("sizeWithFont:constrainedToSize:lineBreakMode:")
    public CGSize sizeWithFontconstrainedToSizelineBreakMode(UIFont font, CGSize size, NSLineBreakMode lineBreakMode) {
        throw new RuntimeException();
    }

    @Export("drawInRect:withFont:")
    public CGSize drawInRectwithFont(CGRect rect, UIFont font) {
        throw new RuntimeException();
    }

    @Export("drawInRect:withFont:lineBreakMode:")
    public CGSize drawInRectwithFontlineBreakMode(CGRect rect, UIFont font, NSLineBreakMode lineBreakMode) {
        throw new RuntimeException();
    }

    @Export("drawInRect:withFont:lineBreakMode:alignment:")
    public CGSize drawInRectwithFontlineBreakModealignment(CGRect rect, UIFont font, NSLineBreakMode lineBreakMode, int alignment) {
        throw new RuntimeException();
    }

    @Export("sizeWithFont:minFontSize:actualFontSize:forWidth:lineBreakMode:")
    public CGSize sizeWithFontminFontSizeactualFontSizeforWidthlineBreakMode(UIFont font, float minFontSize, float actualFontSize, float width, NSLineBreakMode lineBreakMode) {
        throw new RuntimeException();
    }

    @Export("drawAtPoint:forWidth:withFont:fontSize:lineBreakMode:baselineAdjustment:")
    public CGSize drawAtPointforWidthwithFontfontSizelineBreakModebaselineAdjustment(CGPoint point, float width, UIFont font, float fontSize, NSLineBreakMode lineBreakMode, UIBaselineAdjustment baselineAdjustment) {
        throw new RuntimeException();
    }

    @Export("drawAtPoint:forWidth:withFont:minFontSize:actualFontSize:lineBreakMode:baselineAdjustment:")
    public CGSize drawAtPointforWidthwithFontminFontSizeactualFontSizelineBreakModebaselineAdjustment(CGPoint point, float width, UIFont font, float minFontSize, float actualFontSize, NSLineBreakMode lineBreakMode, UIBaselineAdjustment baselineAdjustment) {
        throw new RuntimeException();
    }

}