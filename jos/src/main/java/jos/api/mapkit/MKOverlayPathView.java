package jos.api.mapkit;

import jos.api.foundation.NSArray;
import jos.api.graphicsimaging.CGContextRef;
import jos.api.graphicsimaging.CGPathRef;
import jos.api.uikit.UIColor;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKOverlayPathView extends MKOverlayView {

    @Export("initWithOverlay:")
    public MKOverlayPathView(MKOverlay overlay) {
        super(overlay);
    }

    @Export("fillColor")
    public UIColor getFillColor() {
        throw new RuntimeException();
    }

    @Export("setFillColor:")
    public void setFillColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("strokeColor")
    public UIColor getStrokeColor() {
        throw new RuntimeException();
    }

    @Export("setStrokeColor:")
    public void setStrokeColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("lineDashPattern")
    public NSArray getLineDashPattern() {
        throw new RuntimeException();
    }

    @Export("setLineDashPattern:")
    public void setLineDashPattern(NSArray value) {
        throw new RuntimeException();
    }

    @Export("createPath")
    public void createPath() {
        throw new RuntimeException();
    }

    @Export("invalidatePath")
    public void invalidatePath() {
        throw new RuntimeException();
    }

    @Export("applyStrokePropertiesToContext:atZoomScale:")
    public void applyStrokePropertiesToContextatZoomScale(CGContextRef context, float zoomScale) {
        throw new RuntimeException();
    }

    @Export("applyFillPropertiesToContext:atZoomScale:")
    public void applyFillPropertiesToContextatZoomScale(CGContextRef context, float zoomScale) {
        throw new RuntimeException();
    }

    @Export("strokePath:inContext:")
    public void strokePathinContext(CGPathRef path, CGContextRef context) {
        throw new RuntimeException();
    }

    @Export("fillPath:inContext:")
    public void fillPathinContext(CGPathRef path, CGContextRef context) {
        throw new RuntimeException();
    }

}

