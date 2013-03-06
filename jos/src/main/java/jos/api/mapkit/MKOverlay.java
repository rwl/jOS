package jos.api.mapkit;

import jos.api.corelocation.CLLocationCoordinate2D;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@BaseType(MKAnnotation.class)
@Model
@Register(isWrapper = true)
public class MKOverlay extends NSObject {

    @Export("coordinate")
    public CLLocationCoordinate2D coordinate() {
        throw new RuntimeException();
    }

    @Export("boundingMapRect")
    public MKMapRect boundingMapRect() {
        throw new RuntimeException();
    }

    @Export("intersectsMapRect:")
    public boolean intersectsMapRect(MKMapRect mapRect) {
        throw new RuntimeException();
    }

}

