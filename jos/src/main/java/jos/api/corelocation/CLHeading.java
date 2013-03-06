package jos.api.corelocation;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSCopying;
import jos.api.foundation.NSDate;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSCoding.class})
@Register(isWrapper = true)
public class CLHeading extends NSObject {

    @Export("magneticHeading")
    public double magneticHeading() {
        throw new RuntimeException();
    }

    @Export("trueHeading")
    public double trueHeading() {
        throw new RuntimeException();
    }

    @Export("headingAccuracy")
    public double headingAccuracy() {
        throw new RuntimeException();
    }

    @Export("x")
    public double x() {
        throw new RuntimeException();
    }

    @Export("y")
    public double y() {
        throw new RuntimeException();
    }

    @Export("z")
    public double z() {
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

}
