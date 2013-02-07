package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public abstract class UIActionSheetDelegate {

    @Export("actionSheet:clickedButtonAtIndex:")
    public void onClick(UIActionSheet sheet, int buttonIndex) {
    }
}
