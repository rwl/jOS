package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSDataSearchOptions {

    @Bind("NSDataSearchBackwards")
    public static final int Backwards = 1 << 0;

    @Bind("NSDataSearchAnchored")
    public static final int Anchored = 1 << 1;

}
