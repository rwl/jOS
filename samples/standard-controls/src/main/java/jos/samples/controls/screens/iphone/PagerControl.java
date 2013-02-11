package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;

import java.util.ArrayList;
import java.util.List;

import jos.api.foundation.NSObject;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIPageControl;
import jos.api.uikit.UIScrollView;
import jos.api.uikit.UIScrollViewDelegate;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class PagerControl extends UIViewController {

    @Outlet
    UIPageControl pgrMain;

    @Outlet
    UIScrollView scrlMain;

    /**
     * A list of all our controllers that hold the views for our pages
     */
    private List<UIViewController> controllers = new ArrayList<UIViewController>();

    public PagerControl() {
        super("PagerControl_iPhone", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // set our title
        setTitle("Pager Control");

        // wire up our pager and scroll view event handlers
        pgrMain.addTarget(this, new Selector("handlePgrMainValueChanged:"),
                UIControlEvent.VALUE_CHANGED);
        scrlMain.setDelegate(new UIScrollViewDelegate() {
            @Override
            public void scrolled(UIScrollView view) {
                handleScrlMainScrolled();
            }
        });

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
                .floor((scrlMain.getContentOffset().x - scrlMain.getFrame().size.width / 2)
                        / scrlMain.getFrame().size.width) + 1);

        // if it's a valid page
        if (pageNumber >= 0 && pageNumber < controllers.size()) {
            // Set the current page on the pager control
            pgrMain.setCurrentPage(pageNumber);
        }
    }

    /**
     * Runs when a dot on the pager is clicked. Scrolls the scroll view to the
     * appropriate page, based on which one was clicked
     */
    @Export("handlePgrMainValueChanged:")
    protected void handlePgrMainValueChanged(NSObject sender) {
        // it moves page by page. we scroll right to the next controller
        scrlMain.scrollRectToVisible(
                controllers.get(((UIPageControl) sender).getCurrentPage())
                        .getView().getFrame(), true);
    }

    /**
     * Loads our controllers that we'll use for each page. Also sets the content
     * size of the scroll view based on the number of controllers we add
     */
    protected void loadControllers() {
        // instantiate and add the controllers to our list
        controllers.add(new PagerController1());
        controllers.add(new PagerController2());
        controllers.add(new PagerController3());

        // loop through each one
        for (int i = 0; i < controllers.size(); i++) {
            // set their location and size, each one is moved to the
            // right by the width of the previous
            CGRect viewFrame = makeRect(scrlMain.getFrame().size.width * i,
                    scrlMain.getFrame().point.y,
                    scrlMain.getFrame().size.width,
                    scrlMain.getFrame().size.height);
            controllers.get(i).getView().setFrame(viewFrame);

            // add the view to the scrollview
            scrlMain.addSubview(controllers.get(i).getView());
        }

        // set our scroll view content size (width = number of pages * scroll
        // view width)
        scrlMain.setContentSize(new CGSize(scrlMain.getFrame().size.width
                * controllers.size(), scrlMain.getFrame().size.height));
    }

}
