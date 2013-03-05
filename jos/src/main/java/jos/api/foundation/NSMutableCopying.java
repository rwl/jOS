package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class NSMutableCopying extends NSObject {
    @Export("mutableCopyWithZone:")
    public NSObject mutableCopyWithZone(NSZone zone) {
        throw new RuntimeException();
    }

}