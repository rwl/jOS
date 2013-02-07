package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIBarButtonItemStyle {
    @Bind("UIBarButtonItemStylePlain") PLAIN,
    @Bind("UIBarButtonItemStyleBordered") BORDERED,
    @Bind("UIBarButtonItemStyleDone") DONE
}
