package jos.api.corelocation;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class CLLocationCoordinate2D {
    double latitude;
    double longitude;
}
