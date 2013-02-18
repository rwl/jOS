package jos.samples.animation.screens;

import com.google.j2objc.annotations.Outlet;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UISegmentedControl;
import jos.api.uikit.UIViewController;

public class TransitionViewController extends UIViewController {

    @Outlet
    UIButton btnTransition;

    @Outlet
    UISegmentedControl sgmntTransitionType;

    EventListener transitionClicked;

    public UIViewAnimationOptions getSelectedTransition() {
        switch(sgmntTransitionType.getSelectedSegment()) {
            case 0:
                return UIViewAnimationOptions.TransitionCurlDown;
                break;
            case 1:
                return UIViewAnimationOptions.TransitionCurlUp;
                break;
            case 2:
                return UIViewAnimationOptions.TransitionFlipFromLeft;
                break;
            case 3:
                return UIViewAnimationOptions.TransitionFlipFromRight;
                break;
            default:
                return UIViewAnimationOptions.TransitionCurlDown;
                break;
        }
    }

    public TransitionViewController() {
        super("TransitionViewController", null);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        btnTransition.addTarget(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                if (transitionClicked != null) {
                    transitionClicked.onEvent(TransitionViewController.this, event);
                }
            }
        }, UIControlEvent.TOUCH_UP_INSIDE);
    }

}
