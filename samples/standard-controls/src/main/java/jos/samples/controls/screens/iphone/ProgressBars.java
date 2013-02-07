package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIProgressView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class ProgressBars extends UIViewController {

    @Outlet
    UIProgressView btnProgress1;

    public ProgressBars() {
        super("ProgressBars_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Progress Bars");

        // UIProgressView progressBar = new UIProgressView(UIProgressViewStyle.BAR);
        // progressBar.setProgress(.5f);
    }

}
