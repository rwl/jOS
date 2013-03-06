package jos.api.uikit;

import jos.api.coreimage.CIColor;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGColorRef;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCoding.class, NSCopying.class})
@Register(isWrapper = true)
public class UIColor extends NSObject {

    @Export("initWithRed:green:blue:alpha:")
    public UIColor(float r, float g, int b, int a) {
    }

    @Bind("lightGrayColor")
    public static UIColor LIGHT_GRAY;

    @Bind("whiteColor")
    public static UIColor WHITE;

    @Bind("blueColor")
    public static UIColor BLUE;

    @Bind("clearColor")
    public static UIColor CLEAR;

    @Bind("lightTextColor")
    public static UIColor LIGHT_TEXT_COLOR;

    @Export("darkTextColor")
    public static UIColor darkTextColor() {
        throw new RuntimeException();
    }

    @Export("groupTableViewBackgroundColor")
    public UIColor groupTableViewBackgroundColor() {
        throw new RuntimeException();
    }

    @Export("viewFlipsideBackgroundColor")
    public static UIColor viewFlipsideBackgroundColor() {
        throw new RuntimeException();
    }

    @Export("scrollViewTexturedBackgroundColor")
    public static UIColor scrollViewTexturedBackgroundColor() {
        throw new RuntimeException();
    }

    @Export("underPageBackgroundColor")
    public static UIColor underPageBackgroundColor() {
        throw new RuntimeException();
    }



    @Export("CIColor")
    public CIColor getCIColor() {
        throw new RuntimeException();
    }

    @Export("colorWithWhite:alpha:")
    public UIColor colorWithWhitealpha(float white, float alpha) {
        throw new RuntimeException();
    }

    @Export("colorWithHue:saturation:brightness:alpha:")
    public static UIColor colorWithHuesaturationbrightnessalpha(float hue, float saturation, float brightness, float alpha) {
        throw new RuntimeException();
    }

    @Export("colorWithRed:green:blue:alpha:")
    public static UIColor colorWithRedgreenbluealpha(float red, float green, float blue, float alpha) {
        throw new RuntimeException();
    }

    @Export("colorWithCGColor:")
    public static UIColor colorWithCGColor(CGColorRef cgColor) {
        throw new RuntimeException();
    }

    @Export("colorWithPatternImage:")
    public static UIColor colorWithPatternImage(UIImage image) {
        throw new RuntimeException();
    }

    @Export("colorWithCIColor:")
    public static UIColor colorWithCIColor(CIColor ciColor) {
        throw new RuntimeException();
    }

    @Export("initWithWhite:alpha:")
    public UIColor initWithWhitealpha(float white, float alpha) {
        throw new RuntimeException();
    }

    @Export("initWithHue:saturation:brightness:alpha:")
    public UIColor initWithHuesaturationbrightnessalpha(float hue, float saturation, float brightness, float alpha) {
        throw new RuntimeException();
    }

    @Export("initWithRed:green:blue:alpha:")
    public UIColor initWithRedgreenbluealpha(float red, float green, float blue, float alpha) {
        throw new RuntimeException();
    }

    @Export("initWithCGColor:")
    public UIColor initWithCGColor(CGColorRef cgColor) {
        throw new RuntimeException();
    }

    @Export("initWithPatternImage:")
    public UIColor initWithPatternImage(UIImage image) {
        throw new RuntimeException();
    }

    @Export("initWithCIColor:")
    public UIColor initWithCIColor(CIColor ciColor) {
        throw new RuntimeException();
    }

    @Export("blackColor")
    public UIColor blackColor() {
        throw new RuntimeException();
    }

    @Export("darkGrayColor")
    public static UIColor darkGrayColor() {
        throw new RuntimeException();
    }

    @Export("lightGrayColor")
    public static UIColor lightGrayColor() {
        throw new RuntimeException();
    }

    @Export("whiteColor")
    public static UIColor whiteColor() {
        throw new RuntimeException();
    }

    @Export("grayColor")
    public static UIColor grayColor() {
        throw new RuntimeException();
    }

    @Export("redColor")
    public static UIColor redColor() {
        throw new RuntimeException();
    }

    @Export("greenColor")
    public static UIColor greenColor() {
        throw new RuntimeException();
    }

    @Export("blueColor")
    public static UIColor blueColor() {
        throw new RuntimeException();
    }

    @Export("cyanColor")
    public static UIColor cyanColor() {
        throw new RuntimeException();
    }

    @Export("yellowColor")
    public static UIColor yellowColor() {
        throw new RuntimeException();
    }

    @Export("magentaColor")
    public static UIColor magentaColor() {
        throw new RuntimeException();
    }

    @Export("orangeColor")
    public static UIColor orangeColor() {
        throw new RuntimeException();
    }

    @Export("purpleColor")
    public static UIColor purpleColor() {
        throw new RuntimeException();
    }

    @Export("brownColor")
    public static UIColor brownColor() {
        throw new RuntimeException();
    }

    @Export("clearColor")
    public static UIColor clearColor() {
        throw new RuntimeException();
    }

    @Export("set")
    public void set() {
        throw new RuntimeException();
    }

    @Export("setFill")
    public void setFill() {
        throw new RuntimeException();
    }

    @Export("setStroke")
    public void setStroke() {
        throw new RuntimeException();
    }

    @Export("getWhite:alpha:")
    public boolean getWhitealpha(float white, float alpha) {
        throw new RuntimeException();
    }

    @Export("getHue:saturation:brightness:alpha:")
    public boolean getHuesaturationbrightnessalpha(float hue, float saturation, float brightness, float alpha) {
        throw new RuntimeException();
    }

    @Export("getRed:green:blue:alpha:")
    public boolean getRedgreenbluealpha(float red, float green, float blue, float alpha) {
        throw new RuntimeException();
    }

    @Export("colorWithAlphaComponent:")
    public UIColor colorWithAlphaComponent(float alpha) {
        throw new RuntimeException();
    }

    @Export("CGColor")
    public CGColorRef CGColor() {
        throw new RuntimeException();
    }

}
