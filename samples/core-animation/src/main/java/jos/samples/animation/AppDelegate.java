package jos.samples.animation;

import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UIScreen;

public class AppDelegate extends UIApplicationDelegate {

    protected MainSplitView splitView;

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options)
    {
        // create our window
        window = new UIWindow (UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible ();

        // instantiate our main split view controller
        splitView = new MainSplitView ();

        window.setRootViewController(splitView);

        return true;
    }

}
