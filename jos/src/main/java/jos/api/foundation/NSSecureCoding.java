package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Model
@Register(isWrapper = true)
public class NSSecureCoding extends NSObject {

    @Export("supportsSecureCoding")
    public boolean supportsSecureCoding() {
        throw new RuntimeException();
    }

}