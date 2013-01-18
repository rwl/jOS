package jos.api.uikit;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true, header = "UIKit/UIKit.h")
public enum NSTextAlignment {
    NSTextAlignmentLeft,
    NSTextAlignmentCenter,
    NSTextAlignmentRight,
    NSTextAlignmentJustified,
    NSTextAlignmentNatural
}