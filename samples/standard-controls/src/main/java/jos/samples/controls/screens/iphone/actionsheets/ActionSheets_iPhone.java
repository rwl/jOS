package jos.samples.controls.screens.iphone.actionsheets;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Selector;

import jos.api.foundation.NSCoder;
import jos.api.foundation.NSObject;
import jos.api.system.IntPtr;
import jos.api.uikit.UIActionSheet;
import jos.api.uikit.UIActionSheetDelegate;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;

public class ActionSheets_iPhone extends AbstractActionSheets_iPhone {

    UIActionSheet actionSheet;

    public ActionSheets_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public ActionSheets_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ActionSheets_iPhone() {
        super("ActionSheets_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        title = "Action Sheets";

        btnSimpleActionSheet().addTarget(this,
                new Selector("handleBtnSimpleActionSheetTouchUpInside"),
                UIControlEvent.TouchUpInside);
        btnActionSheetWithOtherButtons().addTarget(
                this,
                new Selector(
                        "handleBtnActionSheetWithOtherButtonsTouchUpInside"),
                UIControlEvent.TouchUpInside);
    }

    protected void handleBtnSimpleActionSheetTouchUpInside(NSObject sender,
            UIEvent e) {
        // create an action sheet using the qualified constructor
        actionSheet = new UIActionSheet("simple action sheet", null, "cancel",
                "delete", null);
        actionSheet.delegate = new UIActionSheetDelegate() {
            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Button " + buttonIndex + " clicked");
            }
        };
        actionSheet.showInView(view);
    }

    protected void handleBtnActionSheetWithOtherButtonsTouchUpInside(
            NSObject sender, UIEvent e) {
        actionSheet = new UIActionSheet("action sheet with other buttons");
        actionSheet.addButton("delete");
        actionSheet.addButton("cancel");
        actionSheet.addButton("a different option!");
        actionSheet.addButton("another option");
        actionSheet.destructiveButtonIndex = 0;
        actionSheet.cancelButtonIndex = 1;
        // actionSheet.firstOtherButtonIndex = 2;
        actionSheet.delegate = new UIActionSheetDelegate() {
            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Button " + buttonIndex + " clicked");
            }
        };
        actionSheet.showInView(view);
    }
}
