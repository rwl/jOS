package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSSet;

import com.google.j2objc.annotations.Bind;
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


    @Bind("isEnabled")
    @Export("enabled")
    public boolean getEnabled() {
        throw new RuntimeException();
    }

    @Export("setEnabled:")
    public void setEnabled(boolean value) {
        throw new RuntimeException();
    }

    @Bind("isSelected")
    @Export("selected")
    public boolean getSelected() {
        throw new RuntimeException();
    }

    @Export("setSelected:")
    public void setSelected(boolean value) {
        throw new RuntimeException();
    }

    @Bind("isHighlighted")
    @Export("highlighted")
    public boolean getHighlighted() {
        throw new RuntimeException();
    }

    @Export("setHighlighted:")
    public void setHighlighted(boolean value) {
        throw new RuntimeException();
    }

    @Export("contentVerticalAlignment")
    public UIControlContentVerticalAlignment getContentVerticalAlignment() {
        throw new RuntimeException();
    }

    @Export("setContentVerticalAlignment:")
    public void setContentVerticalAlignment(UIControlContentVerticalAlignment value) {
        throw new RuntimeException();
    }

    @Export("contentHorizontalAlignment")
    public UIControlContentHorizontalAlignment getContentHorizontalAlignment() {
        throw new RuntimeException();
    }

    @Export("setContentHorizontalAlignment:")
    public void setContentHorizontalAlignment(UIControlContentHorizontalAlignment value) {
        throw new RuntimeException();
    }

    @Export("state")
    public UIControlState getState() {
        throw new RuntimeException();
    }

    @Bind("isTracking")
    @Export("tracking")
    public boolean getTracking() {
        throw new RuntimeException();
    }

    @Bind("isTouchInside")
    @Export("touchInside")
    public boolean getTouchInside() {
        throw new RuntimeException();
    }

    @Export("beginTrackingWithTouch:withEvent:")
    public boolean beginTrackingWithTouchwithEvent(UITouch touch, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("continueTrackingWithTouch:withEvent:")
    public boolean continueTrackingWithTouchwithEvent(UITouch touch, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("endTrackingWithTouch:withEvent:")
    public void endTrackingWithTouchwithEvent(UITouch touch, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("cancelTrackingWithEvent:")
    public void cancelTrackingWithEvent(UIEvent event) {
        throw new RuntimeException();
    }

    @Export("addTarget:action:forControlEvents:")
    public void addTargetactionforControlEvents(NSObject target, Selector action, UIControlEvents controlEvents) {
        throw new RuntimeException();
    }

    @Export("removeTarget:action:forControlEvents:")
    public void removeTargetactionforControlEvents(NSObject target, Selector action, UIControlEvents controlEvents) {
        throw new RuntimeException();
    }

    @Export("allTargets")
    public NSSet allTargets() {
        throw new RuntimeException();
    }

    @Export("allControlEvents")
    public UIControlEvents allControlEvents() {
        throw new RuntimeException();
    }

    @Export("actionsForTarget:forControlEvent:")
    public NSArray actionsForTargetforControlEvent(NSObject target, UIControlEvents controlEvent) {
        throw new RuntimeException();
    }

    @Export("sendAction:to:forEvent:")
    public void sendActiontoforEvent(Selector action, NSObject target, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("sendActionsForControlEvents:")
    public void sendActionsForControlEvents(UIControlEvents controlEvents) {
        throw new RuntimeException();
    }

}
