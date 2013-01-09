package jos.uikit;

import jos.api.Export;
import jos.api.Register;
import jos.graphicsimaging.CGRect;

@Register(isWrapper = true)
public class UIView extends UIResponder {

    @Export(selector = "initWithFrame:")
    public UIView(final CGRect frame) {
    }
}
