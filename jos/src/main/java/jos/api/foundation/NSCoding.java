package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class NSCoding extends NSObject {

    @Export("encodeWithCoder:")
    public void encodeWithCoder(NSCoder aCoder) {
        throw new RuntimeException();
    }

    @Export("initWithCoder:")
    public NSObject initWithCoder(NSCoder aDecoder) {
        throw new RuntimeException();
    }

}