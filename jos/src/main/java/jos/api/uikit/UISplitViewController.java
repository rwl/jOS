package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.NativeArray;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISplitViewController extends UIViewController {

    @Export("viewControllers")
    public UIViewController[] getViewControllers() {
        throw new RuntimeException();
    }

    @Export("setViewControllers:")
    public void setViewControllers(@NativeArray UIViewController[] value) {
        throw new RuntimeException();
    }

    @Export("presentsWithGesture")
    public boolean presentsWithGesture() {
        throw new RuntimeException();
    }

    @Export("setDelegate")
    public void setDelegate(UISplitViewControllerDelegate delegate) {
        throw new RuntimeException();
    }

}