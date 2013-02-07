package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIPickerView extends UIView {

    public UIPickerViewModel source;
    public UIPickerViewModel model;

    @Export("source")
    public UIPickerViewModel getSource() {
        return source;
    }

    @Export("setSource:")
    public void setSource(UIPickerViewModel source) {
        this.source = source;
    }

    @Export("model")
    public UIPickerViewModel getModel() {
        return model;
    }

    @Export("setModel:")
    public void setModel(UIPickerViewModel model) {
        this.model = model;
    }

}
