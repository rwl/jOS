package jos.samples.controls.screens.iphone.toolbar;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

public class Toolbar1_iPhone extends UIViewController {

    @Outlet UIBarButtonItem btnOne;
    @Outlet UIBarButtonItem btnTwo;
    @Outlet UIBarButtonItem btnThree;
    @Outlet UIBarButtonItem btnFour;

    public Toolbar1_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public Toolbar1_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Toolbar1_iPhone() {
        super("Toolbar1_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad()
    {
        super.viewDidLoad();

        this.title = "Toolbar";

        this.btnOne.target = this;
        this.btnOne.action = new Selector("handleButtonClick");
    }

    protected void handleButtonClick() {
        new UIAlertView("click!", "btnOne clicked", null, "OK", null).show();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        return true;
    }

}
