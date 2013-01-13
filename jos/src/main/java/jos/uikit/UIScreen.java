package jos.uikit;

import jos.api.Register;
import jos.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIScreen {
    public static UIScreen mainScreen;
    public CGRect bounds;
    public CGRect applicationFrame;
}
