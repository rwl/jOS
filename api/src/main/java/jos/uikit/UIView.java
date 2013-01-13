package jos.uikit;

import jos.api.Export;
import jos.api.Register;
import jos.graphicsimaging.CGPoint;
import jos.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIView extends UIResponder {

	public CGPoint center;
	public UIColor backgroundColor;

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
