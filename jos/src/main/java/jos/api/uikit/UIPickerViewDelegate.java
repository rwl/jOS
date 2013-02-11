package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Model
@Register(isWrapper = true)
public class UIPickerViewDelegate extends NSObject {

    @Export("pickerView:titleForRow:forComponent:")
    public String getTitle(UIPickerView picker, int row, int component) {
        return null;
    }

    @Export("pickerView:didSelectRow:inComponent:")
    public void selected(UIPickerView picker, int row, int component) {
    }

}
