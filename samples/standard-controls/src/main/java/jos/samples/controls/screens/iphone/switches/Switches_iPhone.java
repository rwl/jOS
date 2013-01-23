package jos.samples.controls.screens.iphone.switches;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIViewController;

public class Switches_iPhone extends UIViewController {

    public Switches_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public Switches_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Switches_iPhone() {
        super("Switches_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        this.title = "Switches";


        this.swchOne.valueChanged += delegate {
            new UIAlertView("Switch one change!", "is on: " + this.swchOne.on.toString(), null, "OK", null).show();
        };
        this.swchTwo.valueChanged += delegate {
            new UIAlertView("Switch two change!", "is on: " + this.swchTwo.on.toString(), null, "OK", null).show();
        };
    }
}
