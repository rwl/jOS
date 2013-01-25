package jos.samples.controls.controls;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UIActionSheet;
import jos.api.uikit.UIActionSheetDelegate;
import jos.api.uikit.UIActionSheetStyle;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIButtonType;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIDatePicker;
import jos.api.uikit.UIFont;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;

import com.google.j2objc.annotations.EventListener;
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
    public UIDatePicker datePicker = new UIDatePicker(CGGeometry.CGRectMake(0, 0, 0, 0));

    /**
     * The title that shows up for the date picker
     */
    public String title() {
        return titleLabel.text;
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
        doneButton.addTarget(new EventListener() {

            @Override
            public void onEvent(Object object, int event) {
                actionSheet.dismissWithClickedButtonIndex(0, true);
            }
        }, UIControlEvent.TouchUpInside);

        // create + configure the action sheet
        actionSheet = new UIActionSheet ();
        actionSheet.style = UIActionSheetStyle.BlackTranslucent;
        actionSheet.delegate = new UIActionSheetDelegate() {
            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Clicked on item " + buttonIndex);
            }
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
        CGSize doneButtonSize = new CGSize(71, 30);
        CGSize actionSheetSize = new CGSize(owner.frame.size.width,
                datePicker.frame.size.height + titleBarHeight);
        CGRect actionSheetFrame = CGGeometry.CGRectMake(0, owner.frame.size.height
                - actionSheetSize.height, actionSheetSize.width,
                actionSheetSize.height);

        // show the action sheet and add the controls to it
        actionSheet.showInView(owner);

        // resize the action sheet to fit our other stuff
        actionSheet.frame = actionSheetFrame;

        // move our picker to be at the bottom of the actionsheet (view coords
        // are relative to the action sheet)
        datePicker.frame = CGGeometry
                .CGRectMake(datePicker.frame.point.x, titleBarHeight,
                        datePicker.frame.size.width, datePicker.frame.size.height);

        // move our label to the top of the action sheet
        titleLabel.frame = CGGeometry.CGRectMake(10, 4,
                owner.frame.size.width - 100, 35);

        // move our button
        doneButton.frame = CGGeometry.CGRectMake(actionSheetSize.width
                - doneButtonSize.width - 10, 7, doneButtonSize.width,
                doneButtonSize.height);
    }

    /**
     * Dismisses the action sheet date picker
     */
    public void hide(boolean animated) {
        actionSheet.dismissWithClickedButtonIndex(0, animated);
    }
}
