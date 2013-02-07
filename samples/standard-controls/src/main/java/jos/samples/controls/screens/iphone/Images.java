package jos.samples.controls.screens.iphone;

import jos.api.uikit.UIImageView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;

public class Images extends UIViewController {

    @Outlet
    UIImageView imgMain;

    public Images() {
        super("Images_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Images");
    }

}
