package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIButton extends UIControl {

    public String currentTitle;

    @Export("buttonWithType:")
    public static UIButton fromType(UIButtonType roundedrect) {
        return null;
    }

    @Export("setTitle:forState:")
    public void setTitle(String string, UIControlState normal) {
    }

    @Export("currentTitle")
    public String getCurrentTitle() {
        return currentTitle;
    }

}
