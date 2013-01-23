package jos.samples.controls.screens.iphone.buttons;

import com.google.j2objc.annotations.Export;

import jos.api.uikit.UIViewController;

public class ButtonsScreen_iPhone extends UIViewController {

    public ButtonsScreen_iPhone (IntPtr handle) {
        super(handle);
        initialize ();
    }

    @Export(selector="initWithCoder:")
    public ButtonsScreen_iPhone (NSCoder coder) {
        super(coder);
        initialize ();
    }

    public ButtonsScreen_iPhone () {
        super("ButtonsScreen_iPhone", null);
        initialize ();
    }

    void initialize ()
    {
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();
        this.title = "Buttons";

        this.btnOne.touchUpInside += handleBtnOneTouchUpInside;
        this.btnTwo.touchUpInside += delegate {
            new UIAlertView ("button two click!", "TouchUpInside Handled", null, "OK", null).Show ();
        };

        UIButton button = UIButton.FromType (UIButtonType.RoundedRect);
        button.SetTitle ("My Button", UIControlState.Normal);
    }

    protected void HandleBtnOneTouchUpInside (object sender, EventArgs e)
    {
        new UIAlertView ("button one click!", "TouchUpInside Handled", null, "OK", null).show();
    }
}
