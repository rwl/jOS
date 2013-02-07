package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISlider extends UIControl {

    @Export("setThumbImage:forState:")
    public void setThumbImage(UIImage fromFile, UIControlState normal) {
    }

}
