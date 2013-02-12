package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISegmentedControl extends UIControl {

    public UISegmentedControlStyle controlStyle;

    public int selectedSegmentIndex;

    @Export("insertSegmentWithTitle:atIndex:animated:")
    public void insertSegment(String title, int pos, boolean animated) {
    }

    @Export("setWidth:forSegmentAtIndex:")
    public void setWidth(float width, int segment) {
    }

    @Export("controlStyle")
    public UISegmentedControlStyle getControlStyle() {
        return controlStyle;
    }

    @Export("setControlStyle:")
    public void setControlStyle(UISegmentedControlStyle controlStyle) {
        this.controlStyle = controlStyle;
    }

    @Export("selectedSegmentIndex")
    public int getSelectedSegmentIndex() {
        return selectedSegmentIndex;
    }

    @Export("setSelectedSegmentIndex:")
    public void setSelectedSegmentIndex(int selectedSegment) {
        this.selectedSegmentIndex = selectedSegment;
    }

}
