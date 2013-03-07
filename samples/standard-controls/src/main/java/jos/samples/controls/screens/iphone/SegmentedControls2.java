package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.foundation.NSObject;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UISegmentedControl;
import jos.api.uikit.UISegmentedControlStyle;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Selector;

public class SegmentedControls2 extends UIViewController {

    UISegmentedControl segControl1;

    public SegmentedControls2() {
        super("SegmentedControls2_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Programmatic Segmented Controls");

        segControl1 = new UISegmentedControl();
        segControl1.setSegmentedControlStyle(UISegmentedControlStyle.BORDERED);
        segControl1.insertSegment("One", 0, false);
        segControl1.insertSegment("Two", 1, false);
        segControl1.setWidth(100f, 1);
        segControl1.setSelectedSegment(1);
        segControl1.setFrame(makeRect(20, 20, 280, 44));
        getView().addSubview(segControl1);

        /*segControl1.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                System.out.println("Item "
                        + ((UISegmentedControl) sender).selectedSegment
                        + " selected");
            }
        }, UIControlEvent.VALUE_CHANGED);*/
        segControl1.addTarget(this, new Selector("handleSegmentedControl1:"),
                UIControlEvent.VALUE_CHANGED);
    }

	@Export("handleSegmentedControl1:")
	protected void handleSegmentedControl1(NSObject sender) {
		new UIAlertView("Segment changed", "Item "
				+ (((UISegmentedControl) sender).getSelectedSegment() + 1)
				+ " selected", null, "OK", null).show();
	}

}
