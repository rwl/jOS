package jos.api.uikit;

import com.google.j2objc.annotations.Export;

public abstract class UIActionSheetDelegate {

    @Export(selector = "actionSheet:clickedButtonAtIndex:")
    public void onClick(UIActionSheet sheet, int buttonIndex) {
    }
}
