package jos.samples.hello;

import static jos.api.graphicsimaging.CGGeometry.CGRectMake;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIColor;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITextAlignment;
import jos.api.uikit.UIView;

public class HelloView extends UIView {

    public HelloView(CGRect frame) {
        super(frame);
        this.backgroundColor = UIColor.lightGray;

        UILabel label = new UILabel(CGRectMake(0.0f, 0.0f, 320.0f, 30.0f));
        label.text = "Hello World";
        label.center = this.center;
        label.backgroundColor = UIColor.clear;
        label.textAlignment = UITextAlignment.Center;

        addSubview(label);
    }

}