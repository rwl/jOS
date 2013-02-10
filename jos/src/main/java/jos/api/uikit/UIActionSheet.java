package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIActionSheet extends UIView {

    public UIActionSheetDelegate delegate;

    public int destructiveButtonIndex;

    public int cancelButtonIndex;

    public UIActionSheetStyle style;

    @Export("initWithTitle:delegate:cancelButtonTitle:destructiveButtonTitle:otherButtonTitles:")
    public UIActionSheet(String title, NSObject delegate, String cancelButtonTitle,
            String destructiveButtonTitle, String... otherButtonTitles) {
    }

    @Export("showInView:")
    public void showInView(UIView view) {
    }

    @Export("addButtonWithTitle:")
    public int addButton(String string) {
        return 0;
    }

    @Export("dismissWithClickedButtonIndex:animated:")
    public void dismissWithClickedButtonIndex(int i, boolean b) {
    }

    @Export("delegate")
    public UIActionSheetDelegate getDelegate() {
        return delegate;
    }

    @Export("setDelegate:")
    public void setDelegate(UIActionSheetDelegate delegate) {
        this.delegate = delegate;
    }

    @Export("destructiveButtonIndex")
    public int getDestructiveButtonIndex() {
        return destructiveButtonIndex;
    }

    @Export("setDestructiveButtonIndex:")
    public void setDestructiveButtonIndex(int destructiveButtonIndex) {
        this.destructiveButtonIndex = destructiveButtonIndex;
    }

    @Export("cancelButtonIndex")
    public int getCancelButtonIndex() {
        return cancelButtonIndex;
    }

    @Export("setCancelButtonIndex:")
    public void setCancelButtonIndex(int cancelButtonIndex) {
        this.cancelButtonIndex = cancelButtonIndex;
    }

    @Export("style")
    public UIActionSheetStyle getStyle() {
        return style;
    }

    @Export("setStyle:")
    public void setStyle(UIActionSheetStyle style) {
        this.style = style;
    }

}
