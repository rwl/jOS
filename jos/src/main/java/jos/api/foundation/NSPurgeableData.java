package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Register;

@BaseType({NSMutableData.class, NSDiscardableContent.class})
@Register(isWrapper = true)
public class NSPurgeableData {
}