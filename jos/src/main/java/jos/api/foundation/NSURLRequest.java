package jos.api.foundation;

import java.io.InputStream;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCoding.class, NSCopying.class, NSMutableCopying.class})
@Register(isWrapper = true)
public class NSURLRequest extends NSObject {
    @Export("requestWithURL:")
    public NSObject requestWithURL(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("requestWithURL:cachePolicy:timeoutInterval:")
    public NSObject requestWithURLcachePolicytimeoutInterval(NSUrl URL, NSURLRequestCachePolicy cachePolicy, double timeoutInterval) {
        throw new RuntimeException();
    }

    @Export("initWithURL:")
    public NSURLRequest(NSUrl url) {
        throw new RuntimeException();
    }

    @Export("initWithURL:cachePolicy:timeoutInterval:")
    public NSURLRequest(NSUrl URL, NSURLRequestCachePolicy cachePolicy, double timeoutInterval) {
        throw new RuntimeException();
    }

    @Export("URL")
    public NSUrl getUrl() {
        throw new RuntimeException();
    }

    @Export("cachePolicy")
    public NSURLRequestCachePolicy cachePolicy() {
        throw new RuntimeException();
    }

    @Export("timeoutInterval")
    public double getTimeoutInterval() {
        throw new RuntimeException();
    }

    @Export("mainDocumentURL")
    public NSUrl mainDocumentURL() {
        throw new RuntimeException();
    }

    @Export("networkServiceType")
    public NSURLRequestNetworkServiceType getNetworkServiceType() {
        throw new RuntimeException();
    }

    @Export("allowsCellularAccess")
    public boolean allowsCellularAccess() {
        throw new RuntimeException();
    }


    @Export("HTTPMethod")
    public String HTTPMethod() {
        throw new RuntimeException();
    }

    @Export("allHTTPHeaderFields")
    public NSDictionary allHTTPHeaderFields() {
        throw new RuntimeException();
    }

    @Export("valueForHTTPHeaderField:")
    public String valueForHTTPHeaderField(NSString field) {
        throw new RuntimeException();
    }

    @Export("HTTPBody")
    public NSData HTTPBody() {
        throw new RuntimeException();
    }

    @Export("HTTPBodyStream")
    public InputStream HTTPBodyStream() {
        throw new RuntimeException();
    }

    @Export("HTTPShouldHandleCookies")
    public boolean HTTPShouldHandleCookies() {
        throw new RuntimeException();
    }

    @Export("HTTPShouldUsePipelining")
    public boolean HTTPShouldUsePipelining() {
        throw new RuntimeException();
    }

}