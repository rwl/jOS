package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;

@Register(isWrapper = true)
public class UIViewController extends UIResponder {

    public String title;

    @Export(selector = "title")
    public String getTitle() {
        return title;
    }

    @Export(selector = "setTitle:")
    public void setTitle(String title) {
        this.title = title;
    }

    public UIView view;

    @Export(selector = "view")
    public UIView getView() {
        return view;
    }

    @Export(selector = "setView:")
    public void setView(UIView view) {
        this.view = view;
    }

    public UINavigationController navigationController;

    @Export(selector = "navigationController")
    public UINavigationController getNavigationController() {
        return navigationController;
    }

    @Export(selector = "setNavigationController:")
    public void setNavigationController(UINavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @Export(selector = "init")
    public UIViewController() {
    }

    @Export(selector = "initWithNibName:bundle:")
    public UIViewController(final String nibName, final NSBundle bundle) {
    }

    public UIViewController(IntPtr handle) {
    }

    public UIViewController(NSCoder coder) {
    }

    public void loadView() {
    }

    //    @Export
    @Deprecated
    public boolean shouldAutorotateToInterfaceOrientation(
            final UIInterfaceOrientation toInterfaceOrientation) {
        return false;
    }

    //  @Export
    @Deprecated
    public void viewDidUnload() {
    }

    /**
     * Dispose of any resources that can be recreated.
     */
    public void didReceiveMemoryWarning() {
    }

    public void viewWillAppear(boolean animated) {
    }

    public void viewWillDisappear(boolean animated) {
    }

    public void viewDidLoad() {
    }
}
