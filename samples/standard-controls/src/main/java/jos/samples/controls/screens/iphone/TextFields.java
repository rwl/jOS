package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.uikit.UIFont;
import jos.api.uikit.UITextBorderStyle;
import jos.api.uikit.UITextField;
import jos.api.uikit.UIViewController;

public class TextFields extends UIViewController {

    UITextField textField;

    public TextFields() {
        super("TextFields_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("UITextField");

        textField = new UITextField(makeRect(20, 150, 280, 33));
        textField.setFont(UIFont.fromName("Helvetica-Bold", 20));
        textField.setBorderStyle(UITextBorderStyle.BEZEL);
        textField.setPlaceholder("edit me!");

        getView().addSubview(textField);
    }

}
