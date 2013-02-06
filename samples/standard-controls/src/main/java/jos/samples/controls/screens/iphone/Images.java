package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIViewController;

public class Images extends UIViewController {

    @Outlet UIImageView imgMain;

    public Images(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public Images(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Images() {
        super("Images_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "Images";
    }

}
