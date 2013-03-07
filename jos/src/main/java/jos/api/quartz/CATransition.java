package jos.api.quartz;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CATransition extends CAAnimation {

    @Export("type")
    public NSString type() {
        throw new RuntimeException();
    }

    @Export("subtype")
    public NSString subtype() {
        throw new RuntimeException();
    }

    @Export("filter")
    public NSObject filter() {
        throw new RuntimeException();
    }

}