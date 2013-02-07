package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

public class ToolbarItems extends UIViewController {

    public ToolbarItems(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export("initWithCoder:")
    public ToolbarItems(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ToolbarItems() {
        super("ToolbarItems", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "Various toolbar items";
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        if (toInterfaceOrientation == UIInterfaceOrientation.LandscapeLeft
                || toInterfaceOrientation == UIInterfaceOrientation.LandscapeRight) {
            return true;
        } else {
            return false;
        }
    }
}
