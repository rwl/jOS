package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIViewController;

public class Images2 extends UIViewController {

    UIImageView imageView1;

    UIImageView imgSpinningCircle;

    public Images2() {
        super("Images2_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Images");

        // a simple image
        imageView1 = new UIImageView(
                UIImage.fromBundle("icon-50.png"));
// FIXME: CGImage pointer error
//        imageView1.setFrame(makeRect(20, 20,
//                imageView1.getImage().CGImage.width, imageView1.getImage()
//                        .CGImage.height));
        imageView1.setFrame(makeRect(20, 20, 50, 50));
        getView().addSubview(imageView1);

        // an animating image
        imgSpinningCircle = new UIImageView();
//        imgSpinningCircle.setAnimationImages(new UIImage[] {  FIXME: animated image
//                UIImage.fromBundle("Spinning Circle_1.png"),
//                UIImage.fromBundle("Spinning Circle_2.png"),
//                UIImage.fromBundle("Spinning Circle_3.png"),
//                UIImage.fromBundle("Spinning Circle_4.png") });
//        imgSpinningCircle.setAnimationRepeatCount(0);
//        imgSpinningCircle.setAnimationDuration(.5);
        imgSpinningCircle.setFrame(makeRect(150, 20, 100, 100));
        getView().addSubview(imgSpinningCircle);
//        imgSpinningCircle.startAnimating();
    }

}
