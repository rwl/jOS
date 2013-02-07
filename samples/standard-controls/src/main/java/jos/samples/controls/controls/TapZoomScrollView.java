package jos.samples.controls.controls;

import jos.api.foundation.NSSet;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UITouch;

public class TapZoomScrollView extends UIScrollView {

    public TapZoomScrollView(CGRect frame) {
        super(frame);
    }

    @Override
    public void touchesBegan(NSSet touches, UIEvent evt) {
        super.touchesBegan(touches, evt);

        UITouch touch = (UITouch) touches.anyObject();

        if (touch.tapCount == 2) {
            setZoomScale(zoomScale >= 2 ? 1 : 3, true);
        }
    }

}
