package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;

import com.google.j2objc.annotations.Outlet;

import jos.api.uikit.NSLineBreakMode;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIFont;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class LabelsScreen extends UIViewController {

    @Outlet
    UIView view;

    UILabel customLabel;

    public LabelsScreen() {
        super("LabelsScreen_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("UILabels");

        customLabel = new UILabel(makeRect(20f, 300f, 280f, 40f));
        customLabel.setText("A label created programatically");
        customLabel.setTextColor(UIColor.BLUE);
        customLabel.setFont(UIFont.fromName("Helvetica-Bold", 20));
        customLabel.setAdjustsFontSizeToFitWidth(true);
        customLabel.setMinimumFontSize(12);
        customLabel.setLineBreakMode(NSLineBreakMode.TAIL_TRUNCATION);
        customLabel.setLines(1);

        view.addSubview(customLabel);
    }

}
