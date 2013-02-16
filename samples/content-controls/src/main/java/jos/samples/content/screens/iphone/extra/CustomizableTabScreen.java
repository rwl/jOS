package jos.samples.content.screens.iphone.extra;

import com.google.j2objc.annotations.Outlet;

import jos.api.uikit.UILabel;
import jos.api.uikit.UIViewController;

public class CustomizableTabScreen extends UIViewController {

    @Outlet
    UILabel lblNumber;

    public CustomizableTabScreen(String number) {
        super("CustomizableTabScreen", null);
        getNibBundle().loadNib("CustomizableTabScreen", this, null);
        setNumber(number);
    }

    public String getNumber() {
        return lblNumber.getText();
    }

    public void setNumber(String value) {
        lblNumber.setText(value);
        setTitle(value);
    }

}
