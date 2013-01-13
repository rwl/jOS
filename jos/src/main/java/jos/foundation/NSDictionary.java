package jos.foundation;

import jos.api.Export;
import jos.api.Register;

@Register(isWrapper = true)
public class NSDictionary extends NSObject {

    @Export(selector = "init")
    public NSDictionary() {
    }
}
