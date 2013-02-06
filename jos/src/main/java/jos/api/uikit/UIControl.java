package jos.api.uikit;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UIControl extends UIView {

    public void addTarget(EventListener listener, UIControlEvent controlEvents) {
    }

    @Export(selector = "addTarget:action:forControlEvents:")
    public void addTarget(NSObject actionSheets_iPad,
            Selector selector, UIControlEvent controlEvents) {
    }
}
