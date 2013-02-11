package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIPickerView extends UIView {

    public UIPickerViewDataSource dataSource;
    public UIPickerViewDelegate delegate;

    @Export("dataSource")
    public UIPickerViewDataSource getDataSource() {
        return dataSource;
    }

    @Export("setDataSource:")
    public void setDataSource(UIPickerViewDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Export("delegate")
    public UIPickerViewDelegate getDelegate() {
        return delegate;
    }

    @Export("setDelegate:")
    public void setDelegate(UIPickerViewDelegate delegate) {
        this.delegate = delegate;
    }

}
