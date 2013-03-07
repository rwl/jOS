package jos.api.quartz;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class CAValueFunction extends NSObject {

    @Export("name")
    public String getName() {
        throw new RuntimeException();
    }

    @Export("functionWithName:")
    public static NSObject functionWithName(String name) {
        throw new RuntimeException();
    }

}

