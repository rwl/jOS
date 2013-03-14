package jos.api.foundation;

import com.google.j2objc.annotations.Bind;

public enum NSURLRequestCachePolicy {

    @Bind("NSURLRequestUseProtocolCachePolicy")
    USE_PROTOCOL_CACHE_POLICY,


    @Bind("NSURLRequestReloadIgnoringLocalCacheData")
    RELOAD_IGNORING_LOCAL_CACHE_DATA,

    @Bind("NSURLRequestReloadIgnoringLocalAndRemoteCacheData")
    RELOAD_IGNORING_LOCAL_AND_REMOTE_CACHE_DATA,

    @Bind("NSURLRequestReloadIgnoringCacheData")
    RELOAD_IGNORING_CACHE_DATA,

    @Bind("NSURLRequestReturnCacheDataElseLoad")
    RETURN_CACHE_DATA_ELSE_LOAD,

    @Bind("NSURLRequestReturnCacheDataDontLoad")
    RETURN_CACHE_DATA_DONT_LOAD,

    @Bind("NSURLRequestReloadRevalidatingCacheData")
    RELOAD_REVALIDATING_CACHE_DATA;

}
