package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UIColor;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIView;

/**
 * This element can be used to insert an arbitrary UIView
 *
 * There is no cell reuse here as we have a 1:1 mapping in this case from the
 * UIViewElement to the cell that holds our view.
 */
public class UIViewElement extends Element implements IElementSizing {

    static int count;
    NSString key;
    protected UIView View;
    public CellFlags Flags;

    public enum CellFlags {
        Transparent, DisableSelection;
    }

    /**
     * Constructor
     *
     * @param caption
     *            The caption, only used for RootElements that might want to
     *            summarize results
     * @param view
     *            The view to display
     * @param transparent
     *            If this is set, then the view is responsible for painting the
     *            entire area, otherwise the default cell paint code will be
     *            used.
     */
    public UIViewElement(String caption, UIView view, boolean transparent) {
        super(caption);
        this.View = view;
        this.Flags = transparent ? CellFlags.Transparent : 0;
        key = new NSString("UIViewElement" + count++);
    }

    @Override
    protected NSString getCellKey() {
        return key;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = tv.DequeueReusableCell(getCellKey());
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
                    getCellKey());
            if ((Flags & CellFlags.Transparent) != 0) {
                cell.setBackgroundColor(UIColor.CLEAR);

                //
                // This trick is necessary to keep the background clear, otherwise
                // it gets painted as black
                //
                UIView empty = new UIView(CGRect.empty());
                empty.setBackgroundColor(UIColor.CLEAR);
                cell.setBackgroundView(empty);
            }
            if ((Flags & CellFlags.DisableSelection) != 0)
                cell.setSelectionStyle(UITableViewCellSelectionStyle.NONE);

            if (Caption != null)
                cell.getTextLabel().setText(Caption);
            cell.getContentView().addSubview(View);
        }
        return cell;
    }

    public float GetHeight(UITableView tableView, NSIndexPath indexPath) {
        return View.getBounds().size.height;
    }

    @Override
    protected void Dispose(boolean disposing) {
        super.Dispose(disposing);
        if (disposing) {
            if (View != null) {
                View.Dispose();
                View = null;
            }
        }
    }
}