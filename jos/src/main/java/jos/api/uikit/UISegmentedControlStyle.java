package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UISegmentedControlStyle {
    @Bind("UISegmentedControlStylePlain") PLAIN,
    @Bind("UISegmentedControlStyleBordered") BORDERED,
    @Bind("UISegmentedControlStyleBar") BAR,
    @Bind("UISegmentedControlStyleBezeled") BEZELED
}
