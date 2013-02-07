package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSDictionary extends NSObject {

    @Export("init")
    public NSDictionary() {
    }

}
