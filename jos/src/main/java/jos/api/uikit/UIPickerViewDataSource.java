package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

import jos.api.foundation.NSObject;

@Model
@Register(isWrapper = true)
public class UIPickerViewDataSource extends NSObject {

    @Export("pickerView:numberOfRowsInComponent:")
    public int getRowsInComponent(UIPickerView picker, int component) {
        return 0;
    }

    @Export("numberOfComponentsInPickerView:")
    public int getComponentCount(UIPickerView picker) {
        return 0;
    }

}
