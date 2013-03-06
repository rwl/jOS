package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIViewContentMode {
    @Bind("UIViewContentModeScaleToFill") ScaleToFill,
    @Bind("UIViewContentModeScaleAspectFit") ScaleAspectFit,
    @Bind("UIViewContentModeScaleAspectFill") ScaleAspectFill,
    @Bind("UIViewContentModeRedraw") Redraw,
    @Bind("UIViewContentModeCenter") Center,
    @Bind("UIViewContentModeTop") Top,
    @Bind("UIViewContentModeBottom") Bottom,
    @Bind("UIViewContentModeLeft") Left,
    @Bind("UIViewContentModeRight") Right,
    @Bind("UIViewContentModeTopLeft") TopLeft,
    @Bind("UIViewContentModeTopRight") TopRight,
    @Bind("UIViewContentModeBottomLeft") BottomLeft,
    @Bind("UIViewContentModeBottomRight") BottomRight;
}
