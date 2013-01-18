package jos.api.uikit;

import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIScreen {
    public static UIScreen mainScreen;
    public CGRect bounds;
    public CGRect applicationFrame;
}
