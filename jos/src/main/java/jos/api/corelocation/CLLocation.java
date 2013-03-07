package jos.api.corelocation;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSDate;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;


@BaseType({NSCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class CLLocation extends NSObject {

    @Function
    @Export("CLLocationCoordinate2DMake")
    public static CLLocationCoordinate2D makeLocationCoordinate2D(double latitude,
            double longitude) {
        throw new RuntimeException();
    }

    @Export("initWithLatitude:longitude:")
    public NSObject initWithLatitudelongitude(double latitude, double longitude) {
        throw new RuntimeException();
    }

    @Export("initWithCoordinate:altitude:horizontalAccuracy:verticalAccuracy:timestamp:")
    public NSObject initWithCoordinatealtitudehorizontalAccuracyverticalAccuracytimestamp(CLLocationCoordinate2D coordinate, double altitude, double hAccuracy, double vAccuracy, NSDate timestamp) {
        throw new RuntimeException();
    }

    @Export("initWithCoordinate:altitude:horizontalAccuracy:verticalAccuracy:course:speed:timestamp:")
    public NSObject initWithCoordinatealtitudehorizontalAccuracyverticalAccuracycoursespeedtimestamp(CLLocationCoordinate2D coordinate, double altitude, double hAccuracy, double vAccuracy, double course, double speed, NSDate timestamp) {
        throw new RuntimeException();
    }

    @Export("CLLocationCoordinate2Dcoordinate")
    public CLLocationCoordinate2D coordinate() {
        throw new RuntimeException();
    }

    @Export("altitude")
    public double altitude() {
        throw new RuntimeException();
    }

    @Export("horizontalAccuracy")
    public double horizontalAccuracy() {
        throw new RuntimeException();
    }

    @Export("verticalAccuracy")
    public double verticalAccuracy() {
        throw new RuntimeException();
    }

    @Export("course")
    public double course() {
        throw new RuntimeException();
    }

    @Export("speed")
    public double speed() {
        throw new RuntimeException();
    }

    @Export("timestamp")
    public NSDate timestamp() {
        throw new RuntimeException();
    }

    @Export("description")
    public String description() {
        throw new RuntimeException();
    }

    @Export("getDistanceFrom:")
    public double getDistanceFrom(CLLocation location) {
        throw new RuntimeException();
    }

    @Export("distanceFromLocation:")
    public double distanceFromLocation(CLLocation location) {
        throw new RuntimeException();
    }

}

