package jos.samples.controls.screens.iphone;

import jos.api.graphicsimaging.CGGeometry;
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
        this.view.backgroundColor = UIColor.lightGray;

        lblMain = new UILabel(CGGeometry.CGRectMake(20, 200, 280, 33));
        lblMain.text = "Controller 2";
        lblMain.backgroundColor = UIColor.clear;
        this.view.addSubview(lblMain);
    }
}
