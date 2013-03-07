package jos.api.quartz;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class CAMediaTiming extends NSObject {

    @Export("fillMode")
    public NSString fillMode() {
        throw new RuntimeException();
    }

}

