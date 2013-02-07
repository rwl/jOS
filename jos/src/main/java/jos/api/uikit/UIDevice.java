package jos.api.uikit;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSObject;

public class UIDevice extends NSObject {

    public static UIDevice currentDevice;

    @Export("currentDevice")
    public static UIDevice getCurrentDevice() {
        return currentDevice;
    }

    public UIUserInterfaceIdiom userInterfaceIdiom;

    @Export("userInterfaceIdiom")
    public UIUserInterfaceIdiom getUserInterfaceIdiom() {
        return userInterfaceIdiom;
    }

    @Export("setUserInterfaceIdiom:")
    public void setUserInterfaceIdiom(UIUserInterfaceIdiom userInterfaceIdiom) {
        this.userInterfaceIdiom = userInterfaceIdiom;
    }

}
