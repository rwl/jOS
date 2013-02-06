package jos.samples.controls.screens.iphone;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIScrollViewDelegate;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class ScrollView extends UIViewController {

    UIScrollView scrollView;
    UIImageView imageView;

    public ScrollView() {
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
            CGGeometry.CGRectMake(0, 0, this.view.frame.size.width,
                    this.view.frame.size.height - this.navigationController.navigationBar.frame.size.height));
        this.view.addSubview (scrollView);

        // create our image view
        imageView = new UIImageView (UIImage.fromFile ("Images/Icons/512_icon.png"));
        scrollView.contentSize = imageView.image.size;
        scrollView.maximumZoomScale = 3f;
        scrollView.minimumZoomScale = .1f;
        scrollView.addSubview (imageView);

        scrollView.delegate = new UIScrollViewDelegate() {
            @Override
            public UIView viewForZoomingInScrollView(UIScrollView view) {
                return imageView;
            }
        };
    }
}
