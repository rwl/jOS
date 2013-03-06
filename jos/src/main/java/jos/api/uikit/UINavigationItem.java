package jos.api.uikit;

import jos.api.foundation.NSArray;
import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.NativeArray;
import com.google.j2objc.annotations.Register;

@BaseType(NSCoding.class)
@Register(isWrapper = true)
public class UINavigationItem extends NSObject {

    @Export("title")
    public String getTitle() {
        throw new RuntimeException();
    }

    @Export("setTitle:")
    public void setTitle(String value) {
        throw new RuntimeException();
    }

    @Export("backBarButtonItem")
    public UIBarButtonItem getBackBarButtonItem() {
        throw new RuntimeException();
    }

    @Export("setBackBarButtonItem:")
    public void setBackBarButtonItem(UIBarButtonItem value) {
        throw new RuntimeException();
    }

    @Export("titleView")
    public UIView getTitleView() {
        throw new RuntimeException();
    }

    @Export("setTitleView:")
    public void setTitleView(UIView value) {
        throw new RuntimeException();
    }

    @Export("prompt")
    public String getPrompt() {
        throw new RuntimeException();
    }

    @Export("setPrompt:")
    public void setPrompt(String value) {
        throw new RuntimeException();
    }

    @Export("hidesBackButton")
    public boolean getHidesBackButton() {
        throw new RuntimeException();
    }

    @Export("setHidesBackButton:")
    public void setHidesBackButton(boolean value) {
        throw new RuntimeException();
    }

    @Export("rightBarButtonItems")
    public NSArray getRightBarButtonItems() {
        throw new RuntimeException();
    }

    @Export("setRightBarButtonItems:")
    public void setRightBarButtonItems(NSArray value) {
        throw new RuntimeException();
    }

    @Export("rightBarButtonItem")
    public UIBarButtonItem getRightBarButtonItem() {
        throw new RuntimeException();
    }

    @Export("setRightBarButtonItem:")
    public void setRightBarButtonItem(UIBarButtonItem value) {
        throw new RuntimeException();
    }

    @Export("initWithTitle:")
    public NSObject initWithTitle(String title) {
        throw new RuntimeException();
    }

    @Export("setHidesBackButton:animated:")
    public void setHidesBackButtonanimated(boolean hidesBackButton, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setLeftBarButtonItems:animated:")
    public void setLeftBarButtonItemsanimated(NSArray items, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setRightBarButtonItems:animated:")
    public void setRightBarButtonItems(@NativeArray UIBarButtonItem[] items, boolean animated) {
        throw new RuntimeException();
    }

    @Export("leftItemsSupplementBackButton")
    public boolean leftItemsSupplementBackButton() {
        throw new RuntimeException();
    }

    @Export("leftBarButtonItem")
    public UIBarButtonItem leftBarButtonItem() {
        throw new RuntimeException();
    }

    @Export("setLeftBarButtonItem:animated:")
    public void setLeftBarButtonItemanimated(UIBarButtonItem item, boolean animated) {
        throw new RuntimeException();
    }

    @Export("setRightBarButtonItem:animated:")
    public void setRightBarButtonItemanimated(UIBarButtonItem item, boolean animated) {
        throw new RuntimeException();
    }

}
