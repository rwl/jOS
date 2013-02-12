package jos.samples.controls.screens.ipad;

import jos.api.uikit.UIColor;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIViewController;

public class IPadScrollView extends UIViewController {

    UIScrollView scrollView;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        getView().setBackgroundColor(UIColor.WHITE);

        scrollView = new UIScrollView(getView().getFrame());
        getView().addSubview(scrollView);
    }

}
