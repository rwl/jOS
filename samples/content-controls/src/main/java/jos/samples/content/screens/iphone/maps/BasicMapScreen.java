package jos.samples.content.screens.iphone.maps;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UISegmentedControl;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

public class BasicMapScreen extends UIViewController {

    @Outlet
    MKMapView mapMain;

    @Outlet
    UISegmentedControl sgmtMapType;

    public BasicMapScreen() {
        super("BasicMapScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        setTitle("Map of Paris!");

        // create our location and zoom for paris
        CLLocationCoordinate2D coords = new CLLocationCoordinate2D(48.857, 2.351);
        MKCoordinateSpan span = new MKCoordinateSpan(milesToLatitudeDegrees(20), milesToLongitudeDegrees(20, coords.Latitude));

        // set the coords and zoom on the map
        mapMain.setRegion(new MKCoordinateRegion(coords, span));

        // to animate to a location, then call SetRegion:
        //mapMain.setRegion(coords, true);

        // to show the device location:
        //mapMain.showsUserLocation(true);

        // change the map type based on what's selected in the segment control
        sgmtMapType.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                switch(sgmtMapType.getSelectedSegment()) {

                    case 0:
                        mapMain.setMapType(MKMapType.STANDARD);
                        break;
                    case 1:
                        mapMain.setMapType(MKMapType.SATELLITE);
                        break;
                    case 2:
                        mapMain.setMapType(MKMapType.HYBRID);
                        break;
                }
            }
        }, UIControlEvent.VALUE_CHANGED);
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
