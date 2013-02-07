package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Register(isWrapper = true)
public class UIPickerViewModel extends NSObject {

    @Export("pickerView:numberOfRowsInComponent:")
    public int getRowsInComponent(UIPickerView picker, int component) {
        return 0;
    }

    @Export("pickerView:titleForRow:forComponent:")
    public String getTitle(UIPickerView picker, int row, int component) {
        return null;
    }

    @Export("numberOfComponentsInPickerView:")
    public int getComponentCount(UIPickerView picker) {
        return 0;
    }

    @Export("pickerView:didSelectRow:inComponent:")
    public void selected(UIPickerView picker, int row, int component) {
    }

}
