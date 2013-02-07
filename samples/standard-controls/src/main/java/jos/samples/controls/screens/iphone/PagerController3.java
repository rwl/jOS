package jos.samples.controls.screens.iphone;

import jos.api.graphicsimaging.CGGeometry;
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
        this.view.backgroundColor = new UIColor(.5f, .5f, 1, 1);

        lblMain = new UILabel(CGGeometry.makeRect(20, 200, 280, 33));
        lblMain.text = "Controller 3";
        lblMain.backgroundColor = UIColor.CLEAR;
        this.view.addSubview(lblMain);
    }
}
