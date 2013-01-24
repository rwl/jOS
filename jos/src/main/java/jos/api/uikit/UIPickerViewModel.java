package jos.api.uikit;

import jos.api.foundation.NSObject;

public class UIPickerViewModel extends NSObject {

    public int getRowsInComponent(UIPickerView picker, int component) {
        return 0;
    }

    public String getTitle(UIPickerView picker, int row, int component) {
        return null;
    }

    public int getComponentCount(UIPickerView picker) {
        return 0;
    }

    public void selected(UIPickerView picker, int row, int component) {
    }
}
