package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIToolbar extends UIView {

    @Export("initWithFrame:")
    public UIToolbar(CGRect frame) {
    }

    @Export("setItems:animated:")
    public void setItems(UIBarButtonItem[] items, boolean animated) {
    }

}
