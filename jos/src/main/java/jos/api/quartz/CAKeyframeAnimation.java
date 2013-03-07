package jos.api.quartz;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGPath;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CAKeyframeAnimation extends CAPropertyAnimation {

    @Export("values")
    public NSArray values() {
        throw new RuntimeException();
    }

    @Export("keyTimes")
    public NSArray keyTimes() {
        throw new RuntimeException();
    }

    @Export("timingFunctions")
    public NSArray timingFunctions() {
        throw new RuntimeException();
    }

    @Export("calculationMode")
    public NSString calculationMode() {
        throw new RuntimeException();
    }

    @Export("rotationMode")
    public NSString rotationMode() {
        throw new RuntimeException();
    }

    @Export("setPath")
    public void setPath(CGPath path) {
        throw new RuntimeException();
    }

}