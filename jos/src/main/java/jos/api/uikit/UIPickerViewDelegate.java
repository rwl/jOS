package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public class UIPickerViewDelegate extends NSObject {

    @Export("pickerView:titleForRow:forComponent:")
    public String getRowTitle(UIPickerView picker, int row, int component) {
        return null;
    }

    @Export("pickerView:didSelectRow:inComponent:")
    public void selectedRow(UIPickerView picker, int row, int component) {
    }

}
