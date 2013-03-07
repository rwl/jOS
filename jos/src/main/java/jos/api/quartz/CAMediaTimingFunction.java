package jos.api.quartz;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class CAMediaTimingFunction extends NSObject {

    @Export("functionWithName:")
    public static CAMediaTimingFunction fromName(String name) {
        throw new RuntimeException();
    }

    @Export("initWithControlPoints::::")
    public CAMediaTimingFunction(float c1x, float c1y, float c2x, float c2y) {
        throw new RuntimeException();
    }

    @Export("getControlPointAtIndex:values:")
    public void getControlPointAtIndexvalues(int idx, float[] ptr) {
        throw new RuntimeException();
    }

}

