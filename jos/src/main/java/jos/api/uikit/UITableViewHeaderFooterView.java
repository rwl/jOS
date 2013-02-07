package jos.api.uikit;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

import jos.api.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UITableViewHeaderFooterView extends UIView {

    @Export("initWithFrame:")
    public UITableViewHeaderFooterView(CGRect frame) {
        super(frame);
    }

}
