package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class NSDiscardableContent extends NSObject {
    @Export("beginContentAccess")
    public boolean beginContentAccess() {
        throw new RuntimeException();
    }

    @Export("endContentAccess")
    public void endContentAccess() {
        throw new RuntimeException();
    }

    @Export("discardContentIfPossible")
    public void discardContentIfPossible() {
        throw new RuntimeException();
    }

    @Export("isContentDiscarded")
    public boolean isContentDiscarded() {
        throw new RuntimeException();
    }

}