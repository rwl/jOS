package jos.samples.controls.screens.iphone.images;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIImageView;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractImages_iPhone extends UIViewController {

    private UIView __jos_view;

    private UIImageView __jos_imgMain;

    public AbstractImages_iPhone() {
        super();
    }

    public AbstractImages_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractImages_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractImages_iPhone(NSCoder coder) {
        super(coder);
    }

    @Connect("view")
    protected UIView view() {
        this.__jos_view = ((UIView) (getNativeField("view")));
        return this.__jos_view;
    }

    @Connect("view")
    protected void setView(UIView value) {
        this.__jos_view = value;
        setNativeField("view", value);
    }

    @Connect("imgMain")
    protected UIImageView imgMain() {
        this.__jos_imgMain = (UIImageView) getNativeField("imgMain");
        return this.__jos_imgMain;
    }

    @Connect("imgMain")
    protected void setImgMain(UIImageView value) {
        this.__jos_imgMain = value;
        setNativeField("imgMain", value);
    }
}