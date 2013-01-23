package jos.samples.controls.screens.iphone.pagercontrol;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIViewController;

public class Controller_2 extends UIViewController {

    UILabel lblMain;

    public Controller_2() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.lightGray;

        lblMain = new UILabel(CGGeometry.CGRectMake(20, 200, 280, 33));
        lblMain.Text = "Controller 2";
        lblMain.BackgroundColor = UIColor.clear;
        this.view.addSubview(lblMain);
    }

}
