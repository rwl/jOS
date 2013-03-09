package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum UIReturnKeyType {
    @Bind("UIReturnKeyDefault") DEFAULT,
    @Bind("UIReturnKeyGo") GO,
    @Bind("UIReturnKeyGoogle") GOOGLE,
    @Bind("UIReturnKeyJoin") JOIN,
    @Bind("UIReturnKeyNext") NEXT,
    @Bind("UIReturnKeyRoute") ROUTE,
    @Bind("UIReturnKeySearch") SEARCH,
    @Bind("UIReturnKeySend") SEND,
    @Bind("UIReturnKeyYahoo") YAHOO,
    @Bind("UIReturnKeyDone") DONE,
    @Bind("UIReturnKeyEmergencyCall") EMERGENCY_CALL;
}
