package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIScreen {

    public static UIScreen mainScreen;

    public CGRect bounds;
    public CGRect applicationFrame;

    @Export("bounds")
    public CGRect getBounds() {
        return bounds;
    }

    @Export("setBounds:")
    public void setBounds(CGRect bounds) {
        this.bounds = bounds;
    }

    @Export("applicationFrame")
    public CGRect getApplicationFrame() {
        return applicationFrame;
    }

    @Export("setApplicationFrame:")
    public void setApplicationFrame(CGRect applicationFrame) {
        this.applicationFrame = applicationFrame;
    }

    @Export("mainScreen")
    public static UIScreen getMainScreen() {
        return mainScreen;
    }

}
