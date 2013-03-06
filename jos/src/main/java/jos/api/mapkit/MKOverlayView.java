package jos.api.mapkit;

import jos.api.graphicsimaging.CGContextRef;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIView;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKOverlayView extends UIView {

    @Export("overlay")
    public MKOverlay getOverlay() {
        throw new RuntimeException();
    }

    @Export("initWithOverlay:")
    public MKOverlayView(MKOverlay overlay) {
        throw new RuntimeException();
    }

    @Export("pointForMapPoint:")
    public CGPoint pointForMapPoint(MKMapPoint mapPoint) {
        throw new RuntimeException();
    }

    @Export("mapPointForPoint:")
    public MKMapPoint mapPointForPoint(CGPoint point) {
        throw new RuntimeException();
    }

    @Export("rectForMapRect:")
    public CGRect rectForMapRect(MKMapRect mapRect) {
        throw new RuntimeException();
    }

    @Export("mapRectForRect:")
    public MKMapRect mapRectForRect(CGRect rect) {
        throw new RuntimeException();
    }

    @Export("canDrawMapRect:zoomScale:")
    public boolean canDrawMapRectzoomScale(MKMapRect mapRect, float zoomScale) {
        throw new RuntimeException();
    }

    @Export("drawMapRect:zoomScale:inContext:")
    public void drawMapRectzoomScaleinContext(MKMapRect mapRect, float zoomScale, CGContextRef context) {
        throw new RuntimeException();
    }

    @Export("setNeedsDisplayInMapRect:")
    public void setNeedsDisplayInMapRect(MKMapRect mapRect) {
        throw new RuntimeException();
    }

    @Export("setNeedsDisplayInMapRect:zoomScale:")
    public void setNeedsDisplayInMapRectzoomScale(MKMapRect mapRect, float zoomScale) {
        throw new RuntimeException();
    }

}

