package jos.api.uikit;

import jos.api.foundation.NSCoding;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class UISlider extends UIControl {

    @Export("value")
    public float getValue() {
        throw new RuntimeException();
    }

    @Export("setValue:")
    public void setValue(float value) {
        throw new RuntimeException();
    }

    @Export("minimumValue")
    public float getMinimumValue() {
        throw new RuntimeException();
    }

    @Export("setMinimumValue:")
    public void setMinimumValue(float value) {
        throw new RuntimeException();
    }

    @Export("maximumValue")
    public float getMaximumValue() {
        throw new RuntimeException();
    }

    @Export("setMaximumValue:")
    public void setMaximumValue(float value) {
        throw new RuntimeException();
    }

    @Export("minimumValueImage")
    public UIImage getMinimumValueImage() {
        throw new RuntimeException();
    }

    @Export("setMinimumValueImage:")
    public void setMinimumValueImage(UIImage value) {
        throw new RuntimeException();
    }

    @Export("maximumValueImage")
    public UIImage getMaximumValueImage() {
        throw new RuntimeException();
    }

    @Export("setMaximumValueImage:")
    public void setMaximumValueImage(UIImage value) {
        throw new RuntimeException();
    }

    @Bind("isContinuous")
    @Export("continuous")
    public boolean getContinuous() {
        throw new RuntimeException();
    }

    @Export("setContinuous:")
    public void setContinuous(boolean value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("minimumTrackTintColor")
    public UIColor getMinimumTrackTintColor() {
        throw new RuntimeException();
    }

    @Export("setMinimumTrackTintColor:")
    public void setMinimumTrackTintColor(UIColor value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("maximumTrackTintColor")
    public UIColor getMaximumTrackTintColor() {
        throw new RuntimeException();
    }

    @Export("setMaximumTrackTintColor:")
    public void setMaximumTrackTintColor(UIColor value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("thumbTintColor")
    public UIColor getThumbTintColor() {
        throw new RuntimeException();
    }

    @Export("setThumbTintColor:")
    public void setThumbTintColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("currentThumbImage")
    public UIImage getCurrentThumbImage() {
        throw new RuntimeException();
    }

    @Export("currentMinimumTrackImage")
    public UIImage getCurrentMinimumTrackImage() {
        throw new RuntimeException();
    }

    @Export("currentMaximumTrackImage")
    public UIImage getCurrentMaximumTrackImage() {
        throw new RuntimeException();
    }

    @Export("setValue:animated:")
    public void setValueanimated(float value, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setThumbImage:forState:")
    public void setThumbImage(UIImage image, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setMinimumTrackImage:forState:")
    public void setMinimumTrackImageforState(UIImage image, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setMaximumTrackImage:forState:")
    public void setMaximumTrackImageforState(UIImage image, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("thumbImageForState:")
    public UIImage thumbImageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("minimumTrackImageForState:")
    public UIImage minimumTrackImageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("maximumTrackImageForState:")
    public UIImage maximumTrackImageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("minimumValueImageRectForBounds:")
    public CGRect minimumValueImageRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("maximumValueImageRectForBounds:")
    public CGRect maximumValueImageRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("trackRectForBounds:")
    public CGRect trackRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("thumbRectForBounds:trackRect:value:")
    public CGRect thumbRectForBoundstrackRectvalue(CGRect bounds, CGRect rect, float value) {
        throw new RuntimeException();
    }

}
