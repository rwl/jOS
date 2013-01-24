package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class NSObject {

    @Export(selector = "init")
    public NSObject() {
    }

    public NSObject getNativeField(String string) {
        return null;
    }

    public void setNativeField(String name, NSObject object) {
    }
}
