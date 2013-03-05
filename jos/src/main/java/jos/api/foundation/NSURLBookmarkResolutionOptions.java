package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSURLBookmarkResolutionOptions {

    @Bind("NSURLBookmarkResolutionWithoutUI")
    public static final int WithoutUI = 1 << 8;

    @Bind("NSURLBookmarkResolutionWithoutMounting")
    public static final int WithoutMounting = 1 << 9;

    @Bind("NSURLBookmarkResolutionWithSecurityScope")
    public static final int NSURLBookmarkResolutionWithSecurityScope = 1 << 10;

}
