package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

public class ToolbarItems extends UIViewController {

    public ToolbarItems() {
        super("ToolbarItems", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Various toolbar items");
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation orientation) {
        return orientation == UIInterfaceOrientation.LANDSCAPE_LEFT
                || orientation == UIInterfaceOrientation.LANDSCAPE_RIGHT;
    }

}
