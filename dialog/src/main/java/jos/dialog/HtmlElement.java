package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSURLRequest;
import jos.api.foundation.NSUrl;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIViewAutoresizing;
import jos.api.uikit.UIViewController;
import jos.api.uikit.UIWebView;
import jos.api.uikit.UIWebViewDelegate;

/**
 * Used to display a cell that will launch a web browser when selected.
 */
public class HtmlElement extends Element {

    NSUrl nsUrl;
    static NSString hkey = new NSString("HtmlElement");
    UIWebView web;

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
        UITableViewCell cell = tv.DequeueReusableCell(getCellKey());
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
                    getCellKey());
            cell.setSelectionStyle(UITableViewCellSelectionStyle.BLUE);
        }
        cell.setAccessory(UITableViewCellAccessoryType.DISCLOSURE_INDICATOR);

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

        public boolean Autorotate;

        @Override
        public boolean shouldAutorotateToInterfaceOrientation(
                UIInterfaceOrientation toInterfaceOrientation) {
            return Autorotate;
        }
    }

    @Override
    public void Selected (DialogViewController dvc, UITableView tableView, NSIndexPath path)
    {
        int i = 0;
        WebViewController vc = new WebViewController (this) {
            Autorotate = dvc.isAutorotate();
        };

        web = new UIWebView (UIScreen.getMainScreen().getBounds());
        web.setBackgroundColor(UIColor.WHITE);
        web.setScalesPageToFit(true);
        web.setAutoresizingMask(UIViewAutoresizing.ALL);
        web.setDelegate(new UIWebViewDelegate() {

            @Override
            public void loadStarted(UIWebView webView) {
             // this is called several times and only one UIActivityIndicatorView is needed
                if (i++ == 0) {
                    var indicator = new UIActivityIndicatorView (UIActivityIndicatorViewStyle.White);
                    vc.NavigationItem.RightBarButtonItem = new UIBarButtonItem (indicator);
                    indicator.StartAnimating ();
                }
                NetworkActivity = true;
            }

            @Override
            public void loadFinished(UIWebView webView) {
                if (--i == 0) {
                    // we stopped loading, remove indicator and dispose of UIWebView
                    vc.NavigationItem.RightBarButtonItem = null;
                    web.stopLoading ();
                    web.dispose ();
                }
                NetworkActivity = false;
            }

            @Override
            public void didFailLoad(UIWebView webView, NSError error) {
                NetworkActivity = false;
                vc.NavigationItem.RightBarButtonItem = null;
                if (web != null)
                    web.LoadHtmlString (
                        String.Format ("<html><center><font size=+5 color='red'>{0}:<br>{1}</font></center></html>",
                        "An error occurred:".GetText (), args.Error.LocalizedDescription), null);

            }
        });
        vc.getNavigationItem().setTitle(Caption);

        vc.getView().setAutosizesSubviews(true);
        vc.getView().addSubview (web);

        dvc.ActivateController (vc);
        web.loadRequest (NSURLRequest.fromUrl (nsUrl));
    }
}