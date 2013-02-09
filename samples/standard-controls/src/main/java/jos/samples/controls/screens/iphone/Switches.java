package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UISwitch;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class Switches extends UIViewController {

    @Outlet
    UISwitch swchOne;

    @Outlet
    UISwitch swchTwo;

    public Switches() {
        super("Switches_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Switches");

        /*swchOne.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject object, UIEvent event) {
                new UIAlertView("Switch one change!", "is on: "
                        + swchOne.isOn(), null, "OK").show();
            }
        }, UIControlEvent.VALUE_CHANGED);*/
        swchOne.addTarget(this, new Selector("handleSwitchOne"),
                UIControlEvent.VALUE_CHANGED);

        /*swchTwo.addTarget(new EventListener() {

            @Override
            public void onEvent(NSObject object, UIEvent event) {
                new UIAlertView("Switch two change!", "is on: "
                        + swchTwo.isOn(), null, "OK").show();
            }
        }, UIControlEvent.VALUE_CHANGED);*/
        swchTwo.addTarget(this, new Selector("handleSwitchTwo"),
                UIControlEvent.VALUE_CHANGED);
    }

    protected void handleSwitchOne() {
        new UIAlertView("Switch one change!", "is on: "
                + swchOne.isOn(), null, "OK").show();
    }

    protected void handleSwitchTwo() {
        new UIAlertView("Switch two change!", "is on: "
                + swchTwo.isOn(), null, "OK").show();
    }

}
