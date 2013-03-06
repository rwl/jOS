package jos.samples.content.screens.iphone.browsers;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

import com.google.j2objc.annotations.Outlet;

public class BrowsersHome extends UIViewController {

    @Outlet
    UIButton btnLocalBrowser;

    @Outlet
    UIButton btnWebBrowser;

    @Outlet
    UIButton btnInteractivity;

    public BrowsersHome() {
        super("BrowsersHome", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        getNavigationItem().setTitle("UIWebView Examples");

        // on web browser button click, load the web browser page
        btnWebBrowser.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                getNavigationController().pushViewController(new WebBrowser(), true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        // on local browser button click, load the local browser page
        btnLocalBrowser.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                getNavigationController().pushViewController(new LocalBrowser(), true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        // interacting with the web view
        btnInteractivity.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                getNavigationController().pushViewController(new InteractiveBrowser(), true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);;
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(UIInterfaceOrientation orientation) {
        return true;
    }

}
