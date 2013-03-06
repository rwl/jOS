package jos.samples.content.screens.iphone.browsers;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSURLRequest;
import jos.api.foundation.NSUrl;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;
import jos.api.uikit.UIWebView;

public class LocalBrowser extends UIViewController {

    @Outlet
    UIWebView webMain;

    public LocalBrowser() {
        super("LocalBrowser", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        setTitle("My Content");

        // can load the request directly
        String homePageUrl = NSBundle.getMainBundle().getBundlePath() + "/Content/Home.html";
        webMain.loadRequest(new NSURLRequest(new NSUrl(homePageUrl, false)));

        // can also manually create html
        String contentDirectoryPath = NSBundle.getMainBundle().getBundlePath() + "/Content/";
        webMain.loadHTML("<html><a href=\"Home.html\">Click Me</a>",
                new NSUrl(contentDirectoryPath, true));
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(UIInterfaceOrientation orientation) {
        return true;
    }

}
