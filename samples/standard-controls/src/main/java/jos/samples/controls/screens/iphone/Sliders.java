package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIControlState;
import jos.api.uikit.UIImage;
import jos.api.uikit.UISlider;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class Sliders extends UIViewController {

    @Outlet
    UISlider sldrWithImages;

    public Sliders() {
        super("Sliders_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Sliders");

        sldrWithImages.setThumbImage(
                UIImage.fromBundle("icon-29.png"),
                UIControlState.NORMAL);
    }

}
