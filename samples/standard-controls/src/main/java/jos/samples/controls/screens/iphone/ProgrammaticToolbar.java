package jos.samples.controls.screens.iphone;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIBarButtonItemStyle;
import jos.api.uikit.UIBarButtonSystemItem;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIView;
import jos.api.uikit.UIViewAutoresizing;
import jos.api.uikit.UIViewController;

import com.google.j2objc.annotations.Outlet;
import com.google.j2objc.annotations.Selector;

public class ProgrammaticToolbar extends UIViewController {

    @Outlet
    UIView view;

    UIToolbar toolbar;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Programmatic Toolbar");

        // set the background color of the view to white
        view.setBackgroundColor(UIColor.WHITE);

        // new up the toolbar
        float toolbarHeight = 44;
        toolbar = new UIToolbar(makeRect(0, this.view.frame.size.height
                - this.navigationController.navigationBar.frame.size.height,
                this.view.frame.size.width, toolbarHeight));
        toolbar.autoresizingMask = UIViewAutoresizing.FLEXIBLE_TOP_MARGIN
                .mask() | UIViewAutoresizing.FLEXIBLE_WIDTH.mask();

        // button one
        String buttonTitle = "One";
        UIBarButtonItem btnOne = new UIBarButtonItem(buttonTitle,
                UIBarButtonItemStyle.BORDERED, null, null);
        btnOne.setTarget(this);
        btnOne.setAction(new Selector("onButtonOne"));

        // fixed width
        UIBarButtonItem fixedWidth = new UIBarButtonItem(
                UIBarButtonSystemItem.FIXED_SPACE, null, null);
        fixedWidth.setWidth(25);

        // button two
        UIBarButtonItem btnTwo = new UIBarButtonItem("second",
                UIBarButtonItemStyle.BORDERED, null, null);

        // flexible width space
        UIBarButtonItem flexibleWidth = new UIBarButtonItem(
                UIBarButtonSystemItem.FLEXIBLE_SPACE, null, null);

        // button three
        UIBarButtonItem btnThree = new UIBarButtonItem("3",
                UIBarButtonItemStyle.BORDERED, null, null);

        // button four
        UIBarButtonItem btnFour = new UIBarButtonItem("another!",
                UIBarButtonItemStyle.BORDERED, null, null);

        // create the items array
        UIBarButtonItem[] items = new UIBarButtonItem[] { btnOne, fixedWidth,
                btnTwo, flexibleWidth, btnThree, btnFour };

        // add the items to the toolbar
        toolbar.setItems(items, false);

        // add the toolbar to the page
        view.addSubview(toolbar);
    }

    protected void onButtonOne() {
        new UIAlertView("click!", "btnOne clicked", null, "OK").show();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        return true;
    }

}
