package jos.samples.controls.controls;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;

public class ActivityIndicatorAlertView extends UIAlertView {

    /**
     * Our activity indicator
     */
    UIActivityIndicatorView activityIndicator;

    /**
     * The message label in the window
     */
    UILabel lblMessage;

    /**
     * The message that appears in the alert above the activity indicator
     */
    public String message;

    public ActivityIndicatorAlertView(IntPtr handle) {
        super(handle);
    }

    @Export(selector = "initWithCoder:")
    public ActivityIndicatorAlertView(NSCoder coder) {
        super(coder);
    }

    public ActivityIndicatorAlertView() {
    }

    /**
     * We use this to resize our alert view. doing it at any other time has
     * weird effects because of the lifecycle
     */
    @Override
    public void layoutSubviews() {
        super.layoutSubviews();
        // resize the control
        this.frame = CGGeometry.CGRectMake(this.frame.x, this.frame.y,
                this.frame.width, 120);
    }

    /**
     * This is where we do the meat of creating our alert, which includes adding
     * controls, etc.
     */
    @Override
    public void draw(CGRect rect) {
        // if the control hasn't been setup yet
        if (activityIndicator == null) {
            // if we have a message
            if (message != null || !message.isEmpty()) {
                lblMessage = new UILabel(CGGeometry.CGRectMake(20, 10,
                        rect.width - 40, 33));
                lblMessage.backgroundColor = UIColor.clear;
                lblMessage.textColor = UIColor.lightTextColor;
                lblMessage.textAlignment = UITextAlignment.Center;
                lblMessage.text = message;
                this.addSubview(lblMessage);
            }

            // instantiate a new activity indicator
            activityIndicator = new UIActivityIndicatorView(
                    UIActivityIndicatorViewStyle.white);
            activityIndicator.frame = CGGeometry.CGRectMake((rect.width / 2)
                    - (activityIndicator.frame.width / 2), 50,
                    activityIndicator.frame.width,
                    activityIndicator.frame.height);
            this.addSubview(activityIndicator);
            activityIndicator.startAnimating();
        }
        super.draw(rect);
    }

    /**
     * Dismisses the alert view. makes sure to call it on the main UI thread in
     * case it's called from a worker thread.
     */
    public void hide (boolean animated) {
        this.invokeOnMainThread (delegate {
            this.dismissWithClickedButtonIndex(0, animated);
        });
    }
}
