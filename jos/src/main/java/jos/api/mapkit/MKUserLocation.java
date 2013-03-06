package jos.api.mapkit;

import jos.api.corelocation.CLHeading;
import jos.api.corelocation.CLLocation;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class MKUserLocation extends MKAnnotation {

    @Export("updating")
    public boolean isUpdating() {
        throw new RuntimeException();
    }

    @Export("location")
    public CLLocation location() {
        throw new RuntimeException();
    }

    @Export("heading")
    public CLHeading heading() {
        throw new RuntimeException();
    }

    @Export("title")
    public NSString title() {
        throw new RuntimeException();
    }

    @Export("subtitle")
    public NSString subtitle() {
        throw new RuntimeException();
    }

}
