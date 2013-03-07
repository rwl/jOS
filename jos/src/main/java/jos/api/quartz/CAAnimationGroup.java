package jos.api.quartz;

import jos.api.foundation.NSArray;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CAAnimationGroup extends CAAnimation {

    @Export("animations")
    public NSArray animations() {
        throw new RuntimeException();
    }

}