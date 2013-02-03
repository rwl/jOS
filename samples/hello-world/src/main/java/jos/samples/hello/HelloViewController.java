package jos.samples.hello;

import jos.api.foundation.NSBundle;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;


public class HelloViewController extends UIViewController {

    public UIView view;

    @Export(selector = "initWithNibName:bundle:")
    public HelloViewController(final String nibName, final NSBundle bundle) {
        super(nibName, null);
    }

    public HelloViewController() {
        super("HelloWorldViewController", null);
    }

    @Override
    public void loadView() {
        this.view = new HelloView(UIScreen.mainScreen.applicationFrame);
    }
}
