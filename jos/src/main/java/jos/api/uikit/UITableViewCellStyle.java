package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITableViewCellStyle {
    @Bind("UITableViewCellStyleDefault") DEFAULT,
    @Bind("UITableViewCellStyleValue1") VALUE1,
    @Bind("UITableViewCellStyleValue2") VALUE2,
    @Bind("UITableViewCellStyleSubtitle") SUBTITLE
}
