package jos.samples.controls.controls;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.foundation.NSAction;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIActivityIndicatorView;
import jos.api.uikit.UIActivityIndicatorViewStyle;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITextAlignment;

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
    String message;

    /**
     * We use this to resize our alert view. doing it at any other time has
     * weird effects because of the lifecycle
     */
    @Override
    public void layoutSubviews() {
        super.layoutSubviews();
        // resize the control
        frame = makeRect(frame.point.x, frame.point.y, frame.size.width, 120);
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
                lblMessage = new UILabel(makeRect(20, 10, rect.size.width - 40,
                        33));
                lblMessage.setBackgroundColor(UIColor.CLEAR);
                lblMessage.setTextColor(UIColor.LIGHT_TEXT_COLOR);
                lblMessage.setTextAlignment(UITextAlignment.CENTER);
                lblMessage.setText(message);
                addSubview(lblMessage);
            }

            // instantiate a new activity indicator
            activityIndicator = new UIActivityIndicatorView(
                    UIActivityIndicatorViewStyle.WHITE);
            activityIndicator.setFrame(makeRect((rect.size.width / 2)
                    - (activityIndicator.getFrame().size.width / 2), 50,
                    activityIndicator.getFrame().size.width,
                    activityIndicator.getFrame().size.height));
            addSubview(activityIndicator);
            activityIndicator.startAnimating();
        }
        super.draw(rect);
    }

    /**
     * Dismisses the alert view. makes sure to call it on the main UI thread in
     * case it's called from a worker thread.
     */
    public void hide(final boolean animated) {
        this.invokeOnMainThread(new NSAction() {
            @Override
            public void action() {
                dismissWithClickedButtonIndex(0, animated);
            }
        });
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
