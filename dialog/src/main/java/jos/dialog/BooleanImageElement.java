package jos.dialog;

import jos.api.uikit.UIImage;

public class BooleanImageElement extends BaseBooleanImageElement {

    UIImage onImage, offImage;

    public BooleanImageElement(String caption, boolean value, UIImage onImage,
            UIImage offImage) {
        super(caption, value);
        this.onImage = onImage;
        this.offImage = offImage;
    }

    @Override
    protected UIImage GetImage() {
        if (getValue())
            return onImage;
        else
            return offImage;
    }

    @Override
    protected void Dispose(boolean disposing) {
        super.Dispose(disposing);
        onImage = offImage = null;
    }

}