package jos.api.foundation;

import com.google.j2objc.annotations.Bind;

public enum NSURLRequestNetworkServiceType {

    @Bind("NSURLNetworkServiceTypeDefault")
    DEFAULT,

    @Bind("NSURLNetworkServiceTypeVoIP")
    VOIP,

    @Bind("NSURLNetworkServiceTypeVideo")
    VIDEO,

    @Bind("NSURLNetworkServiceTypeBackground")
    BACKGROUND,

    @Bind("NSURLNetworkServiceTypeVoice")
    VOICE

}
