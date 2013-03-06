package jos.api.mapkit;

import jos.api.corelocation.CLLocationCoordinate2D;
import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSSet;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIEdgeInsets;
import jos.api.uikit.UIView;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class MKMapView extends UIView {

    @Export("delegate")
    public MKMapViewDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(MKMapViewDelegate value) {
        throw new RuntimeException();
    }

    @Bind("isScrollEnabled")
    @Export("scrollEnabled")
    public boolean getScrollEnabled() {
        throw new RuntimeException();
    }

    @Export("setScrollEnabled:")
    public void setScrollEnabled(boolean value) {
        throw new RuntimeException();
    }

    @Export("userTrackingMode")
    public MKUserTrackingMode getUserTrackingMode() {
        throw new RuntimeException();
    }

    @Export("setUserTrackingMode:")
    public void setUserTrackingMode(MKUserTrackingMode value) {
        throw new RuntimeException();
    }

    @Export("annotations")
    public NSArray getAnnotations() {
        throw new RuntimeException();
    }

    @Export("selectedAnnotations")
    public NSArray getSelectedAnnotations() {
        throw new RuntimeException();
    }

    @Export("setSelectedAnnotations:")
    public void setSelectedAnnotations(NSArray value) {
        throw new RuntimeException();
    }

    @Export("mapType")
    public MKMapType mapType() {
        throw new RuntimeException();
    }

    @Export("region")
    public MKCoordinateRegion region() {
        throw new RuntimeException();
    }

    @Export("setRegion:animated:")
    public void setRegionanimated(MKCoordinateRegion region, boolean animated) {
        throw new RuntimeException();
    }

    @Export("centerCoordinate")
    public CLLocationCoordinate2D centerCoordinate() {
        throw new RuntimeException();
    }

    @Export("setCenterCoordinate:animated:")
    public void setCenterCoordinateanimated(CLLocationCoordinate2D coordinate, boolean animated) {
        throw new RuntimeException();
    }

    @Export("regionThatFits:")
    public MKCoordinateRegion regionThatFits(MKCoordinateRegion region) {
        throw new RuntimeException();
    }

    @Export("visibleMapRect")
    public MKMapRect visibleMapRect() {
        throw new RuntimeException();
    }

    @Export("setVisibleMapRect:animated:")
    public void setVisibleMapRectanimated(MKMapRect mapRect, boolean animate) {
        throw new RuntimeException();
    }

    @Export("mapRectThatFits:")
    public MKMapRect mapRectThatFits(MKMapRect mapRect) {
        throw new RuntimeException();
    }

    @Export("setVisibleMapRect:edgePadding:animated:")
    public void setVisibleMapRectedgePaddinganimated(MKMapRect mapRect, UIEdgeInsets insets, boolean animate) {
        throw new RuntimeException();
    }

    @Export("mapRectThatFits:edgePadding:")
    public MKMapRect mapRectThatFitsedgePadding(MKMapRect mapRect, UIEdgeInsets insets) {
        throw new RuntimeException();
    }

    @Export("convertCoordinate:toPointToView:")
    public CGPoint convertCoordinatetoPointToView(CLLocationCoordinate2D coordinate, UIView view) {
        throw new RuntimeException();
    }

    @Export("convertPoint:toCoordinateFromView:")
    public CLLocationCoordinate2D convertPointtoCoordinateFromView(CGPoint point, UIView view) {
        throw new RuntimeException();
    }

    @Export("convertRegion:toRectToView:")
    public CGRect convertRegiontoRectToView(MKCoordinateRegion region, UIView view) {
        throw new RuntimeException();
    }

    @Export("convertRect:toRegionFromView:")
    public MKCoordinateRegion convertRecttoRegionFromView(CGRect rect, UIView view) {
        throw new RuntimeException();
    }

    @Export("zoomEnabled")
    public boolean isZoomEnabled() {
        throw new RuntimeException();
    }

    @Export("showsUserLocation")
    public boolean showsUserLocation() {
        throw new RuntimeException();
    }

    @Export("userLocation")
    public MKUserLocation userLocation() {
        throw new RuntimeException();
    }

    @Export("setUserTrackingMode:animated:")
    public void setUserTrackingModeanimated(MKUserTrackingMode mode, boolean animated) {
        throw new RuntimeException();
    }

    @Export("userLocationVisible")
    public boolean isUserLocationVisible() {
        throw new RuntimeException();
    }

    @Export("addAnnotation:")
    public void addAnnotation(MKAnnotation annotation) {
        throw new RuntimeException();
    }

    @Export("addAnnotations:")
    public void addAnnotations(NSArray annotations) {
        throw new RuntimeException();
    }

    @Export("removeAnnotation:")
    public void removeAnnotation(MKAnnotation annotation) {
        throw new RuntimeException();
    }

    @Export("removeAnnotations:")
    public void removeAnnotations(NSArray annotations) {
        throw new RuntimeException();
    }

    @Export("annotationsInMapRect:")
    public NSSet annotationsInMapRect(MKMapRect mapRect) {
        throw new RuntimeException();
    }

    @Export("viewForAnnotation:")
    public MKAnnotationView viewForAnnotation(MKAnnotation annotation) {
        throw new RuntimeException();
    }

    @Export("dequeueReusableAnnotationViewWithIdentifier:")
    public MKAnnotationView dequeueReusableAnnotationViewWithIdentifier(String identifier) {
        throw new RuntimeException();
    }

    @Export("selectAnnotation:animated:")
    public void selectAnnotationanimated(MKAnnotation annotation, boolean animated) {
        throw new RuntimeException();
    }

    @Export("deselectAnnotation:animated:")
    public void deselectAnnotationanimated(MKAnnotation annotation, boolean animated) {
        throw new RuntimeException();
    }

    @Export("annotationVisibleRect")
    public CGRect annotationVisibleRect() {
        throw new RuntimeException();
    }


    @Export("overlays")
    public NSArray getOverlays() {
        throw new RuntimeException();
    }

    @Export("addOverlay:")
    public void addOverlay(MKOverlay overlay) {
        throw new RuntimeException();
    }

    @Export("addOverlays:")
    public void addOverlays(NSArray overlays) {
        throw new RuntimeException();
    }

    @Export("removeOverlay:")
    public void removeOverlay(MKOverlay overlay) {
        throw new RuntimeException();
    }

    @Export("removeOverlays:")
    public void removeOverlays(NSArray overlays) {
        throw new RuntimeException();
    }

    @Export("insertOverlay:atIndex:")
    public void insertOverlayatIndex(MKOverlay overlay, int index) {
        throw new RuntimeException();
    }

    @Export("exchangeOverlayAtIndex:withOverlayAtIndex:")
    public void exchangeOverlayAtIndexwithOverlayAtIndex(int index1, int index2) {
        throw new RuntimeException();
    }

    @Export("insertOverlay:aboveOverlay:")
    public void insertOverlayaboveOverlay(MKOverlay overlay, MKOverlay sibling) {
        throw new RuntimeException();
    }

    @Export("insertOverlay:belowOverlay:")
    public void insertOverlaybelowOverlay(MKOverlay overlay, MKOverlay sibling) {
        throw new RuntimeException();
    }

    @Export("viewForOverlay:")
    public MKOverlayView viewForOverlay(MKOverlay overlay) {
        throw new RuntimeException();
    }

}