package jos.samples.controls.screens.iphone.images;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;

public class Images_iPhone extends AbstractImages_iPhone {

    public Images_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public Images_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Images_iPhone() {
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
