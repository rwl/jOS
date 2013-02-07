package jos.samples.controls.screens.iphone;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;

public class ActivitySpinnerScreen extends UIViewController {

    public ActivitySpinnerScreen(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export("initWithCoder:")
    public ActivitySpinnerScreen(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ActivitySpinnerScreen() {
        super("ActivitySpinnerScreen_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        title = "Activity Spinners";
    }

}
