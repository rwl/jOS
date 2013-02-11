package jos.samples.controls.screens.iphone;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIActionSheet;
import jos.api.uikit.UIActionSheetDelegate;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class ActionSheets extends UIViewController {

    @Outlet
    UIView view;

    @Outlet
    UIButton btnSimpleActionSheet;

    @Outlet
    UIButton btnActionSheetWithOtherButtons;

    UIActionSheet actionSheet;

    public ActionSheets() {
        super("ActionSheets_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Action Sheets");

        btnSimpleActionSheet.addTarget(this, new Selector(
                "handleBtnSimpleActionSheetTouchUpInside"),
                UIControlEvent.TOUCH_UP_INSIDE);
        btnActionSheetWithOtherButtons.addTarget(this, new Selector(
                "handleBtnActionSheetWithOtherButtonsTouchUpInside"),
                UIControlEvent.TOUCH_UP_INSIDE);
    }

    protected void handleBtnSimpleActionSheetTouchUpInside() {
        // create an action sheet using the qualified constructor
        actionSheet = new UIActionSheet("simple action sheet", null, "cancel",
                "delete");
        actionSheet.setDelegate(new UIActionSheetDelegate() {
            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Button " + buttonIndex + " clicked");
            }
        });
        actionSheet.showInView(view);
    }

    protected void handleBtnActionSheetWithOtherButtonsTouchUpInside() {
        actionSheet = new UIActionSheet("action sheet with other buttons",
                null, "", "");
        actionSheet.addButton("delete");
        actionSheet.addButton("cancel");
        actionSheet.addButton("a different option!");
        actionSheet.addButton("another option");
        actionSheet.setDestructiveButtonIndex(0);
        actionSheet.setCancelButtonIndex(1);
        // actionSheet.setFirstOtherButtonIndex(2);
        actionSheet.setDelegate(new UIActionSheetDelegate() {
            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Button " + buttonIndex + " clicked");
            }
        });
        actionSheet.showInView(view);
    }

}
