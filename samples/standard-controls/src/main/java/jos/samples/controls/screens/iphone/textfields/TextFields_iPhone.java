package jos.samples.controls.screens.iphone.textfields;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSCoder;
import jos.api.graphicsimaging.CGGeometry;
import jos.api.system.IntPtr;
import jos.api.uikit.UIFont;
import jos.api.uikit.UITextBorderStyle;
import jos.api.uikit.UITextField;
import jos.api.uikit.UIViewController;

public class TextFields_iPhone extends UIViewController {

    UITextField textField;

    public TextFields_iPhone(IntPtr handle) {
        super(handle);
        initialize();
    }

    @Export(selector = "initWithCoder:")
    public TextFields_iPhone(NSCoder coder) {
        super(coder);
        initialize();
    }

    public TextFields_iPhone() {
        super("TextFields_iPhone", null);
        initialize();
    }

    void initialize() {
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        this.title = "UITextField";

        textField = new UITextField(CGGeometry.CGRectMake(20, 150, 280, 33));
        textField.font = UIFont.fromName("Helvetica-Bold", 20);
        textField.borderStyle = UITextBorderStyle.Bezel;
        textField.placeholder = "edit me!";

        this.view.addSubview(textField);
    }
}
