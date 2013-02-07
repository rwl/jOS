package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGPoint;
import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIView extends UIResponder {

    public CGPoint center;
    public UIColor backgroundColor;
    public CGRect frame;
    public int tag;
    public int autoresizingMask;

    @Export("init")
    public UIView() {
    }

    @Export("initWithFrame:")
    public UIView(final CGRect frame) {
    }

    /**
     * Only override drawRect if you perform custom drawing.
     * An empty implementation adversely affects performance during animation.
     */
    @Export("drawRect:forViewPrintFormatter:")
    public void drawRect(CGRect rect) {
    }

    @Export("addSubview:")
    public void addSubview(UIView view) {
    }

    @Export("layoutSubviews")
    public void layoutSubviews() {
    }

    @Export("drawRect:")
    public void draw(CGRect rect) {
    }

    @Export("center")
    public CGPoint getCenter() {
        return center;
    }

    @Export("setCenter:")
    public void setCenter(CGPoint center) {
        this.center = center;
    }

    @Export("backgroundColor")
    public UIColor getBackgroundColor() {
        return backgroundColor;
    }

    @Export("setBackgroundColor:")
    public void setBackgroundColor(UIColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Export("frame")
    public CGRect getFrame() {
        return frame;
    }

    @Export("setFrame:")
    public void setFrame(CGRect frame) {
        this.frame = frame;
    }

    @Export("tag")
    public int getTag() {
        return tag;
    }

    @Export("setTag:")
    public void setTag(int tag) {
        this.tag = tag;
    }

    @Export("autoresizingMask")
    public int getAutoresizingMask() {
        return autoresizingMask;
    }

    @Export("setAutoresizingMask:")
    public void setAutoresizingMask(int autoresizingMask) {
        this.autoresizingMask = autoresizingMask;
    }

}
