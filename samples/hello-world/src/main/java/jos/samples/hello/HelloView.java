package jos.samples.hello;

import static jos.graphicsimaging.CGGeometry.CGRectMake;

import jos.graphicsimaging.CGRect;
import jos.uikit.NSText.NSTextAlignment;
import jos.uikit.UIColor;
import jos.uikit.UILabel;
import jos.uikit.UIView;

public class HelloView extends UIView {

    public HelloView(CGRect frame) {
        super(frame);
        this.backgroundColor = UIColor.lightGrayColor;

        UILabel label = new UILabel(CGRectMake(0.0f, 0.0f, 320.0f, 30.0f));
        label.text = "Hello World";
        label.center = this.center;
        label.backgroundColor = UIColor.clearColor;
        label.textAlignment = NSTextAlignment.NSTextAlignmentCenter;

        addSubview(label);
    }

}
