package jos.samples.controls.screens.iphone.pagercontrol;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIViewController;

public class Controller_3 extends UIViewController {

    UILabel lblMain;

    public Controller_3() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.fromRGB(.5f, .5f, 1);

        lblMain = new UILabel(CGGeometry.CGRectMake(20, 200, 280, 33));
        lblMain.text = "Controller 3";
        lblMain.backgroundColor = UIColor.clear;
        this.view.addSubview(lblMain);
    }
}
