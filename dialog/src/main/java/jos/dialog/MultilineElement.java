package jos.dialog;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UIFont;
import jos.api.uikit.UILabel;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UIUserInterfaceIdiom;

public class MultilineElement extends StringElement implements IElementSizing {

    public MultilineElement(String caption) {
        super(caption);
    }

    public MultilineElement(String caption, String value) {
        super(caption, value);
    }

    public MultilineElement(String caption, NSAction tapped) {
        super(caption, tapped);
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = super.GetCell(tv);
        UILabel tl = cell.getTextLabel();
        tl.setLineBreakMode(UILineBreakMode.WORD_WRAP);
        tl.setLines(0);

        return cell;
    }

    public float GetHeight(UITableView tableView, NSIndexPath indexPath) {
        float margin = UIDevice.getCurrentDevice().getUserInterfaceIdiom() == UIUserInterfaceIdiom.PHONE ? 40f
                : 110f;
        CGSize size = makeSize(tableView.Bounds.Width - margin, Float.MAX_VALUE);
        UIFont font = UIFont.boldSystemFontOfSize(17);
        String c = Caption;
        // ensure the (single-line) Value will be rendered inside the cell
        if ((c == null || c.isEmpty()) && (Value != null || !Value.isEmpty()))
            c = " ";
        return tableView.stringSize(c, font, size, UILineBreakMode.WORD_WRAP).height + 10;
    }
}