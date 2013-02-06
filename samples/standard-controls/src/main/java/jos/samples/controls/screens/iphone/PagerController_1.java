package jos.samples.controls.screens.iphone;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class PagerController_1 extends UIViewController {

    UILabel lblMain;

    public PagerController_1() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.white;

        lblMain = new UILabel(CGGeometry.CGRectMake(20, 200, 280, 33));
        lblMain.text = "Controller 1";
        lblMain.backgroundColor = UIColor.clear;
        this.view.addSubview(lblMain);
    }

}
