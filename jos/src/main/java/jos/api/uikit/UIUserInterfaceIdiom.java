package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIUserInterfaceIdiom {
    @Bind("UIUserInterfaceIdiomPad") PAD,
    @Bind("UIUserInterfaceIdiomPhone") PHONE
}
