package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSBundle;

@Register(isWrapper = true)
public class UIViewController extends UIResponder {

    public UIView view;

    @Export(selector = "initWithNibName:bundle:")
    public UIViewController(final String nibName, final NSBundle bundle) {
    }

    public void loadView() {
    }

    //    @Export
    @Deprecated
    public boolean shouldAutorotateToInterfaceOrientation(
            final UIInterfaceOrientation toInterfaceOrientation) {
        return false;
    }

    //  @Export
    @Deprecated
    public void viewDidUnload() {
    }

    /**
     * Dispose of any resources that can be recreated.
     */
    public void didReceiveMemoryWarning() {
    }
}
