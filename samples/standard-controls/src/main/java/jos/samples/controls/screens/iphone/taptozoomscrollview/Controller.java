package jos.samples.controls.screens.iphone.taptozoomscrollview;

import static jos.api.graphicsimaging.CGGeometry.CGRectMake;

import jos.api.uikit.UIColor;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIScrollViewDelegate;
import jos.api.uikit.UIView;
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
        super.viewDidLoad();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.white;

        // create our scroll view
        scrollView = new TapZoomScrollView(
                CGRectMake(
                        0,
                        0,
                        this.view.frame.size.width,
                        this.view.frame.size.height
                                - this.navigationController.navigationBar.frame.size.height));
        this.view.addSubview(scrollView);

        // create our image view
        imageView = new UIImageView(
                UIImage.fromFile("Images/Icons/512_icon.png"));
        scrollView.contentSize = imageView.image.size;
        scrollView.maximumZoomScale = 3f;
        scrollView.minimumZoomScale = .1f;
        scrollView.addSubview(imageView);

        // when the scroll view wants to zoom, it asks for the view to zoom, so
        // in this case, we tell it that we want it to zoom the image view
        scrollView.delegate = new UIScrollViewDelegate() {
            @Override
            public UIView viewForZoomingInScrollView(UIScrollView view) {
                return imageView;
            }
        };
    }
}
