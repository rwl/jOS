package jos.samples.content.screens.iphone.maps;

import com.google.j2objc.annotations.Outlet;

import jos.api.corelocation.CLLocation;
import jos.api.corelocation.CLLocationCoordinate2D;
import jos.api.foundation.NSObject;
import jos.api.mapkit.MKCoordinateSpan;
import jos.api.mapkit.MKGeometry;
import jos.api.mapkit.MKMapType;
import jos.api.mapkit.MKMapView;
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
        CLLocationCoordinate2D coords = CLLocation.makeLocationCoordinate2D(48.857, 2.351);
        MKCoordinateSpan span = MKGeometry.makeCoordinateSpan(Util.milesToLatitudeDegrees(20),
                Util.milesToLongitudeDegrees(20, coords.latitude));

        // set the coords and zoom on the map
        mapMain.setRegion(MKGeometry.makeCoordinateRegion(coords, span));

        // to animate to a location, then call setRegion:
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

}
