package jos.samples.controls.screens.ipad;

import jos.api.uikit.UIColor;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIViewController;

public class ScrollViewController extends UIViewController {

    UIScrollView scrollView;

    public ScrollViewController() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        view.backgroundColor = UIColor.white;

        scrollView = new UIScrollView(view.frame);
        view.addSubview(scrollView);
    }

}
