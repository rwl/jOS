package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@Register(isWrapper = true)
public class UIControl extends UIView {

    @Export("addTarget:forControlEvents:")
    public void addTarget(Object listener, UIControlEvent controlEvents) {
    }

    @Export("addTarget:action:forControlEvents:")
    public void addTarget(NSObject actionSheets_iPad,
            Selector selector, UIControlEvent controlEvents) {
    }

}
