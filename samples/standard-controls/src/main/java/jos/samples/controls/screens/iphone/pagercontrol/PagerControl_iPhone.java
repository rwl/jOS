package jos.samples.controls.screens.iphone.pagercontrol;

import java.util.List;

import com.google.j2objc.annotations.Export;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIViewController;

public class PagerControl_iPhone extends UIViewController {

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
        pgrMain.valueChanged += handlePgrMainValueChanged;
        scrlMain.scrolled += handleScrlMainScrolled;

        // load our controllers (we'll use one per page)
        loadControllers();
    }

    /**
     * Runs when the scroll view is scrolled. Updates the pager control so that
     * it's current, based on the page
     */
    protected void handleScrlMainScrolled(Object sender, EventArgs e) {
        // calculate the page number
        int pageNumber = (int) (Math
                .floor((scrlMain.contentOffset.x - scrlMain.frame.width / 2)
                        / scrlMain.frame.width) + 1);

        // if it's a valid page
        if (pageNumber >= 0 && pageNumber < controllers.count) {
            // Set the current page on the pager control
            pgrMain.currentPage = pageNumber;
        }
    }

    /**
     * Runs when a dot on the pager is clicked. Scrolls the scroll view to the
     * appropriate page, based on which one was clicked
     */
    protected void handlePgrMainValueChanged(Object sender, EventArgs e) {
        // it moves page by page. we scroll right to the next controller
        scrlMain.scrollRectToVisible(
                controllers[((UIPageControl) sender).currentPage].view.frame,
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
        for (int i = 0; i < controllers.count; i++) {
            // set their location and size, each one is moved to the
            // right by the width of the previous
            CGRect viewFrame = CGGeometry.CGRectMake(scrlMain.frame.width * i,
                    scrlMain.frame.y, scrlMain.frame.width,
                    scrlMain.frame.height);
            controllers[i].view.frame = viewFrame;

            // add the view to the scrollview
            scrlMain.addSubview(controllers[i].view);
        }

        // set our scroll view content size (width = number of pages * scroll
        // view width)
        scrlMain.contentSize = new SizeF(scrlMain.Frame.Width
                * controllers.count, scrlMain.frame.height);
    }
}
