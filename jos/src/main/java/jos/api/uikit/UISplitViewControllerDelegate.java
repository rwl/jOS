package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UISplitViewControllerDelegate extends NSObject {

    @Export("splitViewController:willHideViewController:withBarButtonItem:forPopoverController:")
    public void willHideViewController(UISplitViewController controller, UIViewController aViewController, UIBarButtonItem barButtonItem, UIPopoverController pc) {
        throw new RuntimeException();
    }

    @Export("splitViewController:willShowViewController:invalidatingBarButtonItem:")
    public void willShowViewController(UISplitViewController svc, UIViewController aViewController, UIBarButtonItem barButtonItem) {
        throw new RuntimeException();
    }

    @Export("splitViewController:popoverController:willPresentViewController:")
    public void popoverController(UISplitViewController svc, UIPopoverController pc, UIViewController aViewController) {
        throw new RuntimeException();
    }

    @Export("splitViewController:shouldHideViewController:inOrientation:")
    public boolean shouldHideViewController(UISplitViewController ctrl, UIViewController vc, UIInterfaceOrientation orientation) {
        throw new RuntimeException();
    }

}