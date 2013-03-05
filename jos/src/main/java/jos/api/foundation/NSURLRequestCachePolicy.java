package jos.api.foundation;

import com.google.j2objc.annotations.Bind;

public enum NSURLRequestCachePolicy {

    @Bind("NSURLRequestUseProtocolCachePolicy")
    UseProtocolCachePolicy,


    @Bind("NSURLRequestReloadIgnoringLocalCacheData")
    ReloadIgnoringLocalCacheData,

    @Bind("NSURLRequestReloadIgnoringLocalAndRemoteCacheData")
    ReloadIgnoringLocalAndRemoteCacheData,

    @Bind("NSURLRequestReloadIgnoringCacheData")
    ReloadIgnoringCacheData,

    @Bind("NSURLRequestReturnCacheDataElseLoad")
    ReturnCacheDataElseLoad,

    @Bind("NSURLRequestReturnCacheDataDontLoad")
    ReturnCacheDataDontLoad,

    @Bind("NSURLRequestReloadRevalidatingCacheData")
    ReloadRevalidatingCacheData

}
