package jos.api.uikit;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, isPrimitive = true)
public class NSLayoutFormatOptions {
    public static int NSLayoutFormatAlignAllLeft = 1;
    public static int NSLayoutFormatAlignAllRight = 1;
    public static int NSLayoutFormatAlignAllTop = 1;
    public static int NSLayoutFormatAlignAllBottom = 1;
    public static int NSLayoutFormatAlignAllLeading = 1;
    public static int NSLayoutFormatAlignAllTrailing = 1;
    public static int NSLayoutFormatAlignAllCenterX = 1;
    public static int NSLayoutFormatAlignAllCenterY = 1;
    public static int NSLayoutFormatAlignAllBaseline = 1;

    public static int NSLayoutFormatAlignmentMask = 0xFFFF;

    public static int NSLayoutFormatDirectionLeadingToTrailing = 0 << 16;
    public static int NSLayoutFormatDirectionLeftToRight = 1 << 16;
    public static int NSLayoutFormatDirectionRightToLeft = 2 << 16;

    public static int NSLayoutFormatDirectionMask = 0x3 << 16;
}
