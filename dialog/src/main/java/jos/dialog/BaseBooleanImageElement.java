package jos.dialog;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSString;
import jos.api.uikit.UIButton;
import jos.api.uikit.UIButtonType;
import jos.api.uikit.UIControlState;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIImage;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;

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

    static NSString key = new NSString("BooleanImageElement");

    public class TextWithImageCellView extends UITableViewCell {

        static final int fontSize = 17;
        static UIFont font = UIFont.boldSystemFontOfSize(fontSize);
        BaseBooleanImageElement parent;
        UILabel label;
        UIButton button;
        final int ImageSpace = 32;
        final int Padding = 8;

        public TextWithImageCellView(BaseBooleanImageElement parent_) {
            super(UITableViewCellStyle.Value1, parent_.CellKey);
            parent = parent_;
            label = new UILabel();
            label.setTextAlignment(UITextAlignment.Left);
            label.setText(parent.Caption);
            label.setFont(font);
            label.setBackgroundColor(UIColor.Clear);
            button = UIButton.fromType(UIButtonType.CUSTOM);
            //            button.TouchDown += delegate {
            //                parent.Value = !parent.Value;
            //                UpdateImage ();
            //                if (parent.Tapped != null)
            //                    parent.Tapped ();
            //            };
            getContentView().add(label);
            getContentView().add(button);
            UpdateImage();
        }

        void UpdateImage() {
            button.SetImage(parent.GetImage(), UIControlState.NORMAL);
        }

        @Override
        public void LayoutSubviews() {
            super.LayoutSubviews();
            CGRect full = ContentView.Bounds;
            CGRect frame = full;
            frame.height = 22;
            frame.x = Padding;
            frame.y = (full.height - frame.height) / 2;
            frame.width -= ImageSpace + Padding;
            label.setFrame(frame);

            button.setFrame(makeRect(full.Width - ImageSpace, -3, ImageSpace,
                    48));
        }

        public void UpdateFrom(BaseBooleanImageElement newParent) {
            parent = newParent;
            UpdateImage();
            label.setText(parent.Caption);
            SetNeedsDisplay();
        }
    }

    public BaseBooleanImageElement(String caption, boolean value) {
        super(caption, value);
    }

    public NSAction Tapped;

    protected abstract UIImage GetImage();

    @Override
    protected NSString getCellKey() {
        return key;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        TextWithImageCellView cell = (TextWithImageCellView) tv
                .DequeueReusableCell(getCellKey());
        if (cell == null)
            cell = new TextWithImageCellView(this);
        else
            cell.UpdateFrom(this);
        return cell;
    }

}