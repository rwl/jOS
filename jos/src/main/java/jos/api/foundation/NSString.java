package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSString {

    @Export("stringByAddingPercentEscapesUsingEncoding:")
    public String stringByAddingPercentEscapesUsingEncoding(NSStringEncoding enc) {
        throw new RuntimeException();
    }

    @Export("stringByReplacingPercentEscapesUsingEncoding:")
    public String stringByReplacingPercentEscapesUsingEncoding(NSStringEncoding enc) {
        throw new RuntimeException();
    }

}
