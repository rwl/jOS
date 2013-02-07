package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UISegmentedControl extends UIControl {

    public UISegmentedControlStyle controlStyle;

    public int selectedSegment;

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

    @Export("selectedSegment")
    public int getSelectedSegment() {
        return selectedSegment;
    }

    @Export("setSelectedSegment:")
    public void setSelectedSegment(int selectedSegment) {
        this.selectedSegment = selectedSegment;
    }

}
