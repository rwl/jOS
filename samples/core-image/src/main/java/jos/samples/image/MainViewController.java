package jos.samples.image;

import com.google.j2objc.annotations.Action;

import jos.api.foundation.NSObject;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

public class MainViewController extends UIViewController {

    @Action("showInfo:")
    public void showInfo(NSObject sender) {
        FlipsideViewController controller = new FlipsideViewController();
        controller.setModalTransitionStyle(UIModalTransitionStyle.FLIP_HORIZONTAL);

        controller.setDone(new EventListener() {
            @Override
            public void onEvent(NSObject sender, UIEvent event) {
                dismissModalViewControllerAnimated(true);
            }
        });

        presentModalViewController(controller, true);
    }

    public MainViewController() {
        super("MainViewController", null);
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation orientation) {
        // Return true for supported orientations
        return (orientation != UIInterfaceOrientation.PORTRAIT_UPSIDE_DOWN);
    }

}
