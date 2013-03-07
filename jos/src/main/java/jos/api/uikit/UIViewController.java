package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.NativeArray;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@BaseType({NSCoding.class, UIAppearanceContainer.class})
@Register(isWrapper = true)
public class UIViewController extends UIResponder {

    @Export("init")
    public UIViewController() {
        throw new RuntimeException();
    }

    @Export("initWithNibName:bundle:")
    public UIViewController(final String nibName, final NSBundle bundle) {
        throw new RuntimeException();
    }

    @Export("view")
    public UIView getView() {
        throw new RuntimeException();
    }

    @Export("setView:")
    public void setView(UIView value) {
        throw new RuntimeException();
    }

    @Export("nibName")
    public String getNibName() {
        throw new RuntimeException();
    }

    @Export("nibBundle")
    public NSBundle getNibBundle() {
        throw new RuntimeException();
    }

    @Export("storyboard")
    public UIStoryboard getStoryboard() {
        throw new RuntimeException();
    }

    @Export("title")
    public String getTitle() {
        throw new RuntimeException();
    }

    @Export("setTitle:")
    public void setTitle(String value) {
        throw new RuntimeException();
    }

    @Export("modalPresentationStyle")
    public UIModalPresentationStyle getModalPresentationStyle() {
        throw new RuntimeException();
    }

    @Export("setModalPresentationStyle:")
    public void setModalPresentationStyle(UIModalPresentationStyle value) {
        throw new RuntimeException();
    }

    @Export("wantsFullScreenLayout")
    public boolean getWantsFullScreenLayout() {
        throw new RuntimeException();
    }

    @Export("setWantsFullScreenLayout:")
    public void setWantsFullScreenLayout(boolean value) {
        throw new RuntimeException();
    }

    @Export("setView:nibNameOrNilbundle:")
    public NSObject initWithNibName(NSString name, NSBundle nibBundleOrNil) {
        throw new RuntimeException();
    }

    @Export("loadView")
    public void loadView() {
        throw new RuntimeException();
    }

    @Export("viewDidLoad")
    public void viewDidLoad() {
        throw new RuntimeException();
    }

    @Export("isViewLoaded")
    public boolean isViewLoaded() {
        throw new RuntimeException();
    }

    @Export("performSegueWithIdentifier:sender:")
    public void performSegueWithIdentifiersender(String identifier, NSObject sender) {
        throw new RuntimeException();
    }

    @Export("shouldPerformSegueWithIdentifier:sender:")
    public boolean shouldPerformSegueWithIdentifiersender(String identifier, NSObject sender) {
        throw new RuntimeException();
    }

    @Export("prepareForSegue:sender:")
    public void prepareForSeguesender(UIStoryboardSegue segue, NSObject sender) {
        throw new RuntimeException();
    }

    @Export("canPerformUnwindSegueAction:fromViewController:withSender:")
    public boolean canPerformUnwindSegueActionfromViewControllerwithSender(Selector action, UIViewController fromViewController, NSObject sender) {
        throw new RuntimeException();
    }

    @Export("viewControllerForUnwindSegueAction:fromViewController:withSender:")
    public UIViewController viewControllerForUnwindSegueAction(Selector action, UIViewController fromViewController, NSObject sender) {
        throw new RuntimeException();
    }

    @Export("segueForUnwindingToViewController:fromViewController:identifier:")
    public UIStoryboardSegue segueForUnwindingToViewControllerfromViewControlleridentifier(UIViewController toViewController, UIViewController fromViewController, String identifier) {
        throw new RuntimeException();
    }

    @Export("viewWillAppear:")
    public void viewWillAppear(boolean animated) {
        throw new RuntimeException();
    }

    @Export("viewDidAppear:")
    public void viewDidAppear(boolean animated) {
        throw new RuntimeException();
    }

    @Export("viewWillDisappear:")
    public void viewWillDisappear(boolean animated) {
        throw new RuntimeException();
    }

    @Export("viewDidDisappear:")
    public void viewDidDisappear(boolean animated) {
        throw new RuntimeException();
    }

    @Export("viewWillLayoutSubviews")
    public void viewWillLayoutSubviews() {
        throw new RuntimeException();
    }

    @Export("viewDidLayoutSubviews")
    public void viewDidLayoutSubviews() {
        throw new RuntimeException();
    }

    @Export("didReceiveMemoryWarning")
    public void didReceiveMemoryWarning() {
        throw new RuntimeException();
    }

    @Export("parentViewController")
    public UIViewController getParentViewController() {
        throw new RuntimeException();
    }

    @Export("modalViewController")
    public UIViewController getModalViewController() {
        throw new RuntimeException();
    }

    @Export("presentedViewController")
    public UIViewController getPresentedViewController() {
        throw new RuntimeException();
    }

    @Export("presentingViewController")
    public UIViewController getPresentingViewController() {
        throw new RuntimeException();
    }

    @Export("definesPresentationContext")
    public boolean definesPresentationContext() {
        throw new RuntimeException();
    }

    @Export("providesPresentationContextTransitionStyle")
    public boolean providesPresentationContextTransitionStyle() {
        throw new RuntimeException();
    }

    @Export("isBeingPresented")
    public boolean isBeingPresented() {
        throw new RuntimeException();
    }

    @Export("isBeingDismissed")
    public boolean isBeingDismissed() {
        throw new RuntimeException();
    }

    @Export("isMovingToParentViewController")
    public boolean isMovingToParentViewController() {
        throw new RuntimeException();
    }

    @Export("isMovingFromParentViewController")
    public boolean isMovingFromParentViewController() {
        throw new RuntimeException();
    }

    @Export("presentViewController:animated:completion:")
    public void presentViewControlleranimatedcompletion(UIViewController viewControllerToPresent, boolean flag, Object completion) {
        throw new RuntimeException();
    }

    @Export("dismissViewControllerAnimated:completion:")
    public void dismissViewControllerAnimatedcompletion(boolean flag, Object completion) {
        throw new RuntimeException();
    }

    @Export("presentModalViewController:animated:")
    public void presentModalViewControlleranimated(UIViewController modalViewController, boolean animated) {
        throw new RuntimeException();
    }

    @Export("dismissModalViewControllerAnimated:")
    public void dismissModalViewControllerAnimated(boolean animated) {
        throw new RuntimeException();
    }

    @Export("modalTransitionStyle")
    public UIModalTransitionStyle modalTransitionStyle() {
        throw new RuntimeException();
    }

    @Export("disablesAutomaticKeyboardDismissal")
    public boolean disablesAutomaticKeyboardDismissal() {
        throw new RuntimeException();
    }


    @Export("interfaceOrientation")
    public UIInterfaceOrientation getInterfaceOrientation() {
        throw new RuntimeException();
    }

    @Export("attemptRotationToDeviceOrientation")
    public void attemptRotationToDeviceOrientation() {
        throw new RuntimeException();
    }

    @Export("shouldAutorotateToInterfaceOrientation:")
    public boolean shouldAutorotateToInterfaceOrientation(UIInterfaceOrientation toInterfaceOrientation) {
        throw new RuntimeException();
    }

    @Export("shouldAutorotate")
    public boolean shouldAutorotate() {
        throw new RuntimeException();
    }

    @Export("supportedInterfaceOrientations")
    public int supportedInterfaceOrientations() {
        throw new RuntimeException();
    }

    @Export("preferredInterfaceOrientationForPresentation")
    public UIInterfaceOrientation preferredInterfaceOrientationForPresentation() {
        throw new RuntimeException();
    }

    @Export("rotatingHeaderView")
    public UIView rotatingHeaderView() {
        throw new RuntimeException();
    }

    @Export("rotatingFooterView")
    public UIView rotatingFooterView() {
        throw new RuntimeException();
    }

    @Export("willRotateToInterfaceOrientation:duration:")
    public void willRotateToInterfaceOrientationduration(UIInterfaceOrientation toInterfaceOrientation, double duration) {
        throw new RuntimeException();
    }

    @Export("didRotateFromInterfaceOrientation:")
    public void didRotateFromInterfaceOrientation(UIInterfaceOrientation fromInterfaceOrientation) {
        throw new RuntimeException();
    }

    @Export("willAnimateRotationToInterfaceOrientation:duration:")
    public void willAnimateRotationToInterfaceOrientationduration(UIInterfaceOrientation toInterfaceOrientation, double duration) {
        throw new RuntimeException();
    }

    @Export("willAnimateFirstHalfOfRotationToInterfaceOrientation:duration:")
    public void willAnimateFirstHalfOfRotationToInterfaceOrientationduration(UIInterfaceOrientation toInterfaceOrientation, double duration) {
        throw new RuntimeException();
    }

    @Export("didAnimateFirstHalfOfRotationToInterfaceOrientation:")
    public void didAnimateFirstHalfOfRotationToInterfaceOrientation(UIInterfaceOrientation toInterfaceOrientation) {
        throw new RuntimeException();
    }

    @Export("willAnimateSecondHalfOfRotationFromInterfaceOrientation:duration:")
    public void willAnimateSecondHalfOfRotationFromInterfaceOrientationduration(UIInterfaceOrientation fromInterfaceOrientation, double duration) {
        throw new RuntimeException();
    }


    @Bind("isEditing")
    @Export("editing")
    public boolean getEditing() {
        throw new RuntimeException();
    }

    @Export("setEditing:")
    public void setEditing(boolean value) {
        throw new RuntimeException();
    }

    @Export("editButtonItem")
    public UIBarButtonItem editButtonItem() {
        throw new RuntimeException();
    }


    @Export("searchDisplayController")
    public UISearchDisplayController getSearchDisplayController() {
        throw new RuntimeException();
    }


    @Export("childViewControllers")
    public NSArray childViewControllers() {
        throw new RuntimeException();
    }

    @Export("addChildViewController:")
    public void addChildViewController(UIViewController childController) {
        throw new RuntimeException();
    }

    @Export("removeFromParentViewController")
    public void removeFromParentViewController() {
        throw new RuntimeException();
    }

    @Export("beginAppearanceTransition:animated:")
    public void beginAppearanceTransitionanimated(boolean isAppearing, boolean animated) {
        throw new RuntimeException();
    }

    @Export("endAppearanceTransition")
    public void endAppearanceTransition() {
        throw new RuntimeException();
    }

    @Export("shouldAutomaticallyForwardRotationMethods")
    public boolean shouldAutomaticallyForwardRotationMethods() {
        throw new RuntimeException();
    }

    @Export("shouldAutomaticallyForwardAppearanceMethods")
    public boolean shouldAutomaticallyForwardAppearanceMethods() {
        throw new RuntimeException();
    }

    @Export("willMoveToParentViewController:")
    public void willMoveToParentViewController(UIViewController parent) {
        throw new RuntimeException();
    }

    @Export("didMoveToParentViewController:")
    public void didMoveToParentViewController(UIViewController parent) {
        throw new RuntimeException();
    }


    @Export("restorationClass")
    public Class<? extends UIViewControllerRestoration> getRestorationClass() {
        throw new RuntimeException();
    }

    @Export("setRestorationClass:")
    public void setRestorationClass(Class<? extends UIViewControllerRestoration> value) {
        throw new RuntimeException();
    }

    @Export("decodeRestorableStateWithCoder:")
    public void decodeRestorableStateWithCoder(NSCoder coder) {
        throw new RuntimeException();
    }


    @Export("updateViewConstraints")
    public void updateViewConstraints() {
        throw new RuntimeException();
    }


    @Export("navigationItem")
    public UINavigationItem getNavigationItem() {
        throw new RuntimeException();
    }

    @Export("navigationController")
    public UINavigationController getNavigationController() {
        throw new RuntimeException();
    }


    @Export("toolbarItems")
    public NSArray getToolbarItems() {
        throw new RuntimeException();
    }

    @Export("setToolbarItems:")
    public void setToolbarItems(@NativeArray UIBarItem[] value) {
        throw new RuntimeException();
    }

    @Export("splitViewController")
    public UISplitViewController getSplitViewController() {
        throw new RuntimeException();
    }
}
