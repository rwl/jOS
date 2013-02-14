package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
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

    UIScrollViewDelegate delegate = new UIScrollViewDelegate() {
        @Override
        public UIView viewForZoomingInScrollView(UIScrollView view) {
            return imageView;
        }
    };

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        getView().setBackgroundColor(UIColor.WHITE);

        setTitle("Scroll View");

        // create our scroll view
        scrollView = new UIScrollView(makeRect(0, 0,
        		getView().getFrame().size.width, getView().getFrame().size.height
                        - getNavigationController().getNavigationBar()
                                .getFrame().size.height));
        getView().addSubview(scrollView);

        // create our image view
        imageView = new UIImageView(
                UIImage.fromBundle("icon-512.png"));
        scrollView.setContentSize(imageView.getImage().size);
        scrollView.setMaximumZoomScale(3f);
        scrollView.setMinimumZoomScale(.1f);
        scrollView.addSubview(imageView);

        scrollView.setDelegate(delegate);
    }

}
