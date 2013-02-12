package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public abstract class UIActionSheetDelegate {

    @Export("actionSheet:clickedButtonAtIndex:")
    public void onClick(UIActionSheet sheet, int buttonIndex) {
    }

}
