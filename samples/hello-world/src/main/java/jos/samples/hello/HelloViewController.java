package jos.samples.hello;

import jos.api.Export;
import jos.foundation.NSBundle;
import jos.uikit.UIScreen;
import jos.uikit.UIView;
import jos.uikit.UIViewController;

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

    /*@Override
    public void viewDidUnload() {
        super.viewDidUnload();
        //releaseDesignerOutlets();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(UIInterfaceOrientation toInterfaceOrientation) {
        // Return true for supported orientations
        return toInterfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown;
    }*/
}
