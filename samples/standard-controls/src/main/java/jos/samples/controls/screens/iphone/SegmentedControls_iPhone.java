package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class SegmentedControls_iPhone extends UIViewController {

    public SegmentedControls_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public SegmentedControls_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public SegmentedControls_iPhone() {
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
