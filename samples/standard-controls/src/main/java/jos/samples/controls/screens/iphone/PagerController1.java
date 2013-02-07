package jos.samples.controls.screens.iphone;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class PagerController1 extends UIViewController {

    UILabel lblMain;

    public PagerController1() {
        super();
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.WHITE;

        lblMain = new UILabel(CGGeometry.makeRect(20, 200, 280, 33));
        lblMain.text = "Controller 1";
        lblMain.backgroundColor = UIColor.CLEAR;
        this.view.addSubview(lblMain);
    }

}
