package jos.samples.hello;

import jos.uikit.UIInterfaceOrientation;
import jos.uikit.UIViewController;

public class HelloViewController extends UIViewController {

    public HelloViewController() {
        super("HelloWorldViewController", null);
    }

    @Override
    public void viewDidUnload() {
        super.viewDidUnload();
//        releaseDesignerOutlets();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(UIInterfaceOrientation toInterfaceOrientation) {
        // Return true for supported orientations
        return toInterfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown;
    }
}
