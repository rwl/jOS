package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSURLBookmarkCreationOptions {

    @Bind("NSURLBookmarkCreationPreferFileIDResolution")
    public static final int PreferFileIDResolution = 1 << 8;

    @Bind("NSURLBookmarkCreationMinimalBookmark")
    public static final int MinimalBookmark = 1 << 9;

    @Bind("NSURLBookmarkCreationSuitableForBookmarkFile")
    public static final int SuitableForBookmarkFile = 1 << 10;

    @Bind("NSURLBookmarkCreationWithSecurityScope")
    public static final int WithSecurityScope = 1 << 11;

    @Bind("NSURLBookmarkCreationSecurityScopeAllowOnlyReadAccess")
    public static final int SecurityScopeAllowOnlyReadAccess = 1 << 12;

}
