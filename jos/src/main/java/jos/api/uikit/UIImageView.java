package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UIImageView extends UIView {

    public UIImage[] animationImages;
    public int animationRepeatCount;
    public double animationDuration;
    public UIImage image;

    @Export("initWithImage:")
    public UIImageView(UIImage image) {
        super();
    }

    @Export("init")
    public UIImageView() {
        super();
    }

    @Export("startAnimating")
    public void startAnimating() {
    }

    @Export("animationImages")
    public UIImage[] getAnimationImages() {
        return animationImages;
    }

    @Export("setAnimationImages:")
    public void setAnimationImages(UIImage[] animationImages) {
        this.animationImages = animationImages;
    }

    @Export("animationRepeatCount")
    public int getAnimationRepeatCount() {
        return animationRepeatCount;
    }

    @Export("setAnimationRepeatCount:")
    public void setAnimationRepeatCount(int animationRepeatCount) {
        this.animationRepeatCount = animationRepeatCount;
    }

    @Export("animationDuration")
    public double getAnimationDuration() {
        return animationDuration;
    }

    @Export("setAnimationDuration:")
    public void setAnimationDuration(double animationDuration) {
        this.animationDuration = animationDuration;
    }

    @Export("image")
    public UIImage getImage() {
        return image;
    }

    @Export("setImage:")
    public void setImage(UIImage image) {
        this.image = image;
    }

}
