package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITableViewStyle {
    @Bind("UITableViewStylePlain") PLAIN,
    @Bind("UITableViewStyleGrouped") GROUPED
}
