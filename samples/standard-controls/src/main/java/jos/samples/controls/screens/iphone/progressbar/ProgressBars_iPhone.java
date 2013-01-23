package jos.samples.controls.screens.iphone.progressbar;

import com.google.j2objc.annotations.Export;

import jos.api.uikit.UIViewController;

public class ProgressBars_iPhone extends UIViewController {

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

        //UIProgressView progressBar = new UIProgressView (UIProgressViewStyle.Bar);
        //progressBar.progress = .5f;
    }
}
