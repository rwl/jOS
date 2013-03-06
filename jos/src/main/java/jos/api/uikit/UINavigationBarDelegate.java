package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;


@Model
@Register(isWrapper = true)
public class UINavigationBarDelegate extends NSObject {
    @Export("navigationBar:shouldPushItem:")
    public boolean navigationBarshouldPushItem(UINavigationBar navigationBar, UINavigationItem item) {
        throw new RuntimeException();
    }

    @Export("navigationBar:didPushItem:")
    public void navigationBardidPushItem(UINavigationBar navigationBar, UINavigationItem item) {
        throw new RuntimeException();
    }

    @Export("navigationBar:shouldPopItem:")
    public boolean navigationBarshouldPopItem(UINavigationBar navigationBar, UINavigationItem item) {
        throw new RuntimeException();
    }

    @Export("navigationBar:didPopItem:")
    public void navigationBardidPopItem(UINavigationBar navigationBar, UINavigationItem item) {
        throw new RuntimeException();
    }
}