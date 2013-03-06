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
    public void mapViewregionWillChangeAnimated(MKMapView mapView, boolean animated) {
        throw new RuntimeException();
    }

    @Export("mapView:regionDidChangeAnimated:")
    public void mapViewregionDidChangeAnimated(MKMapView mapView, boolean animated) {
        throw new RuntimeException();
    }

    @Export("mapViewWillStartLoadingMap:")
    public void mapViewWillStartLoadingMap(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapViewDidFinishLoadingMap:")
    public void mapViewDidFinishLoadingMap(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapViewDidFailLoadingMap:withError:")
    public void mapViewDidFailLoadingMapwithError(MKMapView mapView, NSError error) {
        throw new RuntimeException();
    }

    @Export("mapView:viewForAnnotation:")
    public MKAnnotationView mapViewviewForAnnotation(MKAnnotation annotation) {
        throw new RuntimeException();
    }

    @Export("mapView:didAddAnnotationViews:")
    public void mapViewdidAddAnnotationViews(MKMapView mapView, NSArray views) {
        throw new RuntimeException();
    }

    @Export("mapView:annotationView:calloutAccessoryControlTapped:")
    public void mapViewannotationViewcalloutAccessoryControlTapped(MKMapView mapView, MKAnnotationView view, UIControl control) {
        throw new RuntimeException();
    }

    @Export("mapView:didSelectAnnotationView:")
    public void mapViewdidSelectAnnotationView(MKMapView mapView, MKAnnotationView view) {
        throw new RuntimeException();
    }

    @Export("mapView:didDeselectAnnotationView:")
    public void mapViewdidDeselectAnnotationView(MKMapView mapView, MKAnnotationView view) {
        throw new RuntimeException();
    }

    @Export("mapViewWillStartLocatingUser:")
    public void mapViewWillStartLocatingUser(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapViewDidStopLocatingUser:")
    public void mapViewDidStopLocatingUser(MKMapView mapView) {
        throw new RuntimeException();
    }

    @Export("mapView:didUpdateUserLocation:")
    public void mapViewdidUpdateUserLocation(MKMapView mapView, MKUserLocation userLocation) {
        throw new RuntimeException();
    }

    @Export("mapView:didFailToLocateUserWithError:")
    public void mapViewdidFailToLocateUserWithError(MKMapView mapView, NSError error) {
        throw new RuntimeException();
    }

    @Export("mapView:annotationView:didChangeDragState:fromOldState:")
    public void mapViewannotationViewdidChangeDragStatefromOldState(MKMapView mapView, MKAnnotationView view, MKAnnotationViewDragState newState, MKAnnotationViewDragState oldState) {
        throw new RuntimeException();
    }

    @Export("mapView:viewForOverlay:")
    public MKOverlayView mapViewviewForOverlay(MKMapView mapView, MKOverlay overlay) {
        throw new RuntimeException();
    }

    @Export("mapView:didAddOverlayViews:")
    public void mapViewdidAddOverlayViews(MKMapView mapView, NSArray overlayViews) {
        throw new RuntimeException();
    }

    @Export("mapView:didChangeUserTrackingMode:animated:")
    public void mapViewdidChangeUserTrackingModeanimated(MKMapView mapView, MKUserTrackingMode mode, boolean animated) {
        throw new RuntimeException();
    }

}