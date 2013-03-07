package jos.api.quartz;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CAAnimation {

    @Export("animation")
    public NSObject animation() {
        throw new RuntimeException();
    }

    @Export("defaultValueForKey:")
    public NSObject defaultValueForKey(String key) {
        throw new RuntimeException();
    }

    @Export("shouldArchiveValueForKey:")
    public boolean shouldArchiveValueForKey(String key) {
        throw new RuntimeException();
    }

    @Export("timingFunction")
    public CAMediaTimingFunction timingFunction() {
        throw new RuntimeException();
    }

    @Export("delegate")
    public NSObject delegate() {
        throw new RuntimeException();
    }

    @Export("isRemovedOnCompletion")
    public boolean removedOnCompletion() {
        throw new RuntimeException();
    }

    @Export("setTimingFunction")
    public void setTimingFunction(CAMediaTimingFunction func) {
        throw new RuntimeException();
    }

}