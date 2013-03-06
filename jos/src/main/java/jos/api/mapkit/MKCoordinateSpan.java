package jos.api.mapkit;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class MKCoordinateSpan {
    double latitudeDelta;
    double longitudeDelta;
}
