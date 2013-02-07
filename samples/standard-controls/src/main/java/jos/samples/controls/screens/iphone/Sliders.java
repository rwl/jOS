package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIImage;
import jos.api.uikit.UISlider;
import jos.api.uikit.UIViewController;

public class Sliders extends UIViewController {

    @Outlet UISlider sldrWithImages;

    public Sliders(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export("initWithCoder:")
    public Sliders(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Sliders() {
        super("Sliders_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "Sliders";

        this.sldrWithImages.setThumbImage(
                UIImage.fromFile("images/icons/29_icon.png"),
                UIControlState.Normal);
    }

}
