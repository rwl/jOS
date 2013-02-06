package jos.samples.controls.screens.iphone;

import com.google.j2objc.annotations.Selector;

import jos.api.graphicsimaging.CGGeometry;
import jos.api.uikit.UIAlertView;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIBarButtonItemStyle;
import jos.api.uikit.UIBarButtonSystemItem;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIToolbar;
import jos.api.uikit.UIViewAutoresizing;
import jos.api.uikit.UIViewController;

public class ProgrammaticToolbar_Controller extends UIViewController {

    UIToolbar toolbar;

    public ProgrammaticToolbar_Controller() {
        super();
    }

    @Override
    public void viewDidLoad () {
        super.viewDidLoad ();

        this.title = "Programmatic Toolbar";

        // set the background color of the view to white
        this.view.backgroundColor = UIColor.white;

        // new up the toolbar
        float toolbarHeight = 44;
        toolbar = new UIToolbar(CGGeometry.CGRectMake(0,
                this.view.frame.size.height - this.navigationController.navigationBar.frame.size.height,
                this.view.frame.size.width, toolbarHeight));
        toolbar.autoresizingMask = /*UIViewAutoresizing.FlexibleTopMargin |*/ UIViewAutoresizing.FlexibleWidth;


        // button one
        String buttonTitle = "One";
        UIBarButtonItem btnOne = new UIBarButtonItem(buttonTitle, UIBarButtonItemStyle.Bordered, null);
        btnOne.target = this;
        btnOne.action = new Selector("onButtonOne");

        // fixed width
        UIBarButtonItem fixedWidth = new UIBarButtonItem(UIBarButtonSystemItem.FixedSpace);
        fixedWidth.width = 25;

        // button two
        UIBarButtonItem btnTwo = new UIBarButtonItem("second", UIBarButtonItemStyle.Bordered, null);

        // flexible width space
        UIBarButtonItem flexibleWidth = new UIBarButtonItem(UIBarButtonSystemItem.FlexibleSpace);

        // button three
        UIBarButtonItem btnThree = new UIBarButtonItem("3", UIBarButtonItemStyle.Bordered, null);

        // button four
        UIBarButtonItem btnFour = new UIBarButtonItem("another!", UIBarButtonItemStyle.Bordered, null);

        // create the items array
        UIBarButtonItem[] items = new UIBarButtonItem[] {
            btnOne, fixedWidth, btnTwo, flexibleWidth, btnThree, btnFour };

        // add the items to the toolbar
        toolbar.setItems(items, false);

        // add the toolbar to the page
        this.view.addSubview(toolbar);
    }

    protected void onButtonOne() {
        new UIAlertView("click!", "btnOne clicked", null, "OK", null).show();
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        return true;
    }
}
