package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public class UIPopoverArrowDirection {
    @Bind("UIPopoverArrowDirectionUp")
    public static final int UP = 1 << 0;

    @Bind("UIPopoverArrowDirectionDown")
    public static final int DOWN = 1 << 1;

    @Bind("UIPopoverArrowDirectionLeft")
    public static final int LEFT = 1 << 2;

    @Bind("UIPopoverArrowDirectionRight")
    public static final int RIGHT = 1 << 3;

    @Bind("UIPopoverArrowDirectionAny")
    public static final int ANY = UP | DOWN | LEFT | RIGHT;

    @Bind("UIPopoverArrowDirectionUnknown")
    public static final int UNKNOWN = Integer.MAX_VALUE;
}
