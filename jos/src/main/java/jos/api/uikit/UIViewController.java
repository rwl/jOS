package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;

@Register(isWrapper = true)
public class UIViewController extends UIResponder {

    public String title;

    @Export("title")
    public String getTitle() {
        return title;
    }

    @Export("setTitle:")
    public void setTitle(String title) {
        this.title = title;
    }

    public UIView view;

    @Export("view")
    public UIView getView() {
        return view;
    }

    @Export("setView:")
    public void setView(UIView view) {
        this.view = view;
    }

    public UINavigationController navigationController;

    @Export("navigationController")
    public UINavigationController getNavigationController() {
        return navigationController;
    }

    @Export("setNavigationController:")
    public void setNavigationController(UINavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @Export("init")
    public UIViewController() {
    }

    @Export("initWithNibName:bundle:")
    public UIViewController(final String nibName, final NSBundle bundle) {
    }

    public UIViewController(IntPtr handle) {
    }

    @Export("initWithCoder:")
    public UIViewController(NSCoder coder) {
    }

    @Export("loadView")
    public void loadView() {
    }

    @Export("shouldAutorotateToInterfaceOrientation:")
    public boolean shouldAutorotateToInterfaceOrientation(
            final UIInterfaceOrientation toInterfaceOrientation) {
        return false;
    }

    @Export("viewDidUnload")
    public void viewDidUnload() {
    }

    /**
     * Dispose of any resources that can be recreated.
     */
    @Export("didReceiveMemoryWarning")
    public void didReceiveMemoryWarning() {
    }

    @Export("viewWillAppear:")
    public void viewWillAppear(boolean animated) {
    }

    @Export("viewWillDisappear:")
    public void viewWillDisappear(boolean animated) {
    }

    @Export("viewDidLoad")
    public void viewDidLoad() {
    }

}
