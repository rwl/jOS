package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public enum UIInterfaceOrientation {
    @Bind("UIInterfaceOrientationLandscapeLeft") LandscapeLeft,
    @Bind("UIInterfaceOrientationLandscapeRight") LandscapeRight,
    @Bind("UIInterfaceOrientationPortrait") Portrait,
    @Bind("UIInterfaceOrientationPortraitUpsideDown") PortraitUpsideDown
}
