package jos.samples.hello;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Action;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class IPhoneViewController extends UIViewController {

    protected static int _numberOfTimesClicked = 0;

    @Outlet
    public UIButton btnClickMe;

    @Outlet
    public UILabel lblOutput;

    public IPhoneViewController(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.btnClickMe.addTarget(this, new Selector("onButtonClick"),
                UIControlEvent.TOUCH_UP_INSIDE);
        /*this.btnClickMe.addTarget(new EventListener() {

            @Override
            public void onEvent(Object object, int event) {
                _numberOfTimesClicked += 1;
                lblOutput.text = "Clicked [" + _numberOfTimesClicked
                        + "] times!";
            }
        }, UIControlEvent.TouchUpInside);*/
    }

    protected void onButtonClick() {
        _numberOfTimesClicked += 1;
        lblOutput.text = "Clicked [" + _numberOfTimesClicked
                + "] times!";
    }

    /**
     * Returns true for supported orientations.
     */
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        return (toInterfaceOrientation != UIInterfaceOrientation.PORTRAIT_UPSIDE_DOWN);
    }

    /**
     * This is our common action handler. Two buttons call this via an action
     * method.
     */
    @Action("actnButtonClick:")
    protected void actnButtonClick(NSObject sender) {
        this.lblOutput.text = "Action button "
                + ((UIButton) sender).currentTitle + " clicked.";
    }

}
