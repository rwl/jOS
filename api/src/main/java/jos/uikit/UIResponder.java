package jos.uikit;

import jos.api.Export;
import jos.api.Register;
import jos.foundation.NSObject;

@Register(isWrapper = true)
public class UIResponder extends NSObject {
    
    @Export(selector = "init")
    public UIResponder() {
    }
}
