package jos.api.mapkit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSError;
import jos.api.foundation.NSObject;
import jos.api.uikit.UIControl;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class MKMapViewDelegate extends NSObject {

    @Export("mapView:regionWillChangeAnimated:")
    public void regionWillChange(MKMapView mapView, boolean animated) {
        throw new RuntimeException();
    }

    @Export("mapView:regionDidChangeAnimated:")
    public void regionChanged(MKMapView mapView, boolean animated) {
        throw new RuntimeException();
    }

    @Export("mapViewWillStartLoadingMap:")
    public void willStartLoadingMap(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapViewDidFinishLoadingMap:")
    public void didFinishLoadingMap(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapViewDidFailLoadingMap:withError:")
    public void didFailLoadingMapwithError(MKMapView mapView, NSError error) {
        throw new RuntimeException();
    }


    @Export("mapView:viewForAnnotation:")
    public MKAnnotationView getViewForAnnotation(MKMapView mapView, MKAnnotation annotation) {
        throw new RuntimeException();
    }

    @Export("mapView:viewForAnnotation:")
    public MKAnnotationView getViewForAnnotation(MKAnnotation annotation) {
        throw new RuntimeException();
    }

    @Export("mapView:didAddAnnotationViews:")
    public void didAddAnnotationViews(MKMapView mapView, NSArray views) {
        throw new RuntimeException();
    }

    @Export("mapView:annotationView:calloutAccessoryControlTapped:")
    public void annotationViewCalloutAccessoryControlTapped(MKMapView mapView, MKAnnotationView view, UIControl control) {
        throw new RuntimeException();
    }

    @Export("mapView:didSelectAnnotationView:")
    public void didSelectAnnotationView(MKMapView mapView, MKAnnotationView view) {
        throw new RuntimeException();
    }

    @Export("mapView:didDeselectAnnotationView:")
    public void didDeselectAnnotationView(MKMapView mapView, MKAnnotationView view) {
        throw new RuntimeException();
    }

    @Export("mapViewWillStartLocatingUser:")
    public void willStartLocatingUser(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapViewDidStopLocatingUser:")
    public void didStopLocatingUser(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapView:didUpdateUserLocation:")
    public void didUpdateUserLocation(MKMapView mapView, MKUserLocation userLocation) {
        throw new RuntimeException();
    }

    @Export("mapView:didFailToLocateUserWithError:")
    public void didFailToLocateUser(MKMapView mapView, NSError error) {
        throw new RuntimeException();
    }

    @Export("mapView:annotationView:didChangeDragState:fromOldState:")
    public void annotationViewDidChangeDragState(MKMapView mapView, MKAnnotationView view, MKAnnotationViewDragState newState, MKAnnotationViewDragState oldState) {
        throw new RuntimeException();
    }

    @Export("mapView:viewForOverlay:")
    public MKOverlayView getViewForOverlay(MKMapView mapView, MKOverlay overlay) {
        throw new RuntimeException();
    }

    @Export("mapView:didAddOverlayViews:")
    public void didAddOverlayViews(MKMapView mapView, NSArray overlayViews) {
        throw new RuntimeException();
    }

    @Export("mapView:didChangeUserTrackingMode:animated:")
    public void didChangeUserTrackingMode(MKMapView mapView, MKUserTrackingMode mode, boolean animated) {
        throw new RuntimeException();
    }

}