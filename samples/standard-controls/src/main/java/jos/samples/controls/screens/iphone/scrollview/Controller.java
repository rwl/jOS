package jos.samples.controls.screens.iphone.scrollview;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIViewController;

public class Controller extends UIViewController {

    UIScrollView scrollView;
    UIImageView imageView;

    public Controller() {
        super();
    }

    @Override
    public void viewDidLoad ()
    {
        super.viewDidLoad ();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.white;

        this.title = "Scroll View";

        // create our scroll view
        scrollView = new UIScrollView (
            CGGeometry.CGRectMake(0, 0, this.view.frame.width,
                    this.view.frame.height - this.navigationController.navigationBar.frame.height));
        this.view.addSubview (scrollView);

        // create our image view
        imageView = new UIImageView (UIImage.fromFile ("Images/Icons/512_icon.png"));
        scrollView.contentSize = imageView.image.size;
        scrollView.maximumZoomScale = 3f;
        scrollView.minimumZoomScale = .1f;
        scrollView.addSubview (imageView);

        scrollView.viewForZoomingInScrollView += (UIScrollView sv) => { return imageView; };
    }
}
