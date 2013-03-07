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

}
