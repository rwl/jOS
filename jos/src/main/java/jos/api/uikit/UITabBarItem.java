package jos.api.uikit;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITabBarItem extends UIBarItem {
    @Export("badgeValue")
    public String getBadgeValue() {
        throw new RuntimeException();
    }

    @Export("setBadgeValue:")
    public void setBadgeValue(String value) {
        throw new RuntimeException();
    }

    @Export("initWithTitle:image:tag:")
    public UITabBarItem(String title, UIImage image, int tag) {
        throw new RuntimeException();
    }

    @Export("initWithTabBarSystemItem:tag:")
    public UITabBarItem(UITabBarSystemItem systemItem, int tag) {
        throw new RuntimeException();
    }

    @Export("init")
    public UITabBarItem() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setFinishedSelectedImage:withFinishedUnselectedImage:")
    public void setFinishedSelectedImagewithFinishedUnselectedImage(UIImage selectedImage, UIImage unselectedImage) {
    }

    @Export("finishedSelectedImage")
    public UIImage finishedSelectedImage() {
        throw new RuntimeException();
    }

    @Export("finishedUnselectedImage")
    public UIImage finishedUnselectedImage() {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setTitlePositionAdjustment:")
    public void setTitlePositionAdjustment(UIOffset adjustment) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("titlePositionAdjustment")
    public UIOffset titlePositionAdjustment() {
        throw new RuntimeException();
    }

}

