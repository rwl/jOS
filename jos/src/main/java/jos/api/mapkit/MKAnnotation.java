package jos.api.mapkit;

import jos.api.corelocation.CLLocationCoordinate2D;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Abstract;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class MKAnnotation extends NSObject {

    @Abstract
    @Export("subtitle")
    public String getSubtitle() {
        throw new RuntimeException();
    }

    @Export("coordinate")
    public CLLocationCoordinate2D coordinate() {
        throw new RuntimeException();
    }

    @Export("title")
    public NSString title() {
        throw new RuntimeException();
    }

    @Export("setCoordinate:")
    public void setCoordinate(CLLocationCoordinate2D newCoordinate) {
        throw new RuntimeException();
    }

}

