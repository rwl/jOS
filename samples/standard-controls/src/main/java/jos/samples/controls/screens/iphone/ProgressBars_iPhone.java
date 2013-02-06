package jos.samples.controls.screens.iphone;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIProgressView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;


public class ProgressBars_iPhone extends UIViewController {

    @Outlet UIProgressView btnProgress1;

    public ProgressBars_iPhone (IntPtr handle) {
        super(handle);
        initialize ();
    }

    @Export(selector="initWithCoder:")
    public ProgressBars_iPhone (NSCoder coder) {
        super(coder);
        initialize ();
    }

    public ProgressBars_iPhone () {
        super("ProgressBars_iPhone", null);
        initialize ();
    }

    void initialize ()
    {
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        this.title = "Progress Bars";

        //UIProgressView progressBar = new UIProgressView(UIProgressViewStyle.Bar);
        //progressBar.progress = .5f;
    }

}
