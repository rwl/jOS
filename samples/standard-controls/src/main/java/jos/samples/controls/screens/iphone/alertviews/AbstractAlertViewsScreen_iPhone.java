package jos.samples.controls.screens.iphone.alertviews;

import com.google.j2objc.annotations.Connect;

import jos.api.foundation.NSBundle;
import jos.api.foundation.NSCoder;
import jos.api.system.IntPtr;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

public class AbstractAlertViewsScreen_iPhone extends UIViewController {

    private UIView __mt_view;

    private UIButton __mt_btnCustomButtons;

    private UIButton __mt_btnSimpleAlert;

    private UIButton __mt_btnCustomButtonsWithDelegate;

    private UIButton __mt_btnCustomAlert;

    public AbstractAlertViewsScreen_iPhone() {
        super();
    }

    public AbstractAlertViewsScreen_iPhone(String nibName, NSBundle bundle) {
        super(nibName, bundle);
    }

    public AbstractAlertViewsScreen_iPhone(IntPtr handle) {
        super(handle);
    }

    public AbstractAlertViewsScreen_iPhone(NSCoder coder) {
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

    @Connect("btnCustomButtons")
    protected UIButton btnCustomButtons() {
        this.__mt_btnCustomButtons = (UIButton) getNativeField("btnCustomButtons");
        return this.__mt_btnCustomButtons;
    }

    @Connect("btnCustomButtons")
    protected void setBtnCustomButtons(UIButton value) {
        this.__mt_btnCustomButtons = value;
        setNativeField("btnCustomButtons", value);
    }

    @Connect("btnSimpleAlert")
    protected UIButton btnSimpleAlert() {
        this.__mt_btnSimpleAlert = (UIButton) getNativeField("btnSimpleAlert");
        return this.__mt_btnSimpleAlert;
    }

    @Connect("btnSimpleAlert")
    protected void setBtnSimpleAlert(UIButton value) {
        this.__mt_btnSimpleAlert = value;
        setNativeField("btnSimpleAlert", value);
    }

    @Connect("btnCustomButtonsWithDelegate")
    protected UIButton btnCustomButtonsWithDelegate() {
        this.__mt_btnCustomButtonsWithDelegate = (UIButton) getNativeField("btnCustomButtonsWithDelegate");
        return this.__mt_btnCustomButtonsWithDelegate;
    }

    @Connect("btnCustomButtonsWithDelegate")
    protected void setBtnCustomButtonsWithDelegate(UIButton value) {
        this.__mt_btnCustomButtonsWithDelegate = value;
        setNativeField("btnCustomButtonsWithDelegate", value);
    }

    @Connect("btnCustomAlert")
    protected UIButton btnCustomAlert() {
        this.__mt_btnCustomAlert = (UIButton) getNativeField("btnCustomAlert");
        return this.__mt_btnCustomAlert;
    }

    @Connect("btnCustomAlert")
    protected void setBtnCustomAlert(UIButton value) {
        this.__mt_btnCustomAlert = value;
        setNativeField("btnCustomAlert", value);
    }
}