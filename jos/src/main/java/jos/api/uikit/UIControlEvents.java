package jos.api.uikit;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class UIControlEvents {
    public static int UIControlEventTouchDown           = 1 <<  0;
    public static int UIControlEventTouchDownRepeat     = 1 <<  1;
    public static int UIControlEventTouchDragInside     = 1 <<  2;
    public static int UIControlEventTouchDragOutside    = 1 <<  3;
    public static int UIControlEventTouchDragEnter      = 1 <<  4;
    public static int UIControlEventTouchDragExit       = 1 <<  5;
    public static int UIControlEventTouchUpInside       = 1 <<  6;
    public static int UIControlEventTouchUpOutside      = 1 <<  7;
    public static int UIControlEventTouchCancel         = 1 <<  8;

    public static int UIControlEventValueChanged        = 1 << 12;

    public static int UIControlEventEditingDidBegin     = 1 << 16;
    public static int UIControlEventEditingChanged      = 1 << 17;
    public static int UIControlEventEditingDidEnd       = 1 << 18;
    public static int UIControlEventEditingDidEndOnExit = 1 << 19;

    public static int UIControlEventAllTouchEvents      = 0x00000FFF;
    public static int UIControlEventAllEditingEvents    = 0x000F0000;
    public static int UIControlEventApplicationReserved = 0x0F000000;
    public static int UIControlEventSystemReserved      = 0xF0000000;
    public static int UIControlEventAllEvents           = 0xFFFFFFFF;
}
