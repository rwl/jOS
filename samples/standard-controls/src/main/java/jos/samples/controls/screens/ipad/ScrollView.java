package jos.samples.controls.screens.ipad;

import jos.api.uikit.UIColor;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIViewController;

public class ScrollView extends UIViewController {

    UIScrollView scrollView;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        view.setBackgroundColor(UIColor.WHITE);

        scrollView = new UIScrollView(view.getFrame());
        view.addSubview(scrollView);
    }

}
