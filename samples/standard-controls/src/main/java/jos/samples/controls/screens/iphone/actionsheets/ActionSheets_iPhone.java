package jos.samples.controls.screens.iphone.actionsheets;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class ActionSheets_iPhone extends UIViewController {

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

        btnSimpleActionSheet.touchUpInside += handleBtnSimpleActionSheetTouchUpInside;
        btnActionSheetWithOtherButtons.touchUpInside += handleBtnActionSheetWithOtherButtonsTouchUpInside;
    }

    protected void handleBtnSimpleActionSheetTouchUpInside (Object sender, EventArgs e)
    {
        // create an action sheet using the qualified constructor
        actionSheet = new UIActionSheet ("simple action sheet", null, "cancel", "delete", null);
        actionSheet.clicked += delegate(object a, UIButtonEventArgs b) {
            System.out.println("Button " + b.buttonIndex.toString () + " clicked");
        };
        actionSheet.showInView (view);
    }

    protected void handleBtnActionSheetWithOtherButtonsTouchUpInside (Object sender, EventArgs e)
    {
        actionSheet = new UIActionSheet ("action sheet with other buttons");
        actionSheet.addButton ("delete");
        actionSheet.addButton ("cancel");
        actionSheet.addButton ("a different option!");
        actionSheet.addButton ("another option");
        actionSheet.destructiveButtonIndex = 0;
        actionSheet.cancelButtonIndex = 1;
        //actionSheet.FirstOtherButtonIndex = 2;
        actionSheet.clicked += delegate(Object a, UIButtonEventArgs b) {
            System.out.println("Button " + b.buttonIndex.toString () + " clicked");
        };
        actionSheet.showInView (view);

    }
}
