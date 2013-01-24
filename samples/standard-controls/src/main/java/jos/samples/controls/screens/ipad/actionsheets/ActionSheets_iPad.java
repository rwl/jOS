package jos.samples.controls.screens.ipad.actionsheets;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIActionSheet;
import jos.api.uikit.UIActionSheetDelegate;
import jos.api.uikit.UIControlEvent;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Selector;

public class ActionSheets_iPad extends AbstractActionSheets_iPad {

    UIActionSheet actionSheet;

    public ActionSheets_iPad(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public ActionSheets_iPad(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ActionSheets_iPad() {
        super("ActionSheets_iPad", null);
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

    protected void handleBtnSimpleActionSheetTouchUpInside() {
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

    protected void handleBtnActionSheetWithOtherButtonsTouchUpInside() {
        actionSheet = new UIActionSheet("action sheet with other buttons");
        actionSheet.addButton("delete");
        actionSheet.addButton("a different option!");
        actionSheet.addButton("another option");
        actionSheet.destructiveButtonIndex = 0;
        actionSheet.delegate = new UIActionSheetDelegate() {

            @Override
            public void onClick(UIActionSheet sheet, int buttonIndex) {
                System.out.println("Button " + buttonIndex + " clicked");
            };
        };
        actionSheet.showInView(view);
    }
}
