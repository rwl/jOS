package jos.samples.controls.screens.ipad.actionsheets;

import com.google.j2objc.annotations.Export;

import jos.api.uikit.UIViewController;

public class ActionSheets_iPad extends UIViewController {

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

        btnSimpleActionSheet.touchUpInside += handleBtnSimpleActionSheetTouchUpInside;
        btnActionSheetWithOtherButtons.touchUpInside += handleBtnActionSheetWithOtherButtonsTouchUpInside;
    }

    protected void HandleBtnSimpleActionSheetTouchUpInside (Object sender, EventArgs e)
    {
        // create an action sheet using the qualified constructor
        actionSheet = new UIActionSheet ("simple action sheet", null, "cancel", "delete", null);
        actionSheet.Clicked += delegate(Object a, UIButtonEventArgs b) {
            System.out.println("Button " + b.buttonIndex + " clicked");
        };
        actionSheet.showInView(view);
    }

    protected void HandleBtnActionSheetWithOtherButtonsTouchUpInside (object sender, EventArgs e)
    {
        actionSheet = new UIActionSheet("action sheet with other buttons");
        actionSheet.addButton("delete");
        actionSheet.addButton("a different option!");
        actionSheet.addButton("another option");
        actionSheet.destructiveButtonIndex = 0;
        actionSheet.clicked += delegate(Object a, UIButtonEventArgs b) {
            System.out.println("Button " + b.buttonIndex + " clicked");
        };
        actionSheet.showInView(view);
    }
}
