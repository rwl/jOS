package jos.api.uikit;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIStoryboard extends NSObject {

    @Export("storyboardWithName:bundle:")
    public static UIStoryboard storyboardWithNamebundle(String name, NSBundle storyboardBundleOrNil) {
        throw new RuntimeException();
    }

    @Export("instantiateInitialViewController")
    public NSObject instantiateInitialViewController() {
        throw new RuntimeException();
    }

    @Export("instantiateViewControllerWithIdentifier:")
    public NSObject instantiateViewControllerWithIdentifier(String identifier) {
        throw new RuntimeException();
    }

}

