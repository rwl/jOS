package jos.api.quartz;

import jos.api.foundation.NSDictionary;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class CAAction extends NSObject {

    @Export("runActionForKey:object:arguments:")
    public void runActionForKey(NSString str, NSObject anObject, NSDictionary dict) {
        throw new RuntimeException();
    }

}