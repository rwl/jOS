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

    public UIView() {
    }

    @Export(selector = "initWithFrame:")
    public UIView(final CGRect frame) {
    }

    /**
     * Only override drawRect if you perform custom drawing.
     * An empty implementation adversely affects performance during animation.
     */
    public void drawRect(CGRect rect) {
    }

    public void addSubview(UIView view) {
    }
}
