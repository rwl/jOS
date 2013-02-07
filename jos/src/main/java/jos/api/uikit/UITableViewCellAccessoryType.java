package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITableViewCellAccessoryType {
    @Bind("UITableViewCellAccessoryNone") NONE,
    @Bind("UITableViewCellAccessoryDisclosureIndicator") DISCLOSURE_INDICATOR,
    @Bind("UITableViewCellAccessoryDetailDisclosureButton") DETAIL_DISCLOSURE_BUTTON,
    @Bind("UITableViewCellAccessoryCheckmark") CHECKMARK
}
