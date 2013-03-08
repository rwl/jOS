package jos.api.coreimage;

import jos.api.corevideo.CVImageBufferRef;
import jos.api.corevideo.CVPixelBufferRef;
import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSData;
import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSUrl;
import jos.api.graphicsimaging.CGAffineTransform;
import jos.api.graphicsimaging.CGColorSpaceRef;
import jos.api.graphicsimaging.CGImageRef;
import jos.api.graphicsimaging.CGLayerRef;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCoding.class, NSCopying.class})
@Register(isWrapper = true)
public class CIImage extends NSObject {

    @Export("imageWithCGImage:")
    public static CIImage fromCGImage(CGImageRef image) {
        throw new RuntimeException();
    }

    @Export("imageWithCGImage:options:")
    public static CIImage imageWithCGImageoptions(CGImageRef image, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("imageWithCGLayer:")
    public CIImage imageWithCGLayer(CGLayerRef layer) {
        throw new RuntimeException();
    }

    @Export("imageWithCGLayer:options:")
    public static CIImage imageWithCGLayer(CGLayerRef layer, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("imageWithBitmapData:bytesPerRow:size:format:colorSpace:")
    public CIImage imageWithBitmapDatabytesPerRowsizeformatcolorSpace(NSData d, int bpr, CGSize size, int f, CGColorSpaceRef cs) {
        throw new RuntimeException();
    }

    @Export("imageWithTexture:size:flipped:colorSpace:")
    public CIImage imageWithTexturesizeflippedcolorSpace(int name, CGSize size, boolean flag, CGColorSpaceRef cs) {
        throw new RuntimeException();
    }

    @Export("imageWithContentsOfURL:")
    public static CIImage imageWithContentsOfURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("imageWithContentsOfURL:options:")
    public static CIImage imageWithContentsOfURLoptions(NSUrl url, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("imageWithData:")
    public static CIImage imageWithData(NSData data) {
        throw new RuntimeException();
    }

    @Export("imageWithData:options:")
    public static CIImage imageWithDataoptions(NSData data, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("imageWithCVImageBuffer:")
    public CIImage imageWithCVImageBuffer(CVImageBufferRef imageBuffer) {
        throw new RuntimeException();
    }

    @Export("imageWithCVImageBuffer:options:")
    public static CIImage imageWithCVImageBufferoptions(CVImageBufferRef imageBuffer, NSDictionary dict) {
        throw new RuntimeException();
    }

    @Export("imageWithCVPixelBuffer:")
    public CIImage imageWithCVPixelBuffer(CVPixelBufferRef buffer) {
        throw new RuntimeException();
    }

    @Export("imageWithCVPixelBuffer:options:")
    public static CIImage imageWithCVPixelBufferoptions(CVPixelBufferRef buffer, NSDictionary dict) {
        throw new RuntimeException();
    }

    /*@Export("imageWithIOSurface:")
    public CIImage imageWithIOSurface(IOSurfaceRef surface) {
        throw new RuntimeException();
    }

    @Export("imageWithIOSurface:options:")
    public static CIImage imageWithIOSurfaceoptions(IOSurfaceRef surface, NSDictionary d) {
        throw new RuntimeException();
    }*/

    @Export("imageWithColor:")
    public CIImage imageWithColor(CIColor color) {
        throw new RuntimeException();
    }

    @Export("emptyImage")
    public CIImage emptyImage() {
        throw new RuntimeException();
    }

    @Export("initWithCGImage:")
    public NSObject initWithCGImage(CGImageRef image) {
        throw new RuntimeException();
    }

    @Export("initWithCGImage:options:")
    public NSObject initWithCGImageoptions(CGImageRef image, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("initWithCGLayer:")
    public NSObject initWithCGLayer(CGLayerRef layer) {
        throw new RuntimeException();
    }

    @Export("initWithCGLayer:options:")
    public NSObject initWithCGLayeroptions(CGLayerRef layer, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("initWithData:")
    public NSObject initWithData(NSData data) {
        throw new RuntimeException();
    }

    @Export("initWithData:options:")
    public NSObject initWithDataoptions(NSData data, NSDictionary d) {
        throw new RuntimeException();
    }

    @Export("initWithBitmapData:bytesPerRow:size:format:colorSpace:")
    public NSObject initWithBitmapDatabytesPerRowsizeformatcolorSpace(NSData d, int bpr, CGSize size, int f, CGColorSpaceRef c) {
        throw new RuntimeException();
    }

    @Export("initWithTexture:size:flipped:colorSpace:")
    public NSObject initWithTexturesizeflippedcolorSpace(int name, CGSize size, boolean flag, CGColorSpaceRef cs) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfURL:")
    public NSObject initWithContentsOfURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("initWithContentsOfURL:options:")
    public NSObject initWithContentsOfURLoptions(NSUrl url, NSDictionary d) {
        throw new RuntimeException();
    }

    /*@Export("initWithIOSurface:")
    public NSObject initWithIOSurface(IOSurfaceRef surface) {
        throw new RuntimeException();
    }

    @Export("initWithIOSurface:options:")
    public NSObject initWithIOSurfaceoptions(IOSurfaceRef surface, NSDictionary d) {
        throw new RuntimeException();
    }*/

    @Export("initWithCVImageBuffer:")
    public NSObject initWithCVImageBuffer(CVImageBufferRef imageBuffer) {
        throw new RuntimeException();
    }

    @Export("initWithCVImageBuffer:options:")
    public NSObject initWithCVImageBufferoptions(CVImageBufferRef imageBuffer, NSDictionary dict) {
        throw new RuntimeException();
    }

    @Export("initWithCVPixelBuffer:")
    public NSObject initWithCVPixelBuffer(CVPixelBufferRef buffer) {
        throw new RuntimeException();
    }

    @Export("initWithCVPixelBuffer:options:")
    public NSObject initWithCVPixelBufferoptions(CVPixelBufferRef buffer, NSDictionary dict) {
        throw new RuntimeException();
    }

    @Export("initWithColor:")
    public NSObject initWithColor(CIColor color) {
        throw new RuntimeException();
    }

    @Export("imageByApplyingTransform:")
    public CIImage imageByApplyingTransform(CGAffineTransform matrix) {
        throw new RuntimeException();
    }

    @Export("imageByCroppingToRect:")
    public CIImage imageByCroppingToRect(CGRect r) {
        throw new RuntimeException();
    }

    @Export("extent")
    public CGRect extent() {
        throw new RuntimeException();
    }

    @Export("properties")
    public NSDictionary properties() {
        throw new RuntimeException();
    }

    /*@Export("definition")
    public CIFilterShape definition() {
        throw new RuntimeException();
    }*/

    @Export("url")
    public NSUrl url() {
        throw new RuntimeException();
    }

    @Export("colorSpace")
    public CGColorSpaceRef colorSpace() {
        throw new RuntimeException();
    }

    @Export("autoAdjustmentFilters")
    public NSArray autoAdjustmentFilters() {
        throw new RuntimeException();
    }

    @Export("autoAdjustmentFiltersWithOptions:")
    public NSArray autoAdjustmentFiltersWithOptions(NSDictionary dict) {
        throw new RuntimeException();
    }

}