package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UITextFieldViewMode {
    @Bind("UITextFieldViewModeNever") NEVER,
    @Bind("UITextFieldViewModeWhileEditing") WHILE_EDITING,
    @Bind("UITextFieldViewModeUnlessEditing") UNLESS_EDITING,
    @Bind("UITextFieldViewModeAlways") ALWAYS;
}
