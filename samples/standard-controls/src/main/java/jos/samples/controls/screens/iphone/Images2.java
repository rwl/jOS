package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.graphicsimaging.CGGeometry;
import jos.api.system.IntPtr;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIViewController;

public class Images2 extends UIViewController {

    UIImageView imageView1;
    UIImageView imgSpinningCircle;

    public Images2(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public Images2(NSCoder coder) {
        super(coder);
        initialize();
    }

    public Images2() {
        super("Images2_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        title = "Images";

        // a simple image
        imageView1 = new UIImageView(
                UIImage.fromBundle("Images/Icons/50_icon.png"));
        imageView1.frame = CGGeometry
                .CGRectMake(20, 20, imageView1.image.CGImage.width,
                        imageView1.image.CGImage.height);
        view.addSubview(imageView1);

        // an animating image
        imgSpinningCircle = new UIImageView();
        imgSpinningCircle.animationImages = new UIImage[] {
                UIImage.fromBundle("Images/Spinning Circle_1.png"),
                UIImage.fromBundle("Images/Spinning Circle_2.png"),
                UIImage.fromBundle("Images/Spinning Circle_3.png"),
                UIImage.fromBundle("Images/Spinning Circle_4.png") };
        imgSpinningCircle.animationRepeatCount = 0;
        imgSpinningCircle.animationDuration = .5;
        imgSpinningCircle.frame = CGGeometry.CGRectMake(150, 20, 100, 100);
        view.addSubview(imgSpinningCircle);
        imgSpinningCircle.startAnimating();
    }

}
