package jos.api.foundation;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@Register(isWrapper = true)
public class NSUndoManager {
    @Export("beginUndoGrouping")
    public void beginUndoGrouping() {
        throw new RuntimeException();
    }

    @Export("endUndoGrouping")
    public void endUndoGrouping() {
        throw new RuntimeException();
    }

    @Export("groupingLevel")
    public int groupingLevel() {
        throw new RuntimeException();
    }

    @Export("disableUndoRegistration")
    public void disableUndoRegistration() {
        throw new RuntimeException();
    }

    @Export("enableUndoRegistration")
    public void enableUndoRegistration() {
        throw new RuntimeException();
    }

    @Export("isUndoRegistrationEnabled")
    public boolean isUndoRegistrationEnabled() {
        throw new RuntimeException();
    }

    @Export("void setRunLoopModes:")
    public void setRunLoopModes(NSArray modes) {
        throw new RuntimeException();
    }

    @Export("runLoopModes")
    public NSArray runLoopModes() {
        throw new RuntimeException();
    }

    @Export("undo")
    public void undo() {
        throw new RuntimeException();
    }

    @Export("redo")
    public void redo() {
        throw new RuntimeException();
    }

    @Export("undoNestedGroup")
    public void undoNestedGroup() {
        throw new RuntimeException();
    }

    @Export("canUndo")
    public boolean canUndo() {
        throw new RuntimeException();
    }

    @Export("canRedo")
    public boolean canRedo() {
        throw new RuntimeException();
    }

    @Export("isUndoing")
    public boolean isUndoing() {
        throw new RuntimeException();
    }

    @Export("isRedoing")
    public boolean isRedoing() {
        throw new RuntimeException();
    }

    @Export("removeAllActions")
    public void removeAllActions() {
        throw new RuntimeException();
    }

    @Export("removeAllActionsWithTarget:")
    public void removeAllActionsWithTarget(NSObject target) {
        throw new RuntimeException();
    }

    @Export("registerUndoWithTarget:selector:object:")
    public void registerUndoWithTargetselectorobject(NSObject target, Selector selector, NSObject anObject) {
        throw new RuntimeException();
    }

    @Export("prepareWithInvocationTarget:")
    public NSObject prepareWithInvocationTarget(NSObject target) {
        throw new RuntimeException();
    }

    @Export("setActionIsDiscardable:")
    public void setActionIsDiscardable(boolean discardable) {
        throw new RuntimeException();
    }

    @Export("undoActionIsDiscardable")
    public boolean undoActionIsDiscardable() {
        throw new RuntimeException();
    }

    @Export("redoActionIsDiscardable")
    public boolean redoActionIsDiscardable() {
        throw new RuntimeException();
    }

    @Export("undoActionName")
    public String undoActionName() {
        throw new RuntimeException();
    }

    @Export("redoActionName")
    public String redoActionName() {
        throw new RuntimeException();
    }

    @Export("setActionName:")
    public void setActionName(String actionName) {
        throw new RuntimeException();
    }

    @Export("undoMenuItemTitle")
    public String undoMenuItemTitle() {
        throw new RuntimeException();
    }

    @Export("redoMenuItemTitle")
    public String redoMenuItemTitle() {
        throw new RuntimeException();
    }

    @Export("undoMenuTitleForUndoActionName:")
    public String undoMenuTitleForUndoActionName(String actionName) {
        throw new RuntimeException();
    }

    @Export("redoMenuTitleForUndoActionName:")
    public String redoMenuTitleForUndoActionName(String actionName) {
        throw new RuntimeException();
    }

    // Detected properties
    @Export("groupsByEvent")
    public boolean getGroupsByEvent() {
        throw new RuntimeException();
    }

    @Export("setGroupsByEvent:")
    public void setGroupsByEvent(boolean value) {
        throw new RuntimeException();
    }

    @Export("levelsOfUndo")
    public int getLevelsOfUndo() {
        throw new RuntimeException();
    }

    @Export("setLevelsOfUndo:")
    public void setLevelsOfUndo(int value) {
        throw new RuntimeException();
    }

}

