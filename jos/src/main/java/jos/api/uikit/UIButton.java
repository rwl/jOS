package jos.api.uikit;

import jos.api.foundation.NSAttributedString;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGRect;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;


@BaseType({UIControl.class, NSCoding.class})
@Register(isWrapper = true)
public class UIButton extends UIControl {

    @Export("contentEdgeInsets")
    public UIEdgeInsets getContentEdgeInsets() {
        throw new RuntimeException();
    }

    @Export("setContentEdgeInsets:")
    public void setContentEdgeInsets(UIEdgeInsets value) {
        throw new RuntimeException();
    }

    @Export("titleEdgeInsets")
    public UIEdgeInsets getTitleEdgeInsets() {
        throw new RuntimeException();
    }

    @Export("setTitleEdgeInsets:")
    public void setTitleEdgeInsets(UIEdgeInsets value) {
        throw new RuntimeException();
    }

    @Export("reversesTitleShadowWhenHighlighted")
    public boolean getReversesTitleShadowWhenHighlighted() {
        throw new RuntimeException();
    }

    @Export("setReversesTitleShadowWhenHighlighted:")
    public void setReversesTitleShadowWhenHighlighted(boolean value) {
        throw new RuntimeException();
    }

    @Export("imageEdgeInsets")
    public UIEdgeInsets getImageEdgeInsets() {
        throw new RuntimeException();
    }

    @Export("setImageEdgeInsets:")
    public void setImageEdgeInsets(UIEdgeInsets value) {
        throw new RuntimeException();
    }

    @Export("adjustsImageWhenHighlighted")
    public boolean getAdjustsImageWhenHighlighted() {
        throw new RuntimeException();
    }

    @Export("setAdjustsImageWhenHighlighted:")
    public void setAdjustsImageWhenHighlighted(boolean value) {
        throw new RuntimeException();
    }

    @Export("adjustsImageWhenDisabled")
    public boolean getAdjustsImageWhenDisabled() {
        throw new RuntimeException();
    }

    @Export("setAdjustsImageWhenDisabled:")
    public void setAdjustsImageWhenDisabled(boolean value) {
        throw new RuntimeException();
    }

    @Export("showsTouchWhenHighlighted")
    public boolean getShowsTouchWhenHighlighted() {
        throw new RuntimeException();
    }

    @Export("setShowsTouchWhenHighlighted:")
    public void setShowsTouchWhenHighlighted(boolean value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("tintColor")
    public UIColor getTintColor() {
        throw new RuntimeException();
    }

    @Export("setTintColor:")
    public void setTintColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("buttonType")
    public UIButtonType getButtonType() {
        throw new RuntimeException();
    }

    @Export("currentTitleColor")
    public UIColor getCurrentTitleColor() {
        throw new RuntimeException();
    }

    @Export("currentTitleShadowColor")
    public UIColor getCurrentTitleShadowColor() {
        throw new RuntimeException();
    }

    @Export("currentImage")
    public UIImage getCurrentImage() {
        throw new RuntimeException();
    }

    @Export("currentBackgroundImage")
    public UIImage getCurrentBackgroundImage() {
        throw new RuntimeException();
    }

    @Export("currentAttributedTitle")
    public NSAttributedString getCurrentAttributedTitle() {
        throw new RuntimeException();
    }

    @Export("imageView")
    public UIImageView getImageView() {
        throw new RuntimeException();
    }

    @Export("buttonWithType:")
    public static UIButton fromType(UIButtonType buttonType) {
        throw new RuntimeException();
    }

    @Export("setTitle:forState:")
    public void setTitle(String title, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setTitleColor:forState:")
    public void setTitleColorforState(UIColor color, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setTitleShadowColor:forState:")
    public void setTitleShadowColorforState(UIColor color, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setImage:forState:")
    public void setImageforState(UIImage image, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setBackgroundImage:forState:")
    public void setBackgroundImageforState(UIImage image, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("setAttributedTitle:forState:")
    public void setAttributedTitleforState(NSAttributedString title, UIControlState state) {
        throw new RuntimeException();
    }

    @Export("titleForState:")
    public String titleForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("titleColorForState:")
    public UIColor titleColorForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("titleShadowColorForState:")
    public UIColor titleShadowColorForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("imageForState:")
    public UIImage imageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("backgroundImageForState:")
    public UIImage backgroundImageForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("attributedTitleForState:")
    public NSAttributedString attributedTitleForState(UIControlState state) {
        throw new RuntimeException();
    }

    @Export("currentTitle")
    public NSString getCurrentTitle() {
        throw new RuntimeException();
    }

    @Export("titleLabel")
    public UILabel getTitleLabel() {
        throw new RuntimeException();
    }

    @Export("backgroundRectForBounds:")
    public CGRect backgroundRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("contentRectForBounds:")
    public CGRect contentRectForBounds(CGRect bounds) {
        throw new RuntimeException();
    }

    @Export("titleRectForContentRect:")
    public CGRect titleRectForContentRect(CGRect contentRect) {
        throw new RuntimeException();
    }

    @Export("imageRectForContentRect:")
    public CGRect imageRectForContentRect(CGRect contentRect) {
        throw new RuntimeException();
    }

}