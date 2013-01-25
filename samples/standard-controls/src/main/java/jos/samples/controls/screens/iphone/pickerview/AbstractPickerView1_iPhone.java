package jos.samples.controls.screens.iphone.pickerview;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIPickerView;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractPickerView1_iPhone extends UIViewController {

    private UIView __jos_view;

    private UILabel __jos_lblSelectedItem;

    private UIPickerView __jos_pkrMain;

    public AbstractPickerView1_iPhone() {
        super();
    }

    public AbstractPickerView1_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractPickerView1_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractPickerView1_iPhone(NSCoder coder) {
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

    @Connect("lblSelectedItem")
    protected UILabel lblSelectedItem() {
        this.__jos_lblSelectedItem = (UILabel) getNativeField("lblSelectedItem");
        return this.__jos_lblSelectedItem;
    }

    @Connect("lblSelectedItem")
    protected void setLblSelectedItem(UILabel value) {
        this.__jos_lblSelectedItem = value;
        setNativeField("lblSelectedItem", value);
    }

    @Connect("pkrMain")
    protected UIPickerView pkrMain() {
        this.__jos_pkrMain = (UIPickerView) getNativeField("pkrMain");
        return this.__jos_pkrMain;
    }

    @Connect("pkrMain")
    protected void setPkrMain(UIPickerView value) {
        this.__jos_pkrMain = value;
        setNativeField("pkrMain", value);
    }
}