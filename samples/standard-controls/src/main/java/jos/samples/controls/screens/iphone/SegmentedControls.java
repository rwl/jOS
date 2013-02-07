package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIViewController;

public class SegmentedControls extends UIViewController {

    public SegmentedControls() {
        super("SegmentedControls_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Segmented Controls");
    }

}
