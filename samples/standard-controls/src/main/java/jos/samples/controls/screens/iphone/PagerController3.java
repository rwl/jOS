package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class PagerController3 extends UIViewController {

    UILabel lblMain;

    public PagerController3() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        getView().setBackgroundColor(new UIColor(.5f, .5f, 1, 1));

        lblMain = new UILabel(makeRect(20, 200, 280, 33));
        lblMain.setText("Controller 3");
        lblMain.setBackgroundColor(UIColor.CLEAR);
        getView().addSubview(lblMain);
    }

}
