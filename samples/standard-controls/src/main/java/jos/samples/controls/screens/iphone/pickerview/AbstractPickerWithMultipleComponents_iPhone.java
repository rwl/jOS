package jos.samples.controls.screens.iphone.pickerview;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIPickerView;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractPickerWithMultipleComponents_iPhone extends
        UIViewController {

    private UIView __jos_view;

    private UILabel __mt_lblSelectedItem;

    private UIPickerView __mt_pkrMain;

    public AbstractPickerWithMultipleComponents_iPhone() {
        super();
    }

    public AbstractPickerWithMultipleComponents_iPhone(String nibName,
            NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractPickerWithMultipleComponents_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractPickerWithMultipleComponents_iPhone(NSCoder coder) {
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
        this.__mt_lblSelectedItem = (UILabel) getNativeField("lblSelectedItem");
        return this.__mt_lblSelectedItem;
    }

    @Connect("lblSelectedItem")
    protected void setLblSelectedItem(UILabel value) {
        this.__mt_lblSelectedItem = value;
        setNativeField("lblSelectedItem", value);
    }

    @Connect("pkrMain")
    protected UIPickerView pkrMain() {
        this.__mt_pkrMain = (UIPickerView) getNativeField("pkrMain");
        return this.__mt_pkrMain;
    }

    @Connect("pkrMain")
    protected void setPkrMain(UIPickerView value) {
        this.__mt_pkrMain = value;
        setNativeField("pkrMain", value);
    }
}