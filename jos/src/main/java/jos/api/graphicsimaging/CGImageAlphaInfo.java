package jos.api.graphicsimaging;

import com.google.j2objc.annotations.Bind;

public enum CGImageAlphaInfo {
    @Bind("kCGImageAlphaNone") NONE,
    @Bind("kCGImageAlphaPremultipliedLast") PREMULTIPLIED_LAST,
    @Bind("kCGImageAlphaPremultipliedFirst") PREMULTIPLIED_FIRST,
    @Bind("kCGImageAlphaLast") LAST,
    @Bind("kCGImageAlphaFirst") FIRST,
    @Bind("kCGImageAlphaNoneSkipLast") NONE_SKIP_LAST,
    @Bind("kCGImageAlphaNoneSkipFirst") NONE_SKIP_FIRST,
    @Bind("kCGImageAlphaOnly") ALPHA_ONLY;
}
