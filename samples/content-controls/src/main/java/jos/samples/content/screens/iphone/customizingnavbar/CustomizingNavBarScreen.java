package jos.samples.content.screens.iphone.customizingnavbar;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UISwitch;
import jos.api.uikit.UIViewController;
import jos.samples.content.EventListener;

public class CustomizingNavBarScreen extends UIViewController {

    @Outlet
    UIButton btnChangeBarStyle;

    @Outlet
    UIButton btnChangeTintColor;

    @Outlet
    UIButton btnShowHideRightButton;

    @Outlet
    UISwitch swchTransparent;

    @Outlet
    UIButton btnShowToolbar;

    public CustomizingNavBarScreen() {
        super("CustomizingNavBarScreen", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        getNavigationItem().setTitle("Customizing Nav Bar");

        // toggle the navigation bar transparency
        swchTransparent.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                getNavigationController().getNavigationBar().setTranslucent(swchTransparent.isOn());
            }
        }, UIControlEvent.VALUE_CHANGED);

        // change the navigation bar color (toggles between default and red)
        btnChangeTintColor.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
             // if it's red, reset it by setting it to null
                if (getNavigationController().getNavigationBar().setTintColor(UIColor.RED)) {
                    getNavigationController().getNavigationBar().setTintColor(null);
                // otherwise, make it red
                } else {
                    getNavigationController().getNavigationBar().setTintColor(UIColor.RED));
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        // toggle the bar style between black and default
        btnChangeBarStyle.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if(getNavigationController().getNavigationBar().getBarStyle() == UIBarStyle.DEFAULT) {
                    getNavigationController().getNavigationBar().setBarStyle(UIBarStyle.BLACK);
                } else {
                    getNavigationController().getNavigationBar().setBarStyle(UIBarStyle.DEFAULT);
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        // show/hide the right bar button item
        btnShowHideRightButton.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if (getNavigationItem().getRightBarButtonItem() == null) {
                    getNavigationItem().setRightBarButtonItem(new UIBarButtonItem(UIBarButtonSystemItem.Action, null), true);
                } else {
                    getNavigationItem().setRightBarButtonItem(null, true);
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);

        // setup the toolbar items. the navigation controller gets the items from the controller
        // because they're specific to each controller on the stack, hence 'setToolbarItems' rather
        // than navigationController.toolbar.setToolbarItems
        setToolbarItems(new UIBarButtonItem[] {
                new UIBarButtonItem(UIBarButtonSystemItem.Refresh),
                new UIBarButtonItem(UIBarButtonSystemItem.FlexibleSpace) { Width = 50 },
                new UIBarButtonItem(UIBarButtonSystemItem.Pause)
            }, false);

        // toggle the display of the toolbar
        btnShowToolbar.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                getNavigationController().setToolbarHidden(!getNavigationController().isToolbarHidden());
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

}
