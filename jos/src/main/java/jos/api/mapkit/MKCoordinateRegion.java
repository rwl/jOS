package jos.api.mapkit;

import jos.api.corelocation.CLLocationCoordinate2D;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class MKCoordinateRegion {
    CLLocationCoordinate2D center;
    MKCoordinateSpan span;
}
