package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITableViewCellSeparatorStyle {
    @Bind("UITableViewCellSeparatorStyleNone") NONE,
    @Bind("UITableViewCellSeparatorStyleSingleLine") SINGLE_LINE,
    @Bind("UITableViewCellSeparatorStyleSingleLineEtched") SINGLE_LINE_ETCHED
}
