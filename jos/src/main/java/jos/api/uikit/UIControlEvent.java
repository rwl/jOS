package jos.api.uikit;

import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public enum UIControlEvent {
    @Bind("UIControlEventTouchDown") TOUCH_DOWN,
    @Bind("UIControlEventTouchDownRepeat") TOUCH_DOWN_REPEAT,
    @Bind("UIControlEventTouchDragInside") TOUCH_DRAG_INSIDE,
    @Bind("UIControlEventTouchDragOutside") TOUCH_DRAG_OUTSIDE,
    @Bind("UIControlEventTouchDragEnter") TOUCH_DRAG_ENTER,
    @Bind("UIControlEventTouchDragExit") TOUCH_DRAG_EXIT,
    @Bind("UIControlEventTouchUpInside") TOUCH_UP_INSIDE,
    @Bind("UIControlEventTouchUpOutside") TOUCH_UP_OUTSIDE,
    @Bind("UIControlEventTouchCancel") TOUCH_CANCEL,
    @Bind("UIControlEventValueChanged") VALUE_CHANGED,
    @Bind("UIControlEventEditingDidBegin") EDITING_DID_BEGIN,
    @Bind("UIControlEventEditingChanged") EDITING_CHANGED,
    @Bind("UIControlEventEditingDidEnd") EDITING_DID_END,
    @Bind("UIControlEventEditingDidEndOnExit") EDITING_DID_END_ON_EXIT,
    @Bind("UIControlEventAllTouchEvents") ALL_TOUCH_EVENTS,
    @Bind("UIControlEventAllEditingEvents") ALL_EDITING_EVENTS,
    @Bind("UIControlEventApplicationReserved") APPLICATION_RESERVED,
    @Bind("UIControlEventSystemReserved") SYSTEM_RESERVED,
    @Bind("UIControlEventAllEvents") ALL_EVENTS
}
