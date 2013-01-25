package jos.api.uikit;

import com.google.j2objc.annotations.Export;

import jos.api.foundation.NSObject;

public class UIDevice extends NSObject {

    public static UIDevice currentDevice;

    public UIUserInterfaceIdiom userInterfaceIdiom;

    @Export(selector = "userInterfaceIdiom")
    public UIUserInterfaceIdiom getUserInterfaceIdiom() {
        return userInterfaceIdiom;
    }

    @Export(selector = "setUserInterfaceIdiom:")
    public void setUserInterfaceIdiom(UIUserInterfaceIdiom userInterfaceIdiom) {
        this.userInterfaceIdiom = userInterfaceIdiom;
    }

}
