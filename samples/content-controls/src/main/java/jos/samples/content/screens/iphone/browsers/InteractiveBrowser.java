package jos.samples.content.screens.iphone.browsers;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSObject;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

public class InteractiveBrowser extends UIViewController {

    @Outlet
    UIButton btnRunScript;

    @Outlet
    UIWebView webMain;

    public InteractiveBrowser () {
        super("InteractiveBrowser", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        btnRunScript.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                webMain.evaluateJavascript("RunAction();");
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        setTitle("Interactivity");

        // can load the request directly
        String homePageUrl = NSBundle.getMainBundle().getBundlePath()
                + "/Content/InteractivePages/Home.html";
        webMain.loadRequest(new NSUrlRequest(new NSUrl(homePageUrl, false)));

        webMain.shouldStartLoad += this.HandleStartLoad;
    }

    /**
     * In order to listen to events, we need to handle the ShouldStartLoad event. If
     * it's an event that we want to handle ourselves, rather than having the web view
     * do it, we need to return false, so that the navigation doesn't happen. in this
     * particular case we are checking for links that have //LOCAL/Action='whateverAction'
     */
    public boolean handleStartLoad(UIWebView webView, NSUrlRequest request,
                     UIWebViewNavigationType navigationType) {
        System.out.println(navigationType.toString());

        // first, we check to see if it's a link
        if (navigationType == UIWebViewNavigationType.LINK_CLICKED) {

            // next, we check to see if it's a link with //LOCAL in it.
            if(request.getUrl().getRelativeString().startsWith("file://LOCAL")) {

                new UIAlertView("Action!", "You clicked an action.", null, "OK", null).show();
                // return false so that the browser doesn't try to navigate
                return false;
            }
        }
        // if we got here, it's not a link we want to handle
        return true;
    }

}
