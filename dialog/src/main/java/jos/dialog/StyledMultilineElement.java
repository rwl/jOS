package jos.dialog;

import static jos.api.graphicsimaging.CGGeometry.makeSize;

import jos.api.foundation.NSAction;
import jos.api.foundation.NSIndexPath;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UIFont;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIUserInterfaceIdiom;

public class StyledMultilineElement extends StyledStringElement implements
        IElementSizing {

    public StyledMultilineElement(String caption) {
        super(caption);
    }

    public StyledMultilineElement(String caption, String value) {
        super(caption, value);
    }

    public StyledMultilineElement(String caption, NSAction tapped) {
        super(caption, tapped);
    }

    public StyledMultilineElement(String caption, String value,
            UITableViewCellStyle style) {
        super(caption, value);
        this.style = style;
    }

    public float GetHeight(UITableView tableView, NSIndexPath indexPath) {
        float margin = UIDevice.getCurrentDevice().getUserInterfaceIdiom() == UIUserInterfaceIdiom.PHONE ? 40f
                : 110f;
        CGSize maxSize = makeSize(tableView.getBounds().size.width - margin,
                Float.MAX_VALUE);

        if (this.Accessory != UITableViewCellAccessoryType.NONE)
            maxSize.width = maxSize.width - 20;

        String c = Caption;
        String v = Value;
        // ensure the (multi-line) Value will be rendered inside the cell when no Caption is present
        if (c == null || c.isEmpty())
            c = " ";

        UIFont captionFont = Font == null ? UIFont.boldSystemFontOfSize(17)
                : Font;
        float height = tableView.StringSize(c, captionFont, maxSize,
                LineBreakMode).Height;

        if (v != null || !v.isEmpty()) {
            UIFont subtitleFont = SubtitleFont == null ? UIFont
                    .systemFontOfSize(14) : SubtitleFont;
            if (this.style == UITableViewCellStyle.SUBTITLE) {
                height += tableView.StringSize(v, subtitleFont, maxSize,
                        LineBreakMode).Height;
            } else {
                float vheight = tableView.StringSize(v, subtitleFont, maxSize,
                        LineBreakMode).Height;
                if (vheight > height)
                    height = vheight;
            }
        }

        return height + 10;
    }
}