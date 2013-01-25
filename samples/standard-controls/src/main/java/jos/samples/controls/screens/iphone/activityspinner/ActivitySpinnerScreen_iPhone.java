package jos.samples.controls.screens.iphone.activityspinner;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;

public class ActivitySpinnerScreen_iPhone extends AbstractActivitySpinnerScreen_iPhone {

    public ActivitySpinnerScreen_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public ActivitySpinnerScreen_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ActivitySpinnerScreen_iPhone() {
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
