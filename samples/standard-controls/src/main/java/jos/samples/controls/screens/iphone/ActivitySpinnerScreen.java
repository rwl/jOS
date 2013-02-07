package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIViewController;

public class ActivitySpinnerScreen extends UIViewController {

    public ActivitySpinnerScreen() {
        super("ActivitySpinnerScreen_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Activity Spinners");
    }

}
