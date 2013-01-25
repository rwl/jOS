package jos.samples.controls.screens.iphone.sliders;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UISlider;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractSliders_iPhone extends UIViewController {

    private UIView __jos_view;

    private UISlider __jos_sldrWithImages;

    public AbstractSliders_iPhone() {
        super();
    }

    public AbstractSliders_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractSliders_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractSliders_iPhone(NSCoder coder) {
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

    @Connect("sldrWithImages")
    protected UISlider sldrWithImages() {
        this.__jos_sldrWithImages = (UISlider) getNativeField("sldrWithImages");
        return this.__jos_sldrWithImages;
    }

    @Connect("sldrWithImages")
    protected void setSldrWithImages(UISlider value) {
        this.__jos_sldrWithImages = value;
        setNativeField("sldrWithImages", value);
    }
}