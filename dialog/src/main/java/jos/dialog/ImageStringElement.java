package jos.dialog;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSString;
import jos.api.uikit.UIImage;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellSelectionStyle;
import jos.api.uikit.UITableViewCellStyle;

public class ImageStringElement extends StringElement {

    private static NSString skey = new NSString("ImageStringElement");
    private UIImage image;
    private UITableViewCellAccessoryType Accessory;

    public ImageStringElement(String caption, UIImage image) {
        super(caption);
        this.image = image;
        this.Accessory = UITableViewCellAccessoryType.NONE;
    }

    public ImageStringElement(String caption, String value, UIImage image) {
        super(caption, value);
        this.image = image;
        this.Accessory = UITableViewCellAccessoryType.NONE;
    }

    public ImageStringElement(String caption, NSAction tapped, UIImage image) {
        super(caption, tapped);
        this.image = image;
        this.Accessory = UITableViewCellAccessoryType.NONE;
    }

    @Override
    protected NSString getCellKey() {
        return skey;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.dequeueReusableCell(getCellKey());
        if (cell == null) {
            cell = new UITableViewCell(
                    getValue() == null ? UITableViewCellStyle.DEFAULT
                            : UITableViewCellStyle.SUBTITLE, getCellKey());
            cell.setSelectionStyle(UITableViewCellSelectionStyle.BLUE);
        }

        cell.setAccessoryType(Accessory);
        cell.getTextLabel().setText(Caption);
        cell.getTextLabel().setTextAlignment(getAlignment());

        cell.getImageView().setImage(image);

        // The check is needed because the cell might have been recycled.
        if (cell.getDetailTextLabel() != null)
            cell.getDetailTextLabel().setText(
                    getValue() == null ? "" : getValue());

        return cell;
    }

}