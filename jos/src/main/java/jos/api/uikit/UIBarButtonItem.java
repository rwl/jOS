package jos.api.uikit;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSSet;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;
import com.google.j2objc.annotations.Selector;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class UIBarButtonItem extends UIBarItem {

    @Export("style")
    public UIBarButtonItemStyle getStyle() {
        throw new RuntimeException();
    }

    @Export("setStyle:")
    public void setStyle(UIBarButtonItemStyle value) {
        throw new RuntimeException();
    }

    @Export("width")
    public float getWidth() {
        throw new RuntimeException();
    }

    @Export("setWidth:")
    public void setWidth(float value) {
        throw new RuntimeException();
    }

    @Export("possibleTitles")
    public NSSet getPossibleTitles() {
        throw new RuntimeException();
    }

    @Export("setPossibleTitles:")
    public void setPossibleTitles(NSSet value) {
        throw new RuntimeException();
    }

    @Export("customView")
    public UIView getCustomView() {
        throw new RuntimeException();
    }

    @Export("setCustomView:")
    public void setCustomView(UIView value) {
        throw new RuntimeException();
    }

    @Export("action")
    public Selector getAction() {
        throw new RuntimeException();
    }

    @Export("setAction:")
    public void setAction(Selector value) {
        throw new RuntimeException();
    }

    @Export("target")
    public NSObject getTarget() {
        throw new RuntimeException();
    }

    @Export("setTarget:")
    public void setTarget(NSObject value) {
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

    @Export("initWithImage:style:target:action:")
    public UIBarButtonItem(UIImage image, UIBarButtonItemStyle style, NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("initWithImage:landscapeImagePhone:style:target:action:")
    public UIBarButtonItem(UIImage image, UIImage landscapeImagePhone, UIBarButtonItemStyle style, NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("initWithTitle:style:target:action:")
    public UIBarButtonItem(String title, UIBarButtonItemStyle style, NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("initWithBarButtonSystemItem:target:action:")
    public UIBarButtonItem(UIBarButtonSystemItem systemItem, NSObject target, Selector action) {
        throw new RuntimeException();
    }

    @Export("initWithCustomView:")
    public UIBarButtonItem(UIView customView) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackgroundImage:forState:barMetrics:")
    public void setBackgroundImage(UIImage image, UIControlState state, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backgroundImageForState:barMetrics:")
    public UIImage backgroundImageForStatebarMetrics(UIControlState state, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackgroundImage:forState:style:barMetrics:")
    public void setBackgroundImageforStatestylebarMetrics(UIImage backgroundImage, UIControlState state, UIBarButtonItemStyle style, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backgroundImageForState:style:barMetrics:")
    public UIImage backgroundImageForStatestylebarMetrics(UIControlState state, UIBarButtonItemStyle style, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackgroundVerticalPositionAdjustment:forBarMetrics:")
    public void setBackgroundVerticalPositionAdjustmentforBarMetrics(float adjustment, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backgroundVerticalPositionAdjustmentForBarMetrics:")
    public float backgroundVerticalPositionAdjustmentForBarMetrics(UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setTitlePositionAdjustment:forBarMetrics:")
    public void setTitlePositionAdjustment(UIOffset adjustment, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("titlePositionAdjustmentForBarMetrics:")
    public UIOffset titlePositionAdjustmentForBarMetrics(UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackButtonBackgroundImage:forState:barMetrics:")
    public void setBackButtonBackgroundImageforStatebarMetrics(UIImage backgroundImage, UIControlState state, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backButtonBackgroundImageForState:barMetrics:")
    public UIImage backButtonBackgroundImageForStatebarMetrics(UIControlState state, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackButtonTitlePositionAdjustment:forBarMetrics:")
    public void setBackButtonTitlePositionAdjustmentforBarMetrics(UIOffset adjustment, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backButtonTitlePositionAdjustmentForBarMetrics:")
    public UIOffset backButtonTitlePositionAdjustmentForBarMetrics(UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setBackButtonBackgroundVerticalPositionAdjustment:forBarMetrics:")
    public void setBackButtonBackgroundVerticalPositionAdjustmentforBarMetrics(float adjustment, UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("backButtonBackgroundVerticalPositionAdjustmentForBarMetrics:")
    public float backButtonBackgroundVerticalPositionAdjustmentForBarMetrics(UIBarMetrics barMetrics) {
        throw new RuntimeException();
    }


}
