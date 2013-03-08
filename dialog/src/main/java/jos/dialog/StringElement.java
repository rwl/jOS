package jos.dialog;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITextAlignment;

/**
 * The string element can be used to render some text in a cell that can
 * optionally respond to tap events.
 */
public class StringElement extends Element {

    static NSString skey = new NSString("StringElement");
    static NSString skeyvalue = new NSString("StringElementValue");
    public UITextAlignment Alignment = UITextAlignment.LEFT;
    public String Value;

    public StringElement(String caption) {
        super(caption);
    }

    public StringElement(String caption, String value) {
        super(caption);
        this.Value = value;
    }

    public StringElement (String caption, NSAction tapped) {
        super(caption);
        Tapped = tapped;
    }

    public NSAction Tapped;

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.DequeueReusableCell(Value == null ? skey
                : skeyvalue);
        if (cell == null) {
            cell = new UITableViewCell(
                    Value == null ? UITableViewCellStyle.DEFAULT
                            : UITableViewCellStyle.VALUE1, skey);
            cell.setSelectionStyle((Tapped != null) ? UITableViewCellSelectionStyle.BLUE
                    : UITableViewCellSelectionStyle.NONE);
        }
        cell.setAccessory(UITableViewCellAccessoryType.NONE);
        cell.getTextLabel().setText(Caption);
        cell.getTextLabel().setTextAlignment(Alignment);

        // The check is needed because the cell might have been recycled.
        if (cell.getDetailTextLabel() != null)
            cell.getDetailTextLabel().setText(Value == null ? "" : Value);

        return cell;
    }

    @Override
    public String Summary() {
        return Caption;
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath indexPath) {
        if (Tapped != null)
            Tapped.action();
        tableView.deselectRow(indexPath, true);
    }

    @Override
    public boolean Matches(String text) {
        return (Value != null ? Value.equalsIgnoreCase(text) : false)
                || super.Matches(text);
    }
}