package jos.uikit;

import jos.api.Export;
import jos.api.Register;
import jos.foundation.NSBundle;

@Register(isWrapper = true)
public class UIViewController extends UIResponder {

    @Export(selector = "initWithNibName:bundle:")
    public UIViewController(final String nibName, final NSBundle bundle) {
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
}
