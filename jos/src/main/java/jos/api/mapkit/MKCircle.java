package jos.api.mapkit;

import jos.api.corelocation.CLLocationCoordinate2D;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(MKShape.class)
@Register(isWrapper = true)
public class MKCircle extends MKOverlay {

    @Export("coordinate")
    public CLLocationCoordinate2D getCoordinate() {
        throw new RuntimeException();
    }

    @Export("radius")
    public double getRadius() {
        throw new RuntimeException();
    }

    @Export("boundingMapRect")
    public MKMapRect getBoundingMapRect() {
        throw new RuntimeException();
    }

    @Export("circleWithCenterCoordinate:radius:")
    public static MKCircle circle(CLLocationCoordinate2D coord, double radius) {
        throw new RuntimeException();
    }

    @Export("circleWithMapRect:")
    public static MKCircle circle(MKMapRect mapRect) {
        throw new RuntimeException();
    }

}

