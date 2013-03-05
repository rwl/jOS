package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIAppearance extends NSObject {
    @Export("appearance")
    public NSObject appearance() {
        throw new RuntimeException();
    }

    @Export("appearanceWhenContainedIn:")
    public NSObject appearanceWhenContainedIn(Class<? extends UIAppearanceContainer>... classes) {
        throw new RuntimeException();
    }

}

