package jos.samples.controls.screens.iphone.labels;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.graphicsimaging.CGGeometry;
import jos.api.graphicsimaging.CGRect;
import jos.api.system.IntPtr;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class LabelsScreen_iPhone extends UIViewController {

    UILabel customLabel;

    public LabelsScreen_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public LabelsScreen_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public LabelsScreen_iPhone() {
        super("LabelsScreen_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "UILabels";

        customLabel = new UILabel(CGGeometry.CGRectMake(20f, 300f, 280f, 40f));
        customLabel.text = "A label created programatically";
        customLabel.textColor = UIColor.blue;
        customLabel.font = UIFont.fromName("Helvetica-Bold", 20);
        customLabel.adjustsFontSizeToFitWidth = true;
        customLabel.minimumFontSize = 12;
        customLabel.lineBreakMode = UILineBreakMode.TailTruncation;
        customLabel.lines = 1;

        view.addSubview(customLabel);

    }
}
