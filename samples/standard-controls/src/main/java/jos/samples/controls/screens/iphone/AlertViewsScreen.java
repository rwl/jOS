package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIAlertViewDelegate;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIViewController;
import jos.samples.controls.controls.ActivityIndicatorAlertView;

import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class AlertViewsScreen extends UIViewController {

    @Outlet
    UIButton btnCustomButtons;

    @Outlet
    UIButton btnSimpleAlert;

    @Outlet
    UIButton btnCustomButtonsWithDelegate;

    @Outlet
    UIButton btnCustomAlert;

    /**
     * This is here to keep a reference to an alert after the method that
     * creates it completes. unlike in windows, the .show() method is not
     * blocking (with thread magic that still keeps the UI unblocked), so after
     * show() returns, the method will complete and the reference to the alert
     * (and more importantly, the alert delegate will get garbage collected).
     */
    UIAlertView alert;

    public AlertViewsScreen() {
        super("AlertViewsScreen_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Alert Views");

        btnSimpleAlert.addTarget(this, new Selector(
                "handleBtnSimpleAlertTouchUpInside"),
                UIControlEvent.TOUCH_UP_INSIDE);
        btnCustomButtons.addTarget(this, new Selector(
                "handleBtnCustomButtonsTouchUpInside"),
                UIControlEvent.TOUCH_UP_INSIDE);
        btnCustomButtonsWithDelegate.addTarget(this, new Selector(
                "handleBtnCustomButtonsWithDelegateTouchUpInside"),
                UIControlEvent.TOUCH_UP_INSIDE);
        btnCustomAlert.addTarget(this, new Selector(
                "handleBtnCustomAlertTouchUpInside"),
                UIControlEvent.TOUCH_UP_INSIDE);
    }

    /**
     * Runs when the simple alert button is clicked. launches a very simple
     * alert that presents an "OK" button, does not use a delegate
     */
    protected void handleBtnSimpleAlertTouchUpInside() {
        alert = new UIAlertView("alert title", "this is a simple alert.", null,
                "OK");
        alert.show();
    }

    protected void handleBtnCustomButtonsTouchUpInside() {
        alert = new UIAlertView("custom buttons alert",
                "this alert has custom buttons", null, "ok", new String[] {
                        "custom button 1", "custom button 2" });

        // wire up a handler for the click event
        alert.setDelegate(new UIAlertViewDelegate() {
            @Override
            public void clicked(UIAlertView view, int buttonIndex) {
                System.out.println("Button " + buttonIndex + " clicked");
            }
        });
        alert.show();
    }

    /**
     * Runs when the Custom Buttons alert button is clicked. launches an alert
     * with additional buttons added
     */
    protected void handleBtnCustomButtonsWithDelegateTouchUpInside() {
        alert = new UIAlertView("custom buttons alert",
                "this alert has custom buttons",
                new CustomButtonsAlertDelegate(), "ok", "custom button 1",
                "custom button 2");
        alert.show();
    }

    /**
     * This is our custom buttons alert delegate.
     */
    protected class CustomButtonsAlertDelegate extends UIAlertViewDelegate {
        public CustomButtonsAlertDelegate() {
            super();
        }

        @Override
        public void canceled(UIAlertView alertView) {
            System.out.println("Alert Cancelled");
        }

        /**
         * Runs when any of the custom buttons on the alert are clicked
         */
        @Override
        public void clicked(UIAlertView alertview, int buttonIndex) {
            System.out.println("Button " + buttonIndex + " clicked");
        }

        /**
         * Runs right after clicked, and before dismissed
         */
        @Override
        public void willDismiss(UIAlertView alertView, int buttonIndex) {
            System.out.println("Alert will dismiss, button " + buttonIndex);
        }

        /**
         * Runs after clicked
         */
        @Override
        public void dismissed(UIAlertView alertView, int buttonIndex) {
            System.out.println("Alert Dismissed, button " + buttonIndex);
        }
    }

    /**
     * Runs when the custom alert button is pressed. shows the alert and then
     * kicks off a secondary thread that spins for 5 seconds and then closes the
     * alert.
     */
    protected void handleBtnCustomAlertTouchUpInside() {
        alert = new ActivityIndicatorAlertView();
        ((ActivityIndicatorAlertView) alert).setMessage("performing stuff");
        alert.show();

        Thread longRunningProc = new Thread(new Runnable() {

            @Override
            public void run() {
                longRunningProcess(5);
            }
        });
        longRunningProc.start();
    }

    /**
     * Spins a thread for the specified amount of time and then closes the
     * custom alert. used to simulate a long-running process.
     */
    protected void longRunningProcess(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
        ((ActivityIndicatorAlertView) alert).hide(true);
    }

}
