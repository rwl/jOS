package jos.api.uikit;

import jos.api.foundation.NSCoding;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Appearance;
import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({NSCoding.class})
@Register(isWrapper = true)
public class UIActivityIndicatorView extends UIView {

    @Export("initWithActivityIndicatorStyle:")
    public UIActivityIndicatorView(UIActivityIndicatorViewStyle style) {
    }


    @Export("activityIndicatorViewStyle")
    public UIActivityIndicatorViewStyle getActivityIndicatorViewStyle() {
        throw new RuntimeException();
    }

    @Export("setActivityIndicatorViewStyle:")
    public void setActivityIndicatorViewStyle(UIActivityIndicatorViewStyle value) {
        throw new RuntimeException();
    }

    @Export("hidesWhenStopped")
    public boolean getHidesWhenStopped() {
        throw new RuntimeException();
    }

    @Export("setHidesWhenStopped:")
    public void setHidesWhenStopped(boolean value) {
        throw new RuntimeException();
    }

    @Appearance
    @Export("color")
    public UIColor getColor() {
        throw new RuntimeException();
    }

    @Export("setColor:")
    public void setColor(UIColor value) {
        throw new RuntimeException();
    }

    @Export("initWithActivityIndicatorStyle:")
    public NSObject initWithActivityIndicatorStyle(UIActivityIndicatorViewStyle style) {
        throw new RuntimeException();
    }

    @Export("startAnimating")
    public void startAnimating() {
        throw new RuntimeException();
    }

    @Export("stopAnimating")
    public void stopAnimating() {
        throw new RuntimeException();
    }

    @Export("isAnimating")
    public boolean isAnimating() {
        throw new RuntimeException();
    }

}
