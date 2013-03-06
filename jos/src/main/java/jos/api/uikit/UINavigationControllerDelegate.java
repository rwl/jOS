package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UINavigationControllerDelegate extends NSObject {

    @Export("navigationController:willShowViewController:animated:")
    public void navigationControllerwillShowViewControlleranimated(UINavigationController navigationController, UIViewController viewController, boolean animated) {
        throw new RuntimeException();
    }

    @Export("navigationController:didShowViewController:animated:")
    public void navigationControllerdidShowViewControlleranimated(UINavigationController navigationController, UIViewController viewController, boolean animated) {
        throw new RuntimeException();
    }

}