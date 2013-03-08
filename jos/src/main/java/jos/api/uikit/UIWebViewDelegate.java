package jos.api.uikit;

import jos.api.foundation.NSError;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSURLRequest;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIWebViewDelegate extends NSObject {

    @Export("webView:shouldStartLoadWithRequest:navigationType:")
    public boolean shouldStartLoad(UIWebView webView, NSURLRequest request, UIWebViewNavigationType navigationType) {
        throw new RuntimeException();
    }

    @Export("webViewDidStartLoad:")
    public void loadStarted(UIWebView webView) {
        throw new RuntimeException();
    }

    @Export("webViewDidFinishLoad:")
    public void loadFinished(UIWebView webView) {
        throw new RuntimeException();
    }

    @Export("webView:didFailLoadWithError:")
    public void didFailLoad(UIWebView webView, NSError error) {
        throw new RuntimeException();
    }

}
