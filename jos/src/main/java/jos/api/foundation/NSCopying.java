package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class NSCopying extends NSObject {
    @Export("copyWithZone:")
    public NSObject copyWithZone(NSZone zone) {
        throw new RuntimeException();
    }

}