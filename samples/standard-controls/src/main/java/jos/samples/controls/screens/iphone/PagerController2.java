package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class PagerController2 extends UIViewController {

    UILabel lblMain;

    public PagerController2() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        view.setBackgroundColor(UIColor.LIGHT_GRAY);

        lblMain = new UILabel(makeRect(20, 200, 280, 33));
        lblMain.setText("Controller 2");
        lblMain.setBackgroundColor(UIColor.CLEAR);
        view.addSubview(lblMain);
    }

}
