package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCopying.class)
@Register(isWrapper = true)
public class UIFont extends NSObject {

    @Export("fontWithName:size:")
    public static UIFont fromName(String string, int i) {
        return null;
    }

    @Export("boldSystemFontOfSize:")
    public static UIFont boldSystemFontOfSize(int size) {
        return null;
    }

    @Export("buttonFontSize")
    public static float buttonFontSize() {
        throw new RuntimeException();
    }

    @Export("systemFontSize")
    public static float systemFontSize() {
        throw new RuntimeException();
    }

    @Export("labelFontSize")
    public static float labelFontSize() {
        throw new RuntimeException();
    }

    @Export("smallSystemFontSize")
    public static float smallSystemFontSize() {
        throw new RuntimeException();
    }


    @Export("fontName")
    public String getFontName() {
        throw new RuntimeException();
    }

    @Export("pointSize")
    public float getPointSize() {
        throw new RuntimeException();
    }

    @Export("ascender")
    public float getAscender() {
        throw new RuntimeException();
    }

    @Export("descender")
    public float getDescender() {
        throw new RuntimeException();
    }

    @Export("capHeight")
    public float getCapHeight() {
        throw new RuntimeException();
    }

    @Export("xHeight")
    public float getXHeight() {
        throw new RuntimeException();
    }

    @Export("lineHeight")
    public float getLineHeight() {
        throw new RuntimeException();
    }

    @Export("fontWithName:size:")
    public static UIFont fontWithNamesize(String fontName, float fontSize) {
        throw new RuntimeException();
    }

    @Export("familyNames")
    public NSArray familyNames() {
        throw new RuntimeException();
    }

    @Export("fontNamesForFamilyName:")
    public NSArray fontNamesForFamilyName(String familyName) {
        throw new RuntimeException();
    }

    @Export("systemFontOfSize:")
    public UIFont systemFontOfSize(float fontSize) {
        throw new RuntimeException();
    }

    @Export("boldSystemFontOfSize:")
    public static UIFont boldSystemFontOfSize(float fontSize) {
        throw new RuntimeException();
    }

    @Export("italicSystemFontOfSize:")
    public static UIFont italicSystemFontOfSize(float fontSize) {
        throw new RuntimeException();
    }

    @Export("familyName")
    public NSString getFamilyName() {
        throw new RuntimeException();
    }

    @Export("fontWithSize:")
    public UIFont fontWithSize(float fontSize) {
        throw new RuntimeException();
    }
}
