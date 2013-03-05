package jos.api.foundation;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSDataWritingOptions {

    @Bind("NSDataWritingAtomic")
    public static final int Atomic = 1 << 0;

    @Bind("NSDataWritingWithoutOverwriting")
    public static final int WithoutOverwriting = 1 << 1;


    @Bind("NSDataWritingFileProtectionNone")
    public static final int FileProtectionNone = 0x10000000;

    @Bind("NSDataWritingFileProtectionComplete")
    public static final int FileProtectionComplete = 0x20000000;

    @Bind("NSDataWritingFileProtectionCompleteUnlessOpen")
    public static final int FileProtectionCompleteUnlessOpen = 0x30000000;

    @Bind("NSDataWritingFileProtectionCompleteUntilFirstUserAuthentication")
    public static final int FileProtectionCompleteUntilFirstUserAuthentication = 0x40000000;

    @Bind("NSDataWritingFileProtectionMask")
    public static final int FileProtectionMask = 0xf0000000;

}
