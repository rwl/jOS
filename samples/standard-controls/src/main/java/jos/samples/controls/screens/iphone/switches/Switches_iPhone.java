package jos.samples.controls.screens.iphone.switches;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIControlEvent;

public class Switches_iPhone extends AbstractSwitches_iPhone {

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


        this.swchOne().addTarget(new EventListener() {

            @Override
            public void onEvent(Object object, int event) {
                new UIAlertView("Switch one change!", "is on: " + swchOne().on, null, "OK", null).show();
            }
        }, UIControlEvent.ValueChanged);

        this.swchTwo().addTarget(new EventListener() {

            @Override
            public void onEvent(Object object, int event) {
                new UIAlertView("Switch two change!", "is on: " + swchTwo().on, null, "OK", null).show();
            }
        }, UIControlEvent.ValueChanged);
    }
}
