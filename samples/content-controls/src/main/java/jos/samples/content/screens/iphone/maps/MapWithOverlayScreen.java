package jos.samples.content.screens.iphone.maps;

import jos.api.corelocation.CLLocation;
import jos.api.corelocation.CLLocationCoordinate2D;
import jos.api.mapkit.MKCircle;
import jos.api.mapkit.MKCircleView;
import jos.api.mapkit.MKCoordinateSpan;
import jos.api.mapkit.MKGeometry;
import jos.api.mapkit.MKMapType;
import jos.api.mapkit.MKMapView;
import jos.api.mapkit.MKMapViewDelegate;
import jos.api.mapkit.MKOverlay;
import jos.api.mapkit.MKOverlayView;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class MapWithOverlayScreen extends UIViewController {

    @Outlet
    MKMapView mapMain;

    MKCircle circleOverlay = null;

    MKCircleView circleView = null;

    public MapWithOverlayScreen() {
        super("MapWithOverlayScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        setTitle("Pyramids of Giza");

        // create our location and zoom for the pyramids.
        CLLocationCoordinate2D coords = CLLocation.makeLocationCoordinate2D(29.976111, 31.132778);
        MKCoordinateSpan span = MKGeometry.makeCoordinateSpan(Util.milesToLatitudeDegrees(.75),
                Util.milesToLongitudeDegrees(.75, coords.latitude));

        // set the coords and zoom on the map
        mapMain.setRegion(MKGeometry.makeCoordinateRegion(coords, span));

        // show the sat view.
        mapMain.setMapType(MKMapType.SATELLITE);

        // add an overlay with the coords
        circleOverlay = MKCircle.circle(coords, 200);
        mapMain.addOverlay(circleOverlay);

        // set our delegate.
        mapMain.setDelegate(new MapDelegate(circleOverlay, circleView));

        //-- OR --
        //- override the getVIewForOverlay directly, in which case we don't need a delegate
        /*mapMain.getViewForOverlay += (m, o) => {
            if(this.circleView == null) {
                this.circleView = new MKCircleView(this.circleOverlay);
                this.circleView.setFillColor(UIColor.BLUE);
                this.circleView.setAlpha(0.5f);
            }
            return this.circleView;
        };*/
    }

    /**
     * The map delegate is much like the table delegate.
     */
    protected static class MapDelegate extends MKMapViewDelegate {

        protected MKCircle _circle = null;

        protected MKCircleView _circleView = null;

        public MapDelegate(MKCircle circle, MKCircleView circleView) {
            this._circle = circle;
            this._circleView = circleView;
        }

        @Override
        public MKOverlayView getViewForOverlay(MKMapView mapView, MKOverlay overlay) {
            if ((_circle != null) && (_circleView == null)) {
                _circleView = new MKCircleView(_circle);
                _circleView.setFillColor(UIColor.BLUE);
                _circleView.setAlpha(0.5f);
            }
            return _circleView;
        }

    }

}
