package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class SegmentedControls extends UIViewController {

    public SegmentedControls(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public SegmentedControls(NSCoder coder) {
        super(coder);
        initialize();
    }

    public SegmentedControls() {
        super("SegmentedControls_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "Segmented Controls";
    }
}
