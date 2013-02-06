package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public enum UIControlEvent {
    @Bind("UIControlEventTouchDown") TouchDown,
    @Bind("UIControlEventTouchDownRepeat") TouchDownRepeat,
    @Bind("UIControlEventTouchDragInside") TouchDragInside,
    @Bind("UIControlEventTouchDragOutside") TouchDragOutside,
    @Bind("UIControlEventTouchDragEnter") TouchDragEnter,
    @Bind("UIControlEventTouchDragExit") TouchDragExit,
    @Bind("UIControlEventTouchUpInside") TouchUpInside,
    @Bind("UIControlEventTouchUpOutside") TouchUpOutside,
    @Bind("UIControlEventTouchCancel") TouchCancel,
    @Bind("UIControlEventValueChanged") ValueChanged,
    @Bind("UIControlEventEditingDidBegin") EditingDidBegin,
    @Bind("UIControlEventEditingChanged") EditingChanged,
    @Bind("UIControlEventEditingDidEnd") EditingDidEnd,
    @Bind("UIControlEventEditingDidEndOnExit") EditingDidEndOnExit,
    @Bind("UIControlEventAllTouchEvents") AllTouchEvents,
    @Bind("UIControlEventAllEditingEvents") AllEditingEvents,
    @Bind("UIControlEventApplicationReserved") ApplicationReserved,
    @Bind("UIControlEventSystemReserved") SystemReserved,
    @Bind("UIControlEventAllEvents") AllEvents
}
