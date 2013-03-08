package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSString;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UIView;

/**
 * Base class for all elements
 */
public abstract class Element {

    /**
     * Handle to the container object. For sections this points to a
     * RootElement, for every other object this points to a Section and it is
     * null for the root RootElement.
     */
    public Element Parent;

    /**
     * The caption to display for this given element
     */
    public String Caption;

    /**
     * Initializes the element with the given caption.
     */
    public Element(String caption) {
        this.Caption = caption;
    }

    public void Dispose() {
        Dispose(true);
    }

    protected void Dispose(boolean disposing) {
    }

    static NSString cellkey = new NSString("xx");

    /**
     * Subclasses that override the GetCell method should override this method
     * as well
     *
     * This method should return the key passed to
     * UITableView.DequeueReusableCell. If your code overrides the GetCell
     * method to change the cell, you must also override this method and return
     * a unique key for it.
     *
     * This works in most subclasses with a couple of exceptions: StringElement
     * and various derived classes do not use this setting as they need a wider
     * range of keys for different uses, so you need to look at the source code
     * for those if you are trying to override StringElement or
     * StyledStringElement.
     */
    protected NSString getCellKey() {
        return cellkey;
    }

    /**
     * Gets a UITableViewCell for this element. Can be overridden, but if you
     * customize the style or contents of the cell you must also override the
     * CellKey property in your derived class.
     */
    public UITableViewCell GetCell(UITableView tv) {
        return new UITableViewCell(UITableViewCellStyle.DEFAULT, getCellKey());
    }

    static protected void RemoveTag(UITableViewCell cell, int tag) {
        UIView viewToRemove = cell.getContentView().getViewWithTag(tag);
        if (viewToRemove != null)
            viewToRemove.removeFromSuperview();
    }

    /**
     * Returns a summary of the value represented by this object, suitable for
     * rendering as the result of a RootElement with child objects.
     *
     * @return The return value must be a short description of the value.
     */
    public String Summary() {
        return "";
    }

    /**
     * Invoked when the given element has been deslected by the user.
     *
     * @param dvc
     *            The <see cref="DialogViewController"/> where the deselection
     *            took place
     * @param tableView
     *            The <see cref="UITableView"/> that contains the element.
     * @param path
     *            The <see cref="NSIndexPath"/> that contains the Section and
     *            Row for the element.
     */
    public void Deselected(DialogViewController dvc,
            UITableView tableView, NSIndexPath path) {
    }

    /**
     * Invoked when the given element has been selected by the user.
     *
     * @param dvc
     *            The <see cref="DialogViewController"/> where the selection
     *            took place
     * @param tableView
     *            The <see cref="UITableView"/> that contains the element.
     * @param path
     *            The <see cref="NSIndexPath"/> that contains the Section and
     *            Row for the element.
     */
    public void Selected(DialogViewController dvc,
            UITableView tableView, NSIndexPath path) {
    }

    /**
     * If the cell is attached will return the immediate RootElement
     */
    public RootElement GetImmediateRootElement() {
        Section section = (Section) Parent;
        if (section == null)
            section = (Section) this;
        if (section == null)
            return null;
        return (RootElement) section.Parent;
    }

    /**
     * Returns the UITableView associated with this element, or null if this
     * cell is not currently attached to a UITableView
     */
    public UITableView GetContainerTableView() {
        RootElement root = GetImmediateRootElement();
        if (root == null)
            return null;
        return root.TableView;
    }

    /**
     * Returns the currently active UITableViewCell for this element, or null if
     * the element is not currently visible
     */
    public UITableViewCell GetActiveCell() {
        UITableView tv = GetContainerTableView();
        if (tv == null)
            return null;
        NSIndexPath path = IndexPath;
        if (path == null)
            return null;
        return tv.CellAt(path);
    }

    /**
     * Returns the IndexPath of a given element. This is only valid for leaf
     * elements, it does not work for a toplevel RootElement or a Section of if
     * the Element has not been attached yet.
     */
    public NSIndexPath getIndexPath() {
        Section section = (Section) Parent;
        if (section == null)
            return null;
        RootElement root = (RootElement) section.Parent;
        if (root == null)
            return null;

        int row = 0;
        for (Element element : section.Elements) {
            if (element.equals(this)) {
                int nsect = 0;
                for (Section sect : root.Sections) {
                    if (section == sect) {
                        return NSIndexPath.fromRowSection(row, nsect);
                    }
                    nsect++;
                }
            }
            row++;
        }
        return null;
    }

    /**
     * Method invoked to determine if the cell matches the given text, never
     * invoked with a null value or an empty string.
     */
    public boolean Matches(String text) {
        if (Caption == null)
            return false;
        return Caption.equalsIgnoreCase(text);
    }
}
