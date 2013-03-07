package jos.api.quartz;

import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class CAPropertyAnimation extends CAAnimation {

    @Export("animationWithKeyPath:")
    public static CAPropertyAnimation fromKeyPath(String path) {
        throw new RuntimeException();
    }

    @Export("keyPath")
    public NSString keyPath() {
        throw new RuntimeException();
    }

    @Export("isAdditive")
    public boolean additive() {
        throw new RuntimeException();
    }

    @Export("isCumulative")
    public boolean cumulative() {
        throw new RuntimeException();
    }

    @Export("valueFunction")
    public CAValueFunction valueFunction() {
        throw new RuntimeException();
    }

}