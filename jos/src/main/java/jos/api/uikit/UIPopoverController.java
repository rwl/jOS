package jos.api.uikit;

import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIPopoverController extends UIAppearanceContainer {

    @Export("initWithContentViewController:")
    public UIPopoverController(UIViewController viewController) {
        throw new RuntimeException();
    }

    @Export("dismissPopoverAnimated:")
    public void dismiss(boolean animated) {
        throw new RuntimeException();
    }

    @Export("presentPopoverFromRect:inView:permittedArrowDirections:animated:")
    public void presentFromRect(CGRect rect, UIView view, int arrowDirections, boolean animated) {
        throw new RuntimeException();
    }

}
