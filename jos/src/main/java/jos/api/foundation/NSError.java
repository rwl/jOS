package jos.api.foundation;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCopying.class, NSSecureCoding.class})
@Register(isWrapper = true)
public class NSError extends NSObject {
    @Export("initWithDomain:code:userInfo:")
    public NSObject initWithDomaincodeuserInfo(String domain, int code, NSDictionary dict) {
        throw new RuntimeException();
    }

    @Export("errorWithDomain:code:userInfo:")
    public static NSObject errorWithDomaincodeuserInfo(String domain, int code, NSDictionary dict) {
        throw new RuntimeException();
    }

    @Export("domain")
    public String domain() {
        throw new RuntimeException();
    }

    @Export("code")
    public int code() {
        throw new RuntimeException();
    }

    @Export("userInfo")
    public NSDictionary userInfo() {
        throw new RuntimeException();
    }

    @Export("localizedDescription")
    public String getLocalizedDescription() {
        throw new RuntimeException();
    }

    @Export("localizedFailureReason")
    public NSString getLocalizedFailureReason() {
        throw new RuntimeException();
    }

    @Export("localizedRecoverySuggestion")
    public NSString getLocalizedRecoverySuggestion() {
        throw new RuntimeException();
    }

    @Export("localizedRecoveryOptions")
    public NSArray localizedRecoveryOptions() {
        throw new RuntimeException();
    }

    @Export("recoveryAttempter")
    public NSObject recoveryAttempter() {
        throw new RuntimeException();
    }

    @Export("helpAnchor")
    public String helpAnchor() {
        throw new RuntimeException();
    }

}