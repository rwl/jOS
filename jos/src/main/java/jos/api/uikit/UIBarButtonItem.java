package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@Register(isWrapper = true)
public class UIBarButtonItem extends UIBarItem {

    public Selector action;
    public NSObject target;
    public float width;

    @Export("initWithTitle:style:target:action:")
    public UIBarButtonItem(String buttonTitle, UIBarButtonItemStyle bordered,
            NSObject target, Selector action) {
    }

    @Export("initWithBarButtonSystemItem:target:action:")
    public UIBarButtonItem(UIBarButtonSystemItem systemItem, NSObject target, Selector action) {
    }

    @Export("action")
    public Selector getAction() {
        return action;
    }

    @Export("setAction:")
    public void setAction(Selector action) {
        this.action = action;
    }

    @Export("target")
    public NSObject getTarget() {
        return target;
    }

    @Export("setTarget:")
    public void setTarget(NSObject target) {
        this.target = target;
    }

    @Export("width")
    public float getWidth() {
        return width;
    }

    @Export("setWidth:")
    public void setWidth(float width) {
        this.width = width;
    }

}
