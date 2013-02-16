package jos.samples.content.screens.iphone.browsers;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSBundle;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

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
        webMain.loadRequest(new NSUrlRequest(new NSUrl(homePageUrl, false)));

        // can also manually create html
        String contentDirectoryPath = NSBundle.getMainBundle().getBundlePath() + "/Content/";
        webMain.LoadHtmlString("<html><a href=\"Home.html\">Click Me</a>",
                new NSUrl(contentDirectoryPath, true));

    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(UIInterfaceOrientation orientation) {
        return true;
    }

}
