package jos.api.foundation;

import com.google.j2objc.annotations.Bind;

public enum NSDateFormatterStyle {
    @Bind("NSDateFormatterNoStyle") NO_STYLE,
    @Bind("NSDateFormatterShortStyle") SHORT,
    @Bind("NSDateFormatterMediumStyle") MEDIUM,
    @Bind("NSDateFormatterLongStyle") LONG,
    @Bind("NSDateFormatterFullStyle") FULL;
}
