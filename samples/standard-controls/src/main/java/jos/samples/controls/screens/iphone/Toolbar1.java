package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class Toolbar1 extends UIViewController {

    @Outlet
    UIBarButtonItem btnOne;
    @Outlet
    UIBarButtonItem btnTwo;
    @Outlet
    UIBarButtonItem btnThree;
    @Outlet
    UIBarButtonItem btnFour;

    public Toolbar1() {
        super("Toolbar1_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Toolbar");

        btnOne.setTarget(this);
        btnOne.setAction(new Selector("handleButtonClick"));
    }

    protected void handleButtonClick() {
        new UIAlertView("click!", "btnOne clicked", null, "OK", null).show();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        return true;
    }

}
