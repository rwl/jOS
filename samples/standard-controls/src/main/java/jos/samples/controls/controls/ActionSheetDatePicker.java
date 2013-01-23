package jos.samples.controls.controls;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Register;

/**
 * A class to show a date picker on an action sheet. To use, create a new
 * ActionSheetDatePicker, set the Title, modify any settings on the DatePicker
 * property, and call Show(). It will automatically dismiss when the user clicks
 * "Done," or you can call Hide() to dismiss it manually.
 */
@Register(name = "SlideOnDatePicker")
public class ActionSheetDatePicker {

    UIActionSheet actionSheet;
    UIButton doneButton = UIButton.fromType(UIButtonType.RoundedRect);
    UIView owner;
    UILabel titleLabel = new UILabel();

    /**
     * Set any datepicker properties here
     */
    public UIDatePicker datePicker = new UIDatePicker(RectangleF.Empty);

    /**
     * The title that shows up for the date picker
     */
    public String title() {
        return titleLabel.Text;
    }

    public void title(String value) {
        titleLabel.text = value;
    }

    public ActionSheetDatePicker (UIView owner)
    {
        // save our uiview owner
        this.owner = owner;

        // configure the title label
        titleLabel.backgroundColor = UIColor.clear;
        titleLabel.textColor = UIColor.lightTextColor;
        titleLabel.font = UIFont.boldSystemFontOfSize(18);

        // configure the done button
        doneButton.setTitle("done", UIControlState.Normal);
        doneButton.touchUpInside += (s, e) => {
            actionSheet.dismissWithClickedButtonIndex(0, true);
        };

        // create + configure the action sheet
        actionSheet = new UIActionSheet ();
        actionSheet.style = UIActionSheetStyle.BlackTranslucent;
        actionSheet.clicked += (s, e) => {
            System.out.println("Clicked on item " + e.buttonIndex);
        };

        // add our controls to the action sheet
        actionSheet.addSubview (datePicker);
        actionSheet.addSubview (titleLabel);
        actionSheet.addSubview (doneButton);
    }

    /**
     * Shows the action sheet picker from the view that was set as the owner.
     */
    public void show() {
        // declare vars
        float titleBarHeight = 40;
        SizeF doneButtonSize = new SizeF(71, 30);
        SizeF actionSheetSize = new SizeF(owner.frame.width,
                datePicker.frame.height + titleBarHeight);
        CGRect actionSheetFrame = CGGeometry.CGRectMake(0, owner.frame.height
                - actionSheetSize.height, actionSheetSize.width,
                actionSheetSize.height);

        // show the action sheet and add the controls to it
        actionSheet.showInView(owner);

        // resize the action sheet to fit our other stuff
        actionSheet.frame = actionSheetFrame;

        // move our picker to be at the bottom of the actionsheet (view coords
        // are relative to the action sheet)
        datePicker.frame = CGGeometry
                .CGRectMake(datePicker.frame.x, titleBarHeight,
                        datePicker.frame.width, datePicker.frame.height);

        // move our label to the top of the action sheet
        titleLabel.frame = CGGeometry.CGRectMake(10, 4,
                owner.frame.width - 100, 35);

        // move our button
        doneButton.frame = CGGeometry.CGRectMake(actionSheetSize.Width
                - doneButtonSize.Width - 10, 7, doneButtonSize.Width,
                doneButtonSize.Height);
    }

    /**
     * Dismisses the action sheet date picker
     */
    public void hide(boolean animated) {
        actionSheet.dismissWithClickedButtonIndex(0, animated);
    }
}
