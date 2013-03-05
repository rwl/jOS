package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSDataReadingOptions {

    @Bind("NSDataReadingMappedIfSafe")
    public static final int MappedIfSafe = 1 << 0;

    @Bind("NSDataReadingUncached")
    public static final int Uncached = 1 << 1;

    @Bind("NSDataReadingMappedAlways")
    public static final int MappedAlways = 1 << 3;

}
