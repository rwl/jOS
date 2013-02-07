package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;

import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UISegmentedControl;
import jos.api.uikit.UISegmentedControlStyle;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.EventListener;
import com.google.j2objc.annotations.Outlet;

public class SegmentedControls2 extends UIViewController {

    @Outlet
    UIView view;

    UISegmentedControl segControl1;

    public SegmentedControls2() {
        super("SegmentedControls2_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Programmatic Segmented Controls");

        segControl1 = new UISegmentedControl();
        segControl1.setControlStyle(UISegmentedControlStyle.BORDERED);
        segControl1.insertSegment("One", 0, false);
        segControl1.insertSegment("Two", 1, false);
        segControl1.setWidth(100f, 1);
        segControl1.setSelectedSegment(1);
        segControl1.setFrame(makeRect(20, 20, 280, 44));
        view.addSubview(segControl1);

        segControl1.addTarget(new EventListener() {
            @Override
            public void onEvent(Object sender, int event) {
                System.out.println("Item "
                        + ((UISegmentedControl) sender).selectedSegment
                        + " selected");
            }
        }, UIControlEvent.VALUE_CHANGED);
    }

}
