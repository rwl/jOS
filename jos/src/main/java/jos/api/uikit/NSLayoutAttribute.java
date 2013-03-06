package jos.api.uikit;

import com.google.j2objc.annotations.Bind;

public enum NSLayoutAttribute {
    @Bind("NSLayoutAttributeLeft") Left,
    @Bind("NSLayoutAttributeRight") Right,
    @Bind("NSLayoutAttributeTop") Top,
    @Bind("NSLayoutAttributeBottom") Bottom,
    @Bind("NSLayoutAttributeLeading") Leading,
    @Bind("NSLayoutAttributeTrailing") Trailing,
    @Bind("NSLayoutAttributeWidth") Width,
    @Bind("NSLayoutAttributeHeight") Height,
    @Bind("NSLayoutAttributeCenterX") CenterX,
    @Bind("NSLayoutAttributeCenterY") CenterY,
    @Bind("NSLayoutAttributeBaseline") Baseline,
    @Bind("NSLayoutAttributeNotAnAttribute") NotAnAttribute;
}
