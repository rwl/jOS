package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIInterfaceOrientation {
    @Bind("UIInterfaceOrientationLandscapeLeft") LANDSCAPE_LEFT,
    @Bind("UIInterfaceOrientationLandscapeRight") LANDSCAPE_RIGHT,
    @Bind("UIInterfaceOrientationPortrait") PORTRAIT,
    @Bind("UIInterfaceOrientationPortraitUpsideDown") PORTRAIT_UPSIDE_DOWN
}
