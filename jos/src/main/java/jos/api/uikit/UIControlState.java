package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIControlState {
    @Bind("UIControlStateNormal") NORMAL,
    @Bind("UIControlStateHighlighted") HIGHLIGHTED,
    @Bind("UIControlStateDisabled") DISABLED,
    @Bind("UIControlStateSelected") SELECTED,
    @Bind("UIControlStateApplication") APPLICATION,
    @Bind("UIControlStateReserved") RESERVED
}
