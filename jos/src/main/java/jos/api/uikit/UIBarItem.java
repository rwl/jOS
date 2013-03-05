package jos.api.uikit;

import jos.api.foundation.NSDictionary;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.Bind;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIBarItem extends UIAppearance {
    @Bind("isEnabled")
    @Export("enabled")
    public boolean getEnabled() {
        throw new RuntimeException();
    }

    @Export("setEnabled:")
    public void setEnabled(boolean value) {
        throw new RuntimeException();
    }

    @Export("title")
    public String getTitle() {
        throw new RuntimeException();
    }

    @Export("setTitle:")
    public void setTitle(String value) {
        throw new RuntimeException();
    }

    @Export("image")
    public UIImage getImage() {
        throw new RuntimeException();
    }

    @Export("setImage:")
    public void setImage(UIImage value) {
        throw new RuntimeException();
    }

    @Export("landscapeImagePhone")
    public UIImage getLandscapeImagePhone() {
        throw new RuntimeException();
    }

    @Export("setLandscapeImagePhone:")
    public void setLandscapeImagePhone(UIImage value) {
        throw new RuntimeException();
    }

    @Export("imageInsets")
    public UIEdgeInsets getImageInsets() {
        throw new RuntimeException();
    }

    @Export("setImageInsets:")
    public void setImageInsets(UIEdgeInsets value) {
        throw new RuntimeException();
    }

    @Export("landscapeImagePhoneInsets")
    public UIEdgeInsets getLandscapeImagePhoneInsets() {
        throw new RuntimeException();
    }

    @Export("setLandscapeImagePhoneInsets:")
    public void setLandscapeImagePhoneInsets(UIEdgeInsets value) {
        throw new RuntimeException();
    }

    @Export("tag")
    public int getTag() {
        throw new RuntimeException();
    }

    @Export("setTag:")
    public void setTag(int value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("setTitleTextAttributes:forState:")
    public void setTitleTextAttributesforState(NSDictionary attributes, UIControlState state) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("titleTextAttributesForState:")
    public NSDictionary titleTextAttributesForState(UIControlState state) {
        throw new RuntimeException();
    }

}