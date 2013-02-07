package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIButtonType {
    @Bind("UIButtonTypeCustom") CUSTOM,
    @Bind("UIButtonTypeRoundedRect") ROUNDED_RECT,

    @Bind("UIButtonTypeDetailDisclosure") DETAIL_DISCLOSURE,
    @Bind("UIButtonTypeInfoLight") INFO_LIGHT,
    @Bind("UIButtonTypeInfoDark") INFO_DARK,
    @Bind("UIButtonTypeContactAdd") CONTACT_ADD
}
