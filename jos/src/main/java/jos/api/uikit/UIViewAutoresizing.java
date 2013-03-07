package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class UIViewAutoresizing {

    @Bind("UIViewAutoresizingNone")
    public static final int NONE = 0;

    @Bind("UIViewAutoresizingFlexibleLeftMargin")
    public static final int FLEXIBLE_LEFT_MARGIN = 1 << 0;

    @Bind("UIViewAutoresizingFlexibleWidth")
    public static final int FLEXIBLE_WIDTH = 1 << 1;

    @Bind("UIViewAutoresizingFlexibleRightMargin")
    public static final int FLEXIBLE_RIGHT_MARGIN = 1 << 2;

    @Bind("UIViewAutoresizingFlexibleTopMargin")
    public static final int FLEXIBLE_TOP_MARGIN = 1 << 3;

    @Bind("UIViewAutoresizingFlexibleHeight")
    public static final int FLEXIBLE_HEIGHT = 1 << 4;

    @Bind("UIViewAutoresizingFlexibleBottomMargin")
    public static final int FLEXIBLE_BOTTOM_MARGIN = 1 << 5;

}
