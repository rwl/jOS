package jos.samples.controls.screens.iphone.buttons;

import jos.api.foundation.NSCoder;
import jos.api.foundation.NSObject;
import jos.api.system.IntPtr;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIButtonType;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class ButtonsScreen_iPhone extends UIViewController {

    @Outlet
    UIButton btnOne;
    @Outlet
    UIButton btnTwo;

    public ButtonsScreen_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public ButtonsScreen_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public ButtonsScreen_iPhone() {
        super("ButtonsScreen_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        this.title = "Buttons";

        this.btnOne.addTarget(this, new Selector("handleBtnOneTouchUpInside"),
                UIControlEvent.TouchUpInside);
        this.btnTwo.addTarget(new EventListener() {

            @Override
            public void onEvent(Object object, int event) {
                new UIAlertView("button two click!", "TouchUpInside Handled",
                        null, "OK", null).show();
            }
        }, UIControlEvent.TouchUpInside);

        UIButton button = UIButton.fromType(UIButtonType.RoundedRect);
        button.setTitle("My Button", UIControlState.Normal);
    }

    protected void handleBtnOneTouchUpInside(NSObject sender, UIEvent e) {
        new UIAlertView("button one click!", "TouchUpInside Handled", null,
                "OK", null).show();
    }

}
