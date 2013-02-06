package jos.samples.controls.screens.iphone.sliders;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIImage;
import jos.api.uikit.UISlider;
import jos.api.uikit.UIViewController;

public class Sliders_iPhone extends UIViewController {

    @Outlet UISlider sldrWithImages;

    public Sliders_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public Sliders_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Sliders_iPhone() {
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
