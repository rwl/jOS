package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIActionSheetStyle {
    @Bind("UIActionSheetStyleAutomatic") AUTOMATIC,
    @Bind("UIActionSheetStyleDefault") DEFAULT,
    @Bind("UIActionSheetStyleBlackTranslucent") BLACK_TRANSLUCENT,
    @Bind("UIActionSheetStyleBlackOpaque") BLACK_OPAQUE
}
