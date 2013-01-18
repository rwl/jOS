package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UIResponder extends NSObject {

    @Export(selector = "init")
    public UIResponder() {
    }
}
