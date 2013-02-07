package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public abstract class UIActionSheetDelegate {

    @Export("actionSheet:clickedButtonAtIndex:")
    public void onClick(UIActionSheet sheet, int buttonIndex) {
    }

}
