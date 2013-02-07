package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public class UISwitch extends UIControl {

    public boolean on;

    @Export("isOn")
    public boolean isOn() {
        return on;
    }

    @Export("setOn")
    public void setOn(boolean on) {
        this.on = on;
    }

}
