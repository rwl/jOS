package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIImage;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIScrollViewDelegate;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;
import jos.samples.controls.controls.TapZoomScrollView;

import com.google.j2objc.annotations.Outlet;

public class TapToZoom extends UIViewController {

    @Outlet
    UIView view;

    TapZoomScrollView scrollView;

    UIImageView imageView;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        view.setBackgroundColor(UIColor.WHITE);

        // create our scroll view
        scrollView = new TapZoomScrollView(
                makeRect(0, 0, view.getFrame().size.width,
                        view.getFrame().size.height
                                - getNavigationController().getNavigationBar()
                                        .getFrame().size.height));
        view.addSubview(scrollView);

        // create our image view
        imageView = new UIImageView(
                UIImage.fromFile("images/icons/512_icon.png"));
        scrollView.setContentSize(imageView.getImage().getSize());
        scrollView.setMaximumZoomScale(3f);
        scrollView.setMinimumZoomScale(.1f);
        scrollView.addSubview(imageView);

        // when the scroll view wants to zoom, it asks for the view to zoom, so
        // in this case, we tell it that we want it to zoom the image view
        scrollView.setDelegate(new UIScrollViewDelegate() {
            @Override
            public UIView viewForZoomingInScrollView(UIScrollView view) {
                return imageView;
            }
        });
    }

}
