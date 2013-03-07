package jos.api.mapkit;

import jos.api.corelocation.CLLocationCoordinate2D;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKGeometry {

    @Function
    @Export("MKCoordinateSpanMake")
    public static MKCoordinateSpan makeCoordinateSpan(double latitudeDelta, double longitudeDelta) {
        throw new RuntimeException();
    }

    @Function
    @Export("MKCoordinateRegionMake")
    public static MKCoordinateRegion makeCoordinateRegion(CLLocationCoordinate2D centerCoordinate, MKCoordinateSpan span) {
        throw new RuntimeException();
    }

}
