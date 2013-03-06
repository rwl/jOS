package jos.api.uikit;

import jos.api.foundation.NSObject;
import jos.api.foundation.NSSet;
import jos.api.foundation.NSUndoManager;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@Register(isWrapper = true)
public class UIResponder extends NSObject {

    @Export("init")
    public UIResponder() {
    }


    @Export("undoManager")
    public NSUndoManager getUndoManager() {
        throw new RuntimeException();
    }

    @Export("nextResponder")
    public UIResponder nextResponder() {
        throw new RuntimeException();
    }

    @Export("canBecomeFirstResponder")
    public boolean canBecomeFirstResponder() {
        throw new RuntimeException();
    }

    @Export("becomeFirstResponder")
    public boolean becomeFirstResponder() {
        throw new RuntimeException();
    }

    @Export("canResignFirstResponder")
    public boolean canResignFirstResponder() {
        throw new RuntimeException();
    }

    @Export("resignFirstResponder")
    public boolean resignFirstResponder() {
        throw new RuntimeException();
    }

    @Export("isFirstResponder")
    public boolean isFirstResponder() {
        throw new RuntimeException();
    }

    @Export("touchesBegan:withEvent:")
    public void touchesBegan(NSSet touches, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("touchesMoved:withEvent:")
    public void touchesMovedwithEvent(NSSet touches, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("touchesEnded:withEvent:")
    public void touchesEndedwithEvent(NSSet touches, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("touchesCancelled:withEvent:")
    public void touchesCancelledwithEvent(NSSet touches, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("motionBegan:withEvent:")
    public void motionBeganwithEvent(UIEventSubtype motion, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("motionEnded:withEvent:")
    public void motionEndedwithEvent(UIEventSubtype motion, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("motionCancelled:withEvent:")
    public void motionCancelledwithEvent(UIEventSubtype motion, UIEvent event) {
        throw new RuntimeException();
    }

    @Export("remoteControlReceivedWithEvent:")
    public void remoteControlReceivedWithEvent(UIEvent event) {
        throw new RuntimeException();
    }

    @Export("canPerformAction:withSender:")
    public boolean canPerformActionwithSender(Selector action, NSObject sender) {
        throw new RuntimeException();
    }
}
