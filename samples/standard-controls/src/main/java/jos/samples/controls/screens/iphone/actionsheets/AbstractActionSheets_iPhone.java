package jos.samples.controls.screens.iphone.actionsheets;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractActionSheets_iPhone extends UIViewController {

    private UIView __mt_view;

    private UIButton __mt_btnSimpleActionSheet;

    private UIButton __mt_btnActionSheetWithOtherButtons;

    public AbstractActionSheets_iPhone() {
        super();
    }

    public AbstractActionSheets_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractActionSheets_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractActionSheets_iPhone(NSCoder coder) {
        super(coder);
    }

    @Connect("view")
    protected UIView view() {
        this.__mt_view = (UIView) getNativeField("view");
        return this.__mt_view;
    }

    @Connect("view")
    protected void setView(UIView value) {
        this.__mt_view = value;
        setNativeField("view", value);
    }

    @Connect("btnSimpleActionSheet")
    protected UIButton btnSimpleActionSheet() {
        this.__mt_btnSimpleActionSheet = (UIButton) getNativeField("btnSimpleActionSheet");
        return this.__mt_btnSimpleActionSheet;
    }

    @Connect("btnSimpleActionSheet")
    protected void setBtnSimpleActionSheet(UIButton value) {
        this.__mt_btnSimpleActionSheet = value;
        setNativeField("btnSimpleActionSheet", value);
    }

    @Connect("btnActionSheetWithOtherButtons")
    protected UIButton btnActionSheetWithOtherButtons() {
        this.__mt_btnActionSheetWithOtherButtons = (UIButton) getNativeField("btnActionSheetWithOtherButtons");
        return this.__mt_btnActionSheetWithOtherButtons;
    }

    @Connect("btnActionSheetWithOtherButtons")
    protected void setBtnActionSheetWithOtherButtons(UIButton value) {
        this.__mt_btnActionSheetWithOtherButtons = value;
        setNativeField("btnActionSheetWithOtherButtons", value);
    }
}