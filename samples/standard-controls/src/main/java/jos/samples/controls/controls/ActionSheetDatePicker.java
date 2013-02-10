package jos.samples.controls.controls;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import static jos.api.graphicsimaging.CGGeometry.makeSize;

import com.google.j2objc.annotations.Selector;

import jos.api.foundation.NSObject;
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

/**
 * A class to show a date picker on an action sheet. To use, create a new
 * ActionSheetDatePicker, set the title, modify any settings on the DatePicker
 * property, and call show(). It will automatically dismiss when the user clicks
 * "Done," or you can call Hide() to dismiss it manually.
 */
public class ActionSheetDatePicker extends NSObject {

    UIActionSheet actionSheet;

    final UIButton doneButton = UIButton.fromType(UIButtonType.ROUNDED_RECT);

    UIView owner;

    final UILabel titleLabel = new UILabel();

    /**
     * Set any datepicker properties here
     */
    final UIDatePicker datePicker = new UIDatePicker(makeRect(0, 0, 0, 0));

    public ActionSheetDatePicker(UIView owner) {
        // save our uiview owner
        this.owner = owner;

        // configure the title label
        titleLabel.setBackgroundColor(UIColor.CLEAR);
        titleLabel.setTextColor(UIColor.LIGHT_TEXT_COLOR);
        titleLabel.setFont(UIFont.boldSystemFontOfSize(18));

        // configure the done button
        doneButton.setTitle("done", UIControlState.NORMAL);
        /*doneButton.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject object, UIEvent event) {
                actionSheet.dismissWithClickedButtonIndex(0, true);
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);*/
        doneButton.addTarget(this, new Selector("onDone"),
                UIControlEvent.TOUCH_UP_INSIDE);

        // create + configure the action sheet
        actionSheet = new UIActionSheet("", null, "", "");
        actionSheet.setStyle(UIActionSheetStyle.BLACK_TRANSLUCENT);
        actionSheet.setDelegate(new UIActionSheetDelegate() {
            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Clicked on item " + buttonIndex);
            }
        });

        // add our controls to the action sheet
        actionSheet.addSubview(datePicker);
        actionSheet.addSubview(titleLabel);
        actionSheet.addSubview(doneButton);
    }

    protected void onDone() {
        actionSheet.dismissWithClickedButtonIndex(0, true);
    }

    /**
     * Shows the action sheet picker from the view that was set as the owner.
     */
    public void show() {
        // declare vars
        float titleBarHeight = 40;
        CGSize doneButtonSize = makeSize(71, 30);
        CGSize actionSheetSize = makeSize(owner.getFrame().size.width,
                datePicker.getFrame().size.height + titleBarHeight);
        CGRect actionSheetFrame = makeRect(0, owner.getFrame().size.height
                - actionSheetSize.height, actionSheetSize.width,
                actionSheetSize.height);

        // show the action sheet and add the controls to it
        actionSheet.showInView(owner);

        // resize the action sheet to fit our other stuff
        actionSheet.setFrame(actionSheetFrame);

        // move our picker to be at the bottom of the actionsheet (view coords
        // are relative to the action sheet)
        datePicker.setFrame(makeRect(datePicker.getFrame().point.x,
                titleBarHeight, datePicker.getFrame().size.width,
                datePicker.getFrame().size.height));

        // move our label to the top of the action sheet
        titleLabel.setFrame(makeRect(10, 4, owner.frame.size.width - 100, 35));

        // move our button
        doneButton.setFrame(makeRect(actionSheetSize.width
                - doneButtonSize.width - 10, 7, doneButtonSize.width,
                doneButtonSize.height));
    }

    /**
     * Dismisses the action sheet date picker
     */
    public void hide(boolean animated) {
        actionSheet.dismissWithClickedButtonIndex(0, animated);
    }

    /**
     * The title that shows up for the date picker
     */
    public String getTitle() {
        return titleLabel.text;
    }

    public void setTitle(String value) {
        titleLabel.text = value;
    }

    public UIDatePicker getDatePicker() {
        return datePicker;
    }

}
