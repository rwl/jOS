package jos.api.foundation;

import java.io.InputStream;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSURLRequest.class)
@Register(isWrapper = true)
public class NSMutableURLRequest extends NSURLRequest {

    @Export("initWithURL:")
    public NSMutableURLRequest(NSUrl url) {
        super(url);
    }

    @Export("setURL:")
    public void setURL(NSUrl URL) {
        throw new RuntimeException();
    }

    @Export("setCachePolicy:")
    public void setCachePolicy(NSURLRequestCachePolicy policy) {
        throw new RuntimeException();
    }

    @Export("setTimeoutInterval:")
    public void setTimeoutInterval(double seconds) {
        throw new RuntimeException();
    }

    @Export("setMainDocumentURL:")
    public void setMainDocumentURL(NSUrl URL) {
        throw new RuntimeException();
    }

    @Export("setNetworkServiceType:")
    public void setNetworkServiceType(NSURLRequestNetworkServiceType networkServiceType) {
        throw new RuntimeException();
    }

    @Export("setAllowsCellularAccess:")
    public void setAllowsCellularAccess(boolean allow) {
        throw new RuntimeException();
    }


    @Export("setHTTPMethod:")
    public void setHTTPMethod(String method) {
        throw new RuntimeException();
    }

    @Export("setAllHTTPHeaderFields:")
    public void setAllHTTPHeaderFields(NSDictionary headerFields) {
        throw new RuntimeException();
    }

    @Export("setValue:forHTTPHeaderField:")
    public void setValue(NSString value, String field) {
        throw new RuntimeException();
    }

    @Export("addValue:forHTTPHeaderField:")
    public void addValue(NSString value, String field) {
        throw new RuntimeException();
    }

    @Export("setHTTPBody:")
    public void setHTTPBody(NSData data) {
        throw new RuntimeException();
    }

    @Export("setHTTPBodyStream:")
    public void setHTTPBodyStream(InputStream stream) {
        throw new RuntimeException();
    }

    @Export("setHTTPShouldHandleCookies:")
    public void setHTTPShouldHandleCookies(boolean should) {
        throw new RuntimeException();
    }

    @Export("setHTTPShouldUsePipelining:")
    public void setHTTPShouldUsePipelining(boolean shouldUsePipelining) {
        throw new RuntimeException();
    }

}