package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(name = "UITableViewCellAccessory")
public enum UITableViewCellAccessory {
    None, @Bind("DisclosureIndicator")
    DisclosureIndicator, DetailDisclosureButton, Checkmark
}
