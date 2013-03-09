package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISwitch extends UIControl {

    @Export("isOn")
    public boolean isOn() {
        throw new RuntimeException();
    }

    @Export("setOn")
    public void setOn(boolean on) {
        throw new RuntimeException();
    }

}
