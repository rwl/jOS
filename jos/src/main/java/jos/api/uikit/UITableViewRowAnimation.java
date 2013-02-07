package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UITableViewRowAnimation {
    @Bind("UITableViewRowAnimationFade") FADE,
    @Bind("UITableViewRowAnimationRight") RIGHT,
    @Bind("UITableViewRowAnimationLeft") LEFT,
    @Bind("UITableViewRowAnimationTop") TOP,
    @Bind("UITableViewRowAnimationBottom") BOTTOM,
    @Bind("UITableViewRowAnimationNone") NONE,
    @Bind("UITableViewRowAnimationMiddle") MIDDLE,
    @Bind("UITableViewRowAnimationAutomatic") AUTOMATIC
}
