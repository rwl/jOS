package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSString;
import jos.api.foundation.NSURLRequest;
import jos.api.foundation.NSError;
import jos.api.foundation.NSUrl;
import jos.api.uikit.UIActivityIndicatorView;
import jos.api.uikit.UIActivityIndicatorViewStyle;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellSelectionStyle;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIViewAutoresizing;
import jos.api.uikit.UIViewController;
import jos.api.uikit.UIWebView;
import jos.api.uikit.UIWebViewDelegate;

/**
 * Used to display a cell that will launch a web browser when selected.
 */
public class HtmlElement extends Element {

    private NSUrl nsUrl;
    private static final NSString hkey = new NSString("HtmlElement");
    private UIWebView web;

    public HtmlElement(String caption, String url) {
        super(caption);
        setUrl(url);
    }

    public HtmlElement(String caption, NSUrl url) {
        super(caption);
        nsUrl = url;
    }

    @Override
    protected NSString getCellKey() {
        return hkey;
    }

    public String getUrl() {
        return nsUrl.toString();
    }

    public void setUrl(String value) {
        nsUrl = new NSUrl(value);
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.dequeueReusableCell(getCellKey());
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
                    getCellKey());
            cell.setSelectionStyle(UITableViewCellSelectionStyle.BLUE);
        }
        cell.setAccessoryType(UITableViewCellAccessoryType.DISCLOSURE_INDICATOR);

        cell.getTextLabel().setText(Caption);
        return cell;
    }

    static void setNetworkActivity(boolean value) {
        UIApplication.getSharedApplication()
                .setNetworkActivityIndicatorVisible(value);
    }

    // We use this class to dispose the web control when it is not
    // in use, as it could be a bit of a pig, and we do not want to
    // wait for the GC to kick-in.
    class WebViewController extends UIViewController {

        HtmlElement container;

        public WebViewController(HtmlElement container) {
            super();
            this.container = container;
        }

        private boolean Autorotate;

        @Override
        public boolean shouldAutorotateToInterfaceOrientation(
                UIInterfaceOrientation toInterfaceOrientation) {
            return Autorotate;
        }

        public boolean isAutorotate() {
            return Autorotate;
        }

        public void setAutorotate(boolean autorotate) {
            Autorotate = autorotate;
        }
    }

    private int i = 0;

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath path) {
        i = 0;
        final WebViewController vc = new WebViewController(this);
        vc.setAutorotate(dvc.isAutorotate());

        web = new UIWebView(UIScreen.getMainScreen().getBounds());
        web.setBackgroundColor(UIColor.WHITE);
        web.setScalesPageToFit(true);
        web.setAutoresizingMask(UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN
                | UIViewAutoresizing.FLEXIBLE_HEIGHT
                | UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN
                | UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN
                | UIViewAutoresizing.FLEXIBLE_TOP_MARGIN
                | UIViewAutoresizing.FLEXIBLE_WIDTH);
        web.setDelegate(new UIWebViewDelegate() {

            @Override
            public void loadStarted(UIWebView webView) {
                // this is called several times and only one UIActivityIndicatorView is needed
                if (i++ == 0) {
                    UIActivityIndicatorView indicator = new UIActivityIndicatorView(
                            UIActivityIndicatorViewStyle.WHITE);
                    vc.getNavigationItem().setRightBarButtonItem(
                            new UIBarButtonItem(indicator));
                    indicator.startAnimating();
                }
                setNetworkActivity(true);
            }

            @Override
            public void loadFinished(UIWebView webView) {
                if (--i == 0) {
                    // we stopped loading, remove indicator and dispose of UIWebView
                    vc.getNavigationItem().setRightBarButtonItem(null);
                    web.stopLoading();
                    web.dealloc();
                }
                setNetworkActivity(false);
            }

            @Override
            public void didFailLoad(UIWebView webView, NSError error) {
                setNetworkActivity(false);
                vc.getNavigationItem().setRightBarButtonItem(null);
                if (web != null)
                    web.loadHTML(
                            String.format(
                                    "<html><center><font size=+5 color='red'>%s:<br>%s</font></center></html>",
                                    "An error occurred:",
                                    error.getLocalizedDescription()), null);
            }
        });
        vc.getNavigationItem().setTitle(Caption);

        vc.getView().setAutoresizesSubviews(true);
        vc.getView().addSubview(web);

        dvc.ActivateController(vc);
        web.loadRequest(new NSURLRequest(nsUrl));
    }
}