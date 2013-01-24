package jos.samples.controls.screens.iphone.taptozoomscrollview;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIViewController;
import jos.samples.controls.controls.TapZoomScrollView;

public class Controller extends UIViewController {

    TapZoomScrollView scrollView;
    UIImageView imageView;

    public Controller() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad ();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.white;

        // create our scroll view
        scrollView = new TapZoomScrollView(CGGeometry.CGRectMake(0, 0, this.view.frame.width,
                this.view.frame.height - this.navigationController.navigationBar.frame.height));
        this.view.addSubview(scrollView);

        // create our image view
        imageView = new UIImageView(UIImage.fromFile ("Images/Icons/512_icon.png"));
        scrollView.contentSize = imageView.image.size;
        scrollView.maximumZoomScale = 3f;
        scrollView.minimumZoomScale = .1f;
        scrollView.addSubview (imageView);

        // when the scroll view wants to zoom, it asks for the view to zoom, so
        // in this case, we tell it that we want it to zoom the image view
        scrollView.viewForZoomingInScrollView += delegate(UIScrollView sv) {
            return imageView;
        };
    }
}
