package jos.samples.controls.screens.iphone.alertviews;

import com.google.j2objc.annotations.Export;

import jos.api.uikit.UIViewController;

public class AlertViewsScreen_iPhone extends UIViewController {

    /**
     * This is here to keep a reference to an alert after the method that creates it
     * completes. unlike in windows, the .show() method is not blocking (with thread
     * magic that still keeps the UI unblocked), so after show() returns, the method
     * will complete and the reference to the alert (and more importantly, the alert
     * delegate will get garbage collected).
     */
    UIAlertView alert;

    public AlertViewsScreen_iPhone (IntPtr handle) {
        super(handle);
        initialize ();
    }

    @Export(selector = "initWithCoder:")
    public AlertViewsScreen_iPhone (NSCoder coder) {
        super(coder);
        initialize ();
    }

    public AlertViewsScreen_iPhone () {
        super("AlertViewsScreen_iPhone", null);
        initialize ();
    }

    void initialize ()
    {
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        title = "Alert Views";

        btnSimpleAlert.touchUpInside += handleBtnSimpleAlertTouchUpInside;
        btnCustomButtons.touchUpInside += handleBtnCustomButtonsTouchUpInside;
        btnCustomButtonsWithDelegate.touchUpInside += handleBtnCustomButtonsWithDelegateTouchUpInside;
        btnCustomAlert.touchUpInside += handleBtnCustomAlertTouchUpInside;
    }

    /**
     * Runs when the simple alert button is clicked. launches a very simple alert
     * that presents an "OK" button, does not use a delegate
     */
    protected void handleBtnSimpleAlertTouchUpInside (Object sender, EventArgs e)
    {
        alert = new UIAlertView ("alert title", "this is a simple alert.", null
          , "OK", null);
        alert.show();
    }

    protected void handleBtnCustomButtonsTouchUpInside (Object sender, EventArgs e)
    {
        alert = new UIAlertView ("custom buttons alert", "this alert has custom buttons"
          , null, "ok", new String[] { "custom button 1", "custom button 2" });

        // wire up a handler for the click event
        alert.clicked += delegate(object a, UIButtonEventArgs b) {
            System.out.println("Button " + b.buttonIndex.toString () + " clicked"); };
        alert.show ();
    }

    /**
     * Runs when the Custom Buttons alert button is clicked. launches an alert with
     * additional buttons added
     */
    protected void handleBtnCustomButtonsWithDelegateTouchUpInside (Object sender, EventArgs e)
    {
        String[] otherButtons = new String[] { "custom button 1", "custom button 2" };

        alert = new UIAlertView ("custom buttons alert", "this alert has custom buttons",
                     new CustomButtonsAlertDelegate (), "ok", otherButtons);
        alert.show ();
    }

    /**
     * This is our custom buttons alert delegate.
     */
    protected class CustomButtonsAlertDelegate extends UIAlertViewDelegate
    {
        public CustomButtonsAlertDelegate () {
            super();
        }

        @Override
        public void canceled (UIAlertView alertView)
        {
            System.out.println("Alert Cancelled");
        }

        /**
         * Runs when any of the custom buttons on the alert are clicked
         */
        @Override
        public void Clicked (UIAlertView alertview, int buttonIndex)
        {
            System.out.println("Button " + buttonIndex + " clicked");
        }

        /**
         * Runs right after clicked, and before Dismissed
         */
        @Override
        public void willDismiss (UIAlertView alertView, int buttonIndex)
        {
            System.out.println("Alert will dismiss, button " + buttonIndex);
        }

        /**
         * Runs after Clicked
         */
        @Override
        public void dismissed (UIAlertView alertView, int buttonIndex)
        {
            System.out.println("Alert Dismissed, button " + buttonIndex);
        }
    }

    /**
     * Runs when the custom alert button is pressed. shows the alert and then
     * kicks off a secondary thread that spins for 5 seconds and then closes
     * the alert.
     */
    protected void handleBtnCustomAlertTouchUpInside (Object sender, EventArgs e)
    {
        alert = new ActivityIndicatorAlertView ();
        ((ActivityIndicatorAlertView) alert).message = "performing stuff";
        alert.show ();

        Thread longRunningProc = new Thread (new Runnable() {

            @Override
            public void run() {
                longRunningProcess (5);
            }
        });
        longRunningProc.start ();
    }

    /**
     * Spins a thread for the specified amount of time and then closes the
     * custom alert. used to simulate a long-running process.
     */
    protected void longRunningProcess (int seconds)
    {
        Thread.sleep (seconds * 1000);
        ((ActivityIndicatorAlertView) alert).hide (true);
    }
}
