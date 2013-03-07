package jos.samples.animation.screens;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIViewController;

public class BackTransitionViewController extends UIViewController implements IDetailView {

    @Outlet
    UIButton btnBack;

    EventListener backClicked;

    public BackTransitionViewController() {
        super("BackTransitionViewController", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        btnBack.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if (backClicked != null) {
                    backClicked.onEvent(BackTransitionViewController.this, event);
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

    @Override
    public void addContentsButton(UIBarButtonItem button) {
    }

    @Override
    public void removeContentsButton() {
    }

}
