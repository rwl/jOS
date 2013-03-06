package jos.api.uikit;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class UIEventSubtype {
    public static final int UIEventSubtypeNone                              = 0;
    public static final int UIEventSubtypeMotionShake                       = 1;
    public static final int UIEventSubtypeRemoteControlPlay                 = 100;
    public static final int UIEventSubtypeRemoteControlPause                = 101;
    public static final int UIEventSubtypeRemoteControlStop                 = 102;
    public static final int UIEventSubtypeRemoteControlTogglePlayPause      = 103;
    public static final int UIEventSubtypeRemoteControlNextTrack            = 104;
    public static final int UIEventSubtypeRemoteControlPreviousTrack        = 105;
    public static final int UIEventSubtypeRemoteControlBeginSeekingBackward = 106;
    public static final int UIEventSubtypeRemoteControlEndSeekingBackward   = 107;
    public static final int UIEventSubtypeRemoteControlBeginSeekingForward  = 108;
    public static final int UIEventSubtypeRemoteControlEndSeekingForward    = 109;
}
