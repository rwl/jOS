package jos.api.coreimage;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGAffineTransform;
import jos.api.graphicsimaging.CGFloat;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class CIVector extends NSObject {

    @Export("vectorWithValues:count:")
    public CIVector vectorWithValuescount(CGFloat values, int count) {
        throw new RuntimeException();
    }

    @Export("vectorWithX:")
    public static CIVector vectorWithX(float x) {
        throw new RuntimeException();
    }

    @Export("vectorWithX:Y:")
    public static CIVector vectorWithXY(float x, float y) {
        throw new RuntimeException();
    }

    @Export("vectorWithX:Y:Z:")
    public static CIVector vectorWithXYZ(float x, float y, float z) {
        throw new RuntimeException();
    }

    @Export("vectorWithX:Y:Z:W:")
    public static CIVector vectorWithXYZW(float x, float y, float z, float w) {
        throw new RuntimeException();
    }

    @Export("vectorWithCGPoint:")
    public CIVector vectorWithCGPoint(CGPoint p) {
        throw new RuntimeException();
    }

    @Export("vectorWithCGRect:")
    public CIVector vectorWithCGRect(CGRect r) {
        throw new RuntimeException();
    }

    @Export("vectorWithCGAffineTransform:")
    public CIVector vectorWithCGAffineTransform(CGAffineTransform t) {
        throw new RuntimeException();
    }

    @Export("vectorWithString:")
    public static CIVector vectorWithString(String representation) {
        throw new RuntimeException();
    }

    @Export("initWithValues:count:")
    public CIVector(CGFloat values, int count) {
        throw new RuntimeException();
    }

    @Export("initWithX:")
    public CIVector(float x) {
        throw new RuntimeException();
    }

    @Export("initWithX:Y:")
    public CIVector(float x, float y) {
        throw new RuntimeException();
    }

    @Export("initWithX:Y:Z:")
    public CIVector(float x, float y, float z) {
        throw new RuntimeException();
    }

    @Export("initWithX:Y:Z:W:")
    public CIVector(float x, float y, float z, float w) {
        throw new RuntimeException();
    }

    @Export("initWithCGPoint:")
    public CIVector(CGPoint p) {
        throw new RuntimeException();
    }

    @Export("initWithCGRect:")
    public CIVector(CGRect r) {
        throw new RuntimeException();
    }

    @Export("initWithCGAffineTransform:")
    public CIVector(CGAffineTransform r) {
        throw new RuntimeException();
    }

    @Export("initWithString:")
    public CIVector(String representation) {
        throw new RuntimeException();
    }

    @Export("valueAtIndex:")
    public float valueAtIndex(int index) {
        throw new RuntimeException();
    }

    @Export("count")
    public int count() {
        throw new RuntimeException();
    }

    @Export("X")
    public float X() {
        throw new RuntimeException();
    }

    @Export("Y")
    public float Y() {
        throw new RuntimeException();
    }

    @Export("Z")
    public float Z() {
        throw new RuntimeException();
    }

    @Export("W")
    public float W() {
        throw new RuntimeException();
    }

    @Export("CGAffineTransformValue")
    public CGAffineTransform CGAffineTransformValue() {
        throw new RuntimeException();
    }

    @Export("stringRepresentation")
    public String stringRepresentation() {
        throw new RuntimeException();
    }

}

