package jos.samples.content.screens.iphone.maps;

import com.google.j2objc.annotations.Outlet;

import jos.api.uikit.UIViewController;

public class MapWithOverlayScreen extends UIViewController {

    @Outlet
    MKMapView mapMain;

    MKCircle _circleOverlay = null;
    MKCircleView _circleView = null;

    public MapWithOverlayScreen() {
        super("MapWithOverlayScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        setTitle("Pyramids of Giza");

        // create our location and zoom for the pyramids.
        CLLocationCoordinate2D coords = new CLLocationCoordinate2D(29.976111, 31.132778);
        MKCoordinateSpan span = new MKCoordinateSpan(milesToLatitudeDegrees(.75), milesToLongitudeDegrees(.75, coords.latitude));

        // set the coords and zoom on the map
        mapMain.setRegion(new MKCoordinateRegion(coords, span));

        // show the sat view.
        mapMain.setMapType(MKMapType.SATELLITE);

        // add an overlay with the coords
        _circleOverlay = MKCircle.circle(coords, 200);
        mapMain.addOverlay(_circleOverlay);

        // set our delegate.
        mapMain.setDelegate(new MapDelegate());

        //-- OR --
        //- override the getVIewForOverlay directly, in which case we don't need a delegate
//        mapMain.getViewForOverlay += (m, o) => {
//            if(this._circleView == null)
//            {
//                this._circleView = new MKCircleView(this._circleOverlay);
//                this._circleView.FillColor = UIColor.Blue;
//                this._circleView.Alpha = 0.5f;
//            }
//            return this._circleView;
//        };
    }

    /**
     * The map delegate is much like the table delegate.
     */
    protected static class MapDelegate extends MKMapViewDelegate
    {
        protected MKCircle _circle = null;
        protected MKCircleView _circleView = null;

        public MapDelegate(MKCircle circle, MKCircleView circleView)
        {
            this._circle = circle;
            this._circleView = circleView;
        }

        @Override
        public MKOverlayView GetViewForOverlay(MKMapView mapView, NSObject overlay)
        {
            if ((_circle != null) && (_circleView == null))
            {
                _circleView = new MKCircleView(_circle);
                _circleView.setFillColor(UIColor.BLUE);
                _circleView.setAlpha(0.5f);
            }
            return _circleView;
        }

    }

    /**
     * Converts miles to latitude degrees
     */
    public double milesToLatitudeDegrees(double miles)
    {
        double earthRadius = 3960.0;
        double radiansToDegrees = 180.0/Math.PI;
        return (miles/earthRadius) * radiansToDegrees;
    }

    /**
     * Converts miles to longitudinal degrees at a specified latitude
     */
    public double milesToLongitudeDegrees(double miles, double atLatitude)
    {
        double earthRadius = 3960.0;
        double degreesToRadians = Math.PI/180.0;
        double radiansToDegrees = 180.0/Math.PI;

        // derive the earth's radius at that point in latitude
        double radiusAtLatitude = earthRadius * Math.cos(atLatitude * degreesToRadians);
        return (miles / radiusAtLatitude) * radiansToDegrees;
    }

}
