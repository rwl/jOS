package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSSet;

@Register(isWrapper = true)
public class UIResponder extends NSObject {

    @Export("init")
    public UIResponder() {
    }

    @Export("touchesBegan:withEvent:")
    public void touchesBegan(NSSet touches, UIEvent evt) {
    }

}
