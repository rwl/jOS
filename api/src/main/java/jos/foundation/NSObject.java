package jos.foundation;

import jos.api.Export;
import jos.api.Register;

@Register(isWrapper = true)
public class NSObject {

    @Export(selector = "init")
    public NSObject() {        
    }
}
