package jos.samples.controls.screens.iphone.toolbar;

import jos.api.graphicsimaging.CGGeometry;
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
                this.view.frame.height - this.navigationController.navigationBar.frame.height,
                this.view.frame.width, toolbarHeight));
        toolbar.autoresizingMask = UIViewAutoresizing.FlexibleTopMargin | UIViewAutoresizing.FlexibleWidth;


        // button one
        String buttonTitle = "One";
        UIBarButtonItem btnOne = new UIBarButtonItem(buttonTitle, UIBarButtonItemStyle.Bordered, null);
        btnOne.Clicked += (s, e) => {
            new UIAlertView("click!", "btnOne clicked", null, "OK", null).show();
        };

        // fixed width
        UIBarButtonItem fixedWidth = new UIBarButtonItem(UIBarButtonSystemItem.FixedSpace);
        fixedWidth.Width = 25;

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

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation toInterfaceOrientation) {
        return true;
    }
}
