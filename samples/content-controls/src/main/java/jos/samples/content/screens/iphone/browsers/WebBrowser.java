package jos.samples.content.screens.iphone.browsers;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIActivityIndicatorView;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UITextField;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

import com.google.j2objc.annotations.Outlet;

public class WebBrowser extends UIViewController {

    @Outlet
    UIButton btnBack;

    @Outlet
    UIButton btnForward;

    @Outlet
    UIButton btnGo;

    @Outlet
    UIButton btnStop;

    @Outlet
    UITextField txtAddress;

    @Outlet
    UIWebView webMain;

    @Outlet
    UIActivityIndicatorView imgBusy;

    public WebBrowser() {
        super("WebBrowser", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the title
        setTitle("Browser");

        // wire up event handlers
        btnBack.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if (webMain.canGoBack()) {
                    webMain.goBack();
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
        btnForward.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if (webMain.canGoForward()) {
                    webMain.goForward();
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
        btnStop.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                webMain.stopLoading();
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
        btnGo.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                navigateToUrl();
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
        txtAddress.shouldReturn = handleEditingDone;
        webMain.loadStarted = loadStarted;
        webMain.loadFinished = loadingFinished;
        webMain.loadError = loadError;

        // disable our buttons to start
        btnBack.setEnabled(false);
        btnForward.setEnabled(false);
        btnStop.setEnabled(false);

        // navigate to google
        txtAddress.setText("google.com");
        navigateToUrl();
    }

    protected void navigateToUrl() {
        String url = txtAddress.getText();

        // make sure it's prefixed with either https:// or http://
        if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            url = "http://" + url;
        }

        webMain.loadRequest(new NSUrlRequest(new NSUrl(url)));
    }

    protected void setBackAndForwardEnable() {
        btnBack.setEnabled(webMain.canGoBack());
        btnForward.setEnabled(webMain.canGoForward());
    }

    protected boolean handleEditingDone() {
        txtAddress.resignFirstResponder();
        navigateToUrl();
        return true;
    }

    public void loadStarted() {
        btnStop.Enabled = true;
        SetBackAndForwardEnable();
        imgBusy.StartAnimating();
    }

    public void LoadingFinished() {
        setBackAndForwardEnable();
        btnStop.setEnabled(false);
        imgBusy.stopAnimating();
    }

    public void loadError(NSObject sender, UIWebErrorArgs e) {
        imgBusy.stopAnimating();
        btnStop.setEnabled(false);
        setBackAndForwardEnable();
        // show the error
        UIAlertView alert = new UIAlertView("Browse Error",
                "Web page failed to load: " + e.getError().toString(), null,
                "OK", null);
        alert.show();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation orientation) {
        return true;
    }

}
