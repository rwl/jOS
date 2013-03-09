package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Function;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSRange {
    int location;
    int length;

    @Function
    @Export("NSMakeRange")
    public static NSRange makeRange(int loc, int len) {
        throw new RuntimeException();
    }

}
