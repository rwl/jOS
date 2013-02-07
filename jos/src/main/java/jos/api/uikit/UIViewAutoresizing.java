package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIViewAutoresizing {

    @Bind("UIViewAutoresizingNone")
    NONE (0),

    @Bind("UIViewAutoresizingFlexibleLeftMargin")
    FLEXIBLE_LEFT_MARGIN (1 << 0),

    @Bind("UIViewAutoresizingFlexibleWidth")
    FLEXIBLE_WIDTH (1 << 1),

    @Bind("UIViewAutoresizingFlexibleRightMargin")
    FLEXIBLE_RIGHT_MARGIN (1 << 2),

    @Bind("UIViewAutoresizingFlexibleTopMargin")
    FLEXIBLE_TOP_MARGIN (1 << 3),

    @Bind("UIViewAutoresizingFlexibleHeight")
    FLEXIBLE_HEIGHT (1 << 4),

    @Bind("UIViewAutoresizingFlexibleBottomMargin")
    FLEXIBLE_BOTTOM_MARGIN (1 << 5);

    private final int mask;

    private UIViewAutoresizing(int mask) {
        this.mask = mask;
    }

    public int mask() {
        return mask;
    }

}
