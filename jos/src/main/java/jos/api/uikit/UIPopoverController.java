package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIPopoverController extends UIAppearanceContainer {

    @Export("dismissPopoverAnimated:")
    public void dismiss(boolean animated) {
        throw new RuntimeException();
    }

}
