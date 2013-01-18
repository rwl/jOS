package jos.api.uikit;

import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.NSText.NSTextAlignment;

public class UILabel extends UIView {

    public String text;
    public NSTextAlignment textAlignment;

    public UILabel(CGRect frame) {
        super(frame);
    }

}
