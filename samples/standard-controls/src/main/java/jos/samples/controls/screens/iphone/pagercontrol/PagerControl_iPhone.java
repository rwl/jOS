package jos.samples.controls.screens.iphone.pagercontrol;

import java.util.ArrayList;
import java.util.List;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

import jos.api.foundation.NSCoder;
import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGGeometry;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.system.IntPtr;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIPageControl;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIScrollViewDelegate;
import jos.api.uikit.UIViewController;

public class PagerControl_iPhone extends UIViewController {

    @Outlet UIPageControl pgrMain;
    @Outlet UIScrollView scrlMain;

    /**
     * A list of all our controllers that hold the views for our pages
     */
    List<UIViewController> controllers = new ArrayList<UIViewController>();

    public PagerControl_iPhone(IntPtr handle) {
        super(handle);
    }

    @Export(selector = "initWithCoder:")
    public PagerControl_iPhone(NSCoder coder) {
        super(coder);
    }

    public PagerControl_iPhone() {
        super("PagerControl_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set our title
        title = "Pager Control";

        // wire up our pager and scroll view event handlers
        pgrMain.addTarget(this, new Selector("handlePgrMainValueChanged"),
                UIControlEvent.ValueChanged);
        scrlMain.delegate = new UIScrollViewDelegate() {

            @Override
            public void scrolled(UIScrollView view) {
                handleScrlMainScrolled();
            }
        };

        // load our controllers (we'll use one per page)
        loadControllers();
    }

    /**
     * Runs when the scroll view is scrolled. Updates the pager control so that
     * it's current, based on the page
     */
    protected void handleScrlMainScrolled() {
        // calculate the page number
        int pageNumber = (int) (Math
                .floor((scrlMain.contentOffset.x - scrlMain.frame.size.width / 2)
                        / scrlMain.frame.size.width) + 1);

        // if it's a valid page
        if (pageNumber >= 0 && pageNumber < controllers.size()) {
            // Set the current page on the pager control
            pgrMain.currentPage = pageNumber;
        }
    }

    /**
     * Runs when a dot on the pager is clicked. Scrolls the scroll view to the
     * appropriate page, based on which one was clicked
     */
    protected void handlePgrMainValueChanged(NSObject sender, UIEvent e) {
        // it moves page by page. we scroll right to the next controller
        scrlMain.scrollRectToVisible(
                controllers.get(((UIPageControl) sender).currentPage).view.frame,
                true);
    }

    /**
     * Loads our controllers that we'll use for each page. Also sets the content
     * size of the scroll view based on the number of controllers we add
     */
    protected void loadControllers() {
        // instantiate and add the controllers to our list
        controllers.add(new Controller_1());
        controllers.add(new Controller_2());
        controllers.add(new Controller_3());

        // loop through each one
        for (int i = 0; i < controllers.size(); i++) {
            // set their location and size, each one is moved to the
            // right by the width of the previous
            CGRect viewFrame = CGGeometry.CGRectMake(scrlMain.frame.size.width
                    * i, scrlMain.frame.point.y, scrlMain.frame.size.width,
                    scrlMain.frame.size.height);
            controllers.get(i).view.frame = viewFrame;

            // add the view to the scrollview
            scrlMain.addSubview(controllers.get(i).view);
        }

        // set our scroll view content size (width = number of pages * scroll
        // view width)
        scrlMain.contentSize = new CGSize(scrlMain.frame.size.width
                * controllers.size(), scrlMain.frame.size.height);
    }

}
