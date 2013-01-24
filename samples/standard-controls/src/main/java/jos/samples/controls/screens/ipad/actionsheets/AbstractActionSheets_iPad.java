package jos.samples.controls.screens.ipad.actionsheets;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public abstract class AbstractActionSheets_iPad extends UIViewController {

    private UIView __jos_view;
    private UIButton __jos_btnActionSheetWithOtherButtons;
    private UIButton __jos_btnSimpleActionSheet;

    public AbstractActionSheets_iPad() {
        super();
    }

    public AbstractActionSheets_iPad(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractActionSheets_iPad(IntPtr handle) {
        super(handle);
    }

    public AbstractActionSheets_iPad(NSCoder coder) {
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

    @Connect("btnActionSheetWithOtherButtons")
    protected UIButton btnActionSheetWithOtherButtons() {
        this.__jos_btnActionSheetWithOtherButtons = ((UIButton) (getNativeField("btnActionSheetWithOtherButtons")));
        return this.__jos_btnActionSheetWithOtherButtons;
    }

    @Connect("btnActionSheetWithOtherButtons")
    protected void setBtnActionSheetWithOtherButtons(UIButton value) {
        this.__jos_btnActionSheetWithOtherButtons = value;
        setNativeField("btnActionSheetWithOtherButtons", value);
    }

    @Connect("btnSimpleActionSheet")
    protected UIButton btnSimpleActionSheet() {
        this.__jos_btnSimpleActionSheet = ((UIButton) (getNativeField("btnSimpleActionSheet")));
        return this.__jos_btnSimpleActionSheet;
    }

    @Connect("btnSimpleActionSheet")
    protected void setBtnSimpleActionSheet(UIButton value) {
        this.__jos_btnSimpleActionSheet = value;
        setNativeField("btnSimpleActionSheet", value);
    }

}