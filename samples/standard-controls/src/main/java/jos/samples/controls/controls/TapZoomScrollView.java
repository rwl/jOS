package jos.samples.controls.controls;

import jos.api.foundation.NSCoder;
import jos.api.foundation.NSSet;
import jos.api.graphicsimaging.CGRect;
import jos.api.system.IntPtr;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UITouch;

import com.google.j2objc.annotations.Export;

public class TapZoomScrollView extends UIScrollView {

    public TapZoomScrollView(IntPtr handle) {
        super(handle);
    }

    @Export(selector = "initWithCoder:")
    public TapZoomScrollView(NSCoder coder) {
        super(coder);
    }

    public TapZoomScrollView() {
        super();
    }

    public TapZoomScrollView(CGRect frame) {
        super(frame);
    }

    @Override
    public void touchesBegan(NSSet touches, UIEvent evt) {
        super.touchesBegan(touches, evt);

        UITouch touch = (UITouch) touches.anyObject();

        if (touch.tapCount == 2) {
            if (zoomScale >= 2) {
                setZoomScale(1, true);
            } else {
                setZoomScale(3, true);
            }
        }
    }
}
