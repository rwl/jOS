package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSObject;

@Model
@Register(isWrapper = true)
public class UITabBarControllerDelegate extends NSObject {

    @Export("tabBarController:shouldSelectViewController:")
    public boolean tabBarControllershouldSelectViewController(UITabBarController tabBarController, UIViewController viewController) {
        return false;
    }

    @Export("tabBarController:didSelectViewController:")
    public void tabBarControllerdidSelectViewController(UITabBarController tabBarController, UIViewController viewController) {
    }

    @Export("tabBarController:willBeginCustomizingViewControllers:")
    public void tabBarControllerwillBeginCustomizingViewControllers(UITabBarController tabBarController, NSArray viewControllers) {
    }

    @Export("tabBarController:willEndCustomizingViewControllers:changed:")
    public void tabBarControllerwillEndCustomizingViewControllerschanged(UITabBarController tabBarController, NSArray viewControllers, boolean changed) {
    }

    @Export("tabBarController:didEndCustomizingViewControllers:changed:")
    public void tabBarControllerdidEndCustomizingViewControllerschanged(UITabBarController tabBarController, NSArray viewControllers, boolean changed) {
    }

}
