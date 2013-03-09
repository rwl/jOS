package jos.dialog;

import static jos.api.graphicsimaging.CGGeometry.makeRect;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSObject;
import jos.api.foundation.NSString;
import jos.api.graphicsimaging.CGRect;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIButtonType;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIEvent;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIImage;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITextAlignment;

/**
 * This class is used to render a string + a state in the form of an image.
 *
 * It is abstract to avoid making this element keep two pointers for the state
 * images, saving 8 bytes per slot. The more derived class "BooleanImageElement"
 * shows one way to implement this by keeping two pointers, a better
 * implementation would return pointers to images that were preloaded and are
 * static.
 *
 * A subclass only needs to implement the GetImage method.
 */
public abstract class BaseBooleanImageElement extends BoolElement {

    private static final NSString key = new NSString("BooleanImageElement");

    public class TextWithImageCellView extends UITableViewCell {

        private static final int fontSize = 17;
        private final UIFont font = UIFont.boldSystemFontOfSize(fontSize);
        private BaseBooleanImageElement parent;
        private UILabel label;
        private UIButton button;
        private final int ImageSpace = 32;
        private final int Padding = 8;

        public TextWithImageCellView(BaseBooleanImageElement parent_) {
            super(UITableViewCellStyle.VALUE1, parent_.getCellKey());
            parent = parent_;
            label = new UILabel();
            label.setTextAlignment(UITextAlignment.LEFT);
            label.setText(parent.getCaption());
            label.setFont(font);
            label.setBackgroundColor(UIColor.CLEAR);
            button = UIButton.fromType(UIButtonType.CUSTOM);
            button.addTarget(new EventListener() {

                @Override
                public void onEvent(NSObject sender, UIEvent event) {
                    parent.setValue(!parent.getValue());
                    UpdateImage();
                    if (parent.getTapped() != null)
                        parent.getTapped().action();
                }
            }, UIControlEvent.TOUCH_DOWN);
            getContentView().addSubview(label);
            getContentView().addSubview(button);
            UpdateImage();
        }

        void UpdateImage() {
            button.setImage(parent.GetImage(), UIControlState.NORMAL);
        }

        @Override
        public void layoutSubviews() {
            super.layoutSubviews();
            CGRect full = getContentView().getBounds();
            CGRect frame = full;
            frame.size.height = 22;
            frame.origin.x = Padding;
            frame.origin.y = (full.size.height - frame.size.height) / 2;
            frame.size.width -= ImageSpace + Padding;
            label.setFrame(frame);

            button.setFrame(makeRect(full.size.width - ImageSpace, -3,
                    ImageSpace, 48));
        }

        public void UpdateFrom(BaseBooleanImageElement newParent) {
            parent = newParent;
            UpdateImage();
            label.setText(parent.Caption);
            setNeedsDisplay();
        }
    }

    public BaseBooleanImageElement(String caption, boolean value) {
        super(caption, value);
    }

    private NSAction Tapped;

    protected abstract UIImage GetImage();

    @Override
    protected NSString getCellKey() {
        return key;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        TextWithImageCellView cell = (TextWithImageCellView) tv
                .dequeueReusableCell(getCellKey());
        if (cell == null)
            cell = new TextWithImageCellView(this);
        else
            cell.UpdateFrom(this);
        return cell;
    }

    public NSAction getTapped() {
        return Tapped;
    }

    public void setTapped(NSAction tapped) {
        Tapped = tapped;
    }

}