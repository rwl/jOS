package jos.samples.image;

import com.google.j2objc.annotations.Action;

import jos.api.uikit.UIBarButtonItem;
import jos.api.uikit.UIInterfaceOrientation;
import jos.api.uikit.UIViewController;

public class FlipsideViewController extends UIViewController {

    private EventListener done;

    @Action("done:")
    public void done(UIBarButtonItem sender) {
        if (done != null) {
            done.onEvent(this, null);
        }
    }

    public FlipsideViewController() {
        super("FlipsideViewController", null);
    }

    @Override
    public boolean shouldAutorotateToInterfaceOrientation(
            UIInterfaceOrientation orientation) {
        // Return true for supported orientations
        return (orientation != UIInterfaceOrientation.PORTRAIT_UPSIDE_DOWN);
    }

    public void setDone(EventListener done) {
        this.done = done;
    }

}
