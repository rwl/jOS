package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class UIDataDetectorTypes {

    @Bind("UIDataDetectorTypePhoneNumber")
    public static final int PHONE_NUMBER = 1 << 0;

    @Bind("UIDataDetectorTypeLink")
    public static final int LINK = 1 << 1;

    @Bind("UIDataDetectorTypeAddress")
    public static final int ADDRESS = 1 << 2;

    @Bind("UIDataDetectorTypeCalendarEvent")
    public static final int CALENDAR_EVENT = 1 << 3;

    @Bind("UIDataDetectorTypeNone")
    public static final int NONE = 0;

    @Bind("UIDataDetectorTypeAll")
    public static final int ALL = Integer.MAX_VALUE;

}
