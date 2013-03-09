package jos.api.uikit;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSData;
import jos.api.foundation.NSURLRequest;
import jos.api.foundation.NSUrl;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;


@BaseType({NSCoding.class, UIScrollViewDelegate.class})
@Register(isWrapper = true)
public class UIWebView extends UIView {

    @Export("init")
    public UIWebView() {
    }

    @Export("initWithFrame:")
    public UIWebView(final CGRect frame) {
    }


    @Export("delegate")
    public UIWebViewDelegate getDelegate() {
        throw new RuntimeException();
    }

    @Export("setDelegate:")
    public void setDelegate(UIWebViewDelegate value) {
        throw new RuntimeException();
    }

    @Export("scrollView")
    public UIScrollView getScrollView() {
        throw new RuntimeException();
    }

    @Export("request")
    public NSURLRequest getRequest() {
        throw new RuntimeException();
    }

    @Bind("canGoBack")
    @Export("canGoBack")
    public boolean canGoBack() {
        throw new RuntimeException();
    }

    @Bind("canGoForward")
    @Export("canGoForward")
    public boolean canGoForward() {
        throw new RuntimeException();
    }

    @Bind("isLoading")
    @Export("loading")
    public boolean getLoading() {
        throw new RuntimeException();
    }

    @Export("scalesPageToFit")
    public boolean getScalesPageToFit() {
        throw new RuntimeException();
    }

    @Export("setScalesPageToFit:")
    public void setScalesPageToFit(boolean value) {
        throw new RuntimeException();
    }

    @Export("detectsPhoneNumbers")
    public boolean getDetectsPhoneNumbers() {
        throw new RuntimeException();
    }

    @Export("setDetectsPhoneNumbers:")
    public void setDetectsPhoneNumbers(boolean value) {
        throw new RuntimeException();
    }

    @Export("dataDetectorTypes")
    public UIDataDetectorTypes getDataDetectorTypes() {
        throw new RuntimeException();
    }

    @Export("setDataDetectorTypes:")
    public void setDataDetectorTypes(UIDataDetectorTypes value) {
        throw new RuntimeException();
    }

    @Export("allowsInlineMediaPlayback")
    public boolean getAllowsInlineMediaPlayback() {
        throw new RuntimeException();
    }

    @Export("setAllowsInlineMediaPlayback:")
    public void setAllowsInlineMediaPlayback(boolean value) {
        throw new RuntimeException();
    }

    @Export("mediaPlaybackRequiresUserAction")
    public boolean getMediaPlaybackRequiresUserAction() {
        throw new RuntimeException();
    }

    @Export("setMediaPlaybackRequiresUserAction:")
    public void setMediaPlaybackRequiresUserAction(boolean value) {
        throw new RuntimeException();
    }

    @Export("mediaPlaybackAllowsAirPlay")
    public boolean getMediaPlaybackAllowsAirPlay() {
        throw new RuntimeException();
    }

    @Export("setMediaPlaybackAllowsAirPlay:")
    public void setMediaPlaybackAllowsAirPlay(boolean value) {
        throw new RuntimeException();
    }

    @Export("suppressesIncrementalRendering")
    public boolean getSuppressesIncrementalRendering() {
        throw new RuntimeException();
    }

    @Export("setSuppressesIncrementalRendering:")
    public void setSuppressesIncrementalRendering(boolean value) {
        throw new RuntimeException();
    }

    @Export("keyboardDisplayRequiresUserAction")
    public boolean getKeyboardDisplayRequiresUserAction() {
        throw new RuntimeException();
    }

    @Export("setKeyboardDisplayRequiresUserAction:")
    public void setKeyboardDisplayRequiresUserAction(boolean value) {
        throw new RuntimeException();
    }

    @Export("loadRequest:")
    public void loadRequest(NSURLRequest request) {
        throw new RuntimeException();
    }

    @Export("loadHTMLString:baseURL:")
    public void loadHTML(String string, NSUrl baseURL) {
        throw new RuntimeException();
    }

    @Export("loadData:MIMEType:textEncodingName:baseURL:")
    public void loadDataMIMETypetextEncodingNamebaseURL(NSData data, String MIMEType, String textEncodingName, NSUrl baseURL) {
        throw new RuntimeException();
    }

    @Export("reload")
    public void reload() {
        throw new RuntimeException();
    }

    @Export("stopLoading")
    public void stopLoading() {
        throw new RuntimeException();
    }

    @Export("goBack")
    public void goBack() {
        throw new RuntimeException();
    }

    @Export("goForward")
    public void goForward() {
        throw new RuntimeException();
    }

    @Export("stringByEvaluatingJavaScriptFromString:")
    public String evaluateJavaScript(String script) {
        throw new RuntimeException();
    }

}