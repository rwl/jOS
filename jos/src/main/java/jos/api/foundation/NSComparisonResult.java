package jos.api.foundation;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum NSComparisonResult {
    NSOrderedAscending, NSOrderedSame, NSOrderedDescending
}
