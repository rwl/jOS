package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Selector;

public class UIBarButtonItem extends UIBarItem {

    public UIBarButtonItem(String buttonTitle, UIBarButtonItemStyle bordered,
            Object object) {
    }

    public UIBarButtonItem(UIBarButtonSystemItem fixedspace) {
    }

    public Selector action;
    public NSObject target;
    public float width;

}
