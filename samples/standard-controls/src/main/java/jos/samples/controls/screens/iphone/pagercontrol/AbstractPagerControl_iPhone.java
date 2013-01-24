package jos.samples.controls.screens.iphone.pagercontrol;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIPageControl;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractPagerControl_iPhone extends UIViewController {

    private UIView __jos_view;

    private UIPageControl __jos_pgrMain;

    private UIScrollView __jos_scrlMain;

    public AbstractPagerControl_iPhone() {
        super();
    }

    public AbstractPagerControl_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractPagerControl_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractPagerControl_iPhone(NSCoder coder) {
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

    @Connect("pgrMain")
    protected UIPageControl pgrMain() {
        this.__jos_pgrMain = (UIPageControl) getNativeField("pgrMain");
        return this.__jos_pgrMain;
    }

    @Connect("pgrMain")
    protected void setPgrMain(UIPageControl value) {
        this.__jos_pgrMain = value;
        setNativeField("pgrMain", value);
    }

    @Connect("scrlMain")
    protected UIScrollView scrlMain() {
        this.__jos_scrlMain = (UIScrollView) getNativeField("scrlMain");
        return this.__jos_scrlMain;
    }

    @Connect("scrlMain")
    protected void setScrlMain(UIScrollView value) {
        this.__jos_scrlMain = value;
        setNativeField("scrlMain", value);
    }
}