package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSObject {

    @Export("init")
    public NSObject() {
    }

    public void invokeOnMainThread(NSAction delegate) {
    }

}
