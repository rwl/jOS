package jos.api.mapkit;

import com.google.j2objc.annotations.Bind;

public enum MKMapType {
    @Bind("MKMapTypeStandard") STANDARD,
    @Bind("MKMapTypeSatellite") SATELLITE,
    @Bind("MKMapTypeHybrid") HYBRID;
}
