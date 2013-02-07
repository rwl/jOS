package jos.samples.hello.tmp;

import static jos.api.graphicsimaging.CGGeometry.makeRect;
import jos.api.foundation.NSDictionary;
import jos.api.uikit.UIApplication;
import jos.api.uikit.UIApplicationDelegate;
import jos.api.uikit.UILabel;
import jos.api.uikit.UIScreen;
import jos.api.uikit.UITextAlignment;
import jos.api.uikit.UIWindow;

public class AppDelegate extends UIApplicationDelegate {

    @Override
    public boolean finishedLaunching(UIApplication app, NSDictionary options) {
        this.window = new UIWindow(UIScreen.mainScreen.bounds);

        UILabel label = new UILabel(makeRect(0.0f, 50.0f, 320.0f, 30.0f));
        label.text = "Hello World";
        label.textAlignment = UITextAlignment.CENTER;

        this.window.addSubview(label);
        this.window.makeKeyAndVisible();

        return true;
    }

}
