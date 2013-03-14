package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;

public class CGContext {

    @Function
    @Export("CGContextConcatCTM")
    public static void concatCTM(CGContextRef c, CGAffineTransform transform) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextAddPath")
    public static void addPath(CGContextRef context, CGPath path) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextSetFillColorWithColor")
    public static void setFillColor(CGContextRef c, CGColorRef color) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextSetRGBFillColor")
    public static void setRGBFillColor(CGContextRef context, float red,
            float green, float blue, float alpha) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextSetLineWidth")
    public static void setLineWidth(CGContextRef c, float width) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextStrokePath")
    public static void strokePath(CGContextRef c) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextDrawImage")
    public static void drawImage(CGContextRef c, CGRect rect,
            CGImageRef image) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextSetStrokeColor")
    public static void setStrokeColor(CGContextRef context,
            float... components) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextFillRect")
    public static void fillRect(CGContextRef c, CGRect rect) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextTranslateCTM")
    public static void translateCTM(CGContextRef c, float tx, float ty) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextScaleCTM")
    public static void scaleCTM(CGContextRef c, float sx, float sy) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextAddArc")
    public static void addArc(CGContextRef c, float x, float y,
            float radius, float startAngle, float endAngle, int clockwise) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextMoveToPoint")
    public static void moveTo(CGContextRef c, float x, float y) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextAddLineToPoint")
    public static void addLineToPoint(CGContextRef c, float x, float y) {
        throw new RuntimeException();
    }

    @Function
    @Export("CGContextClip")
    public static void clip(CGContextRef c) {
        throw new RuntimeException();
    }

}
