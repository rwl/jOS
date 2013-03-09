package jos.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewRowAnimation;
import jos.api.uikit.UIView;

/**
 * Sections contain individual Element instances that are rendered by
 * MonoTouch.Dialog
 *
 * Sections are used to group elements in the screen and they are the only valid
 * direct child of the RootElement. Sections can contain any of the standard
 * elements, including new RootElements.
 *
 * RootElements embedded in a section are used to navigate to a new deeper
 * level.
 *
 * You can assign a header and a footer either as strings (Header and Footer)
 * properties, or as UIViews to be shown (HeaderView and FooterView). Internally
 * this uses the same storage, so you can only show one or the other.
 */
public class Section extends Element implements Iterable<Element> {

    Object Header, Footer;

    private List<Element> Elements = new ArrayList<Element>();

    // X corresponds to the alignment, Y to the height of the password
    private CGSize EntryAlignment;

    /**
     * Constructs a Section without header or footers.
     */
    public Section() {
        super(null);
    }

    /**
     * Constructs a Section with the specified header
     *
     * @param caption
     *            The header to display
     */
    public Section(String caption) {
        this(caption, new Element[0]);
    }

    public Section(String caption, Element... elements) {
        super(caption);
        Elements = Arrays.asList(elements);
    }

    /**
     * Constructs a Section with a header and a footer
     *
     * @param caption
     *            The caption to display (or null to not display a caption)
     * @param footer
     *            The footer to display.
     */
    public Section(String caption, String footer) {
        super(caption);
        Footer = footer;
    }

    public Section(UIView header) {
        super(null);
        setHeaderView(header);
    }

    public Section(UIView header, UIView footer) {
        super(null);
        setHeaderView(header);
        setFooterView(footer);
    }

    /**
     * The section header, as a string
     */
    public String getHeader() {
        return (String) Header;
    }

    public void setHeader(String value) {
        Header = value;
    }

    /**
     * The section footer, as a string.
     */
    public String getFooter() {
        return (String) Footer;
    }

    public void setFooter(String value) {
        Footer = value;
    }

    /**
     * The section's header view.
     */
    public UIView getHeaderView() {
        return (UIView) Header;
    }

    public void setHeaderView(UIView value) {
        Header = value;
    }

    /**
     * The section's footer view.
     */
    public UIView getFooterView() {
        return (UIView) Footer;
    }

    public void setFooterView(UIView value) {
        Footer = value;
    }

    /**
     * Adds a new child Element to the Section
     *
     * @param element
     *            An element to add to the section.
     */
    public void Add(Element element) {
        if (element == null)
            return;

        Elements.add(element);
        element.setParent(this);

        if (Parent != null)
            InsertVisual(Elements.size() - 1, UITableViewRowAnimation.NONE, 1);
    }

    public int AddAll(List<Element> elements) {
        int count = 0;
        for (Element e : elements) {
            Add(e);
            count++;
        }
        return count;
    }

    /**
     * Use to add a UIView to a section, it makes the section opaque, to get a
     * transparent one, you must manually call UIViewElement
     */
    public void Add(UIView view) {
        if (view == null)
            return;
        Add(new UIViewElement(null, view, false));
    }

    /**
     * Adds the UIViews to the section.
     */
    public void Add(Iterable<UIView> views) {
        for (UIView v : views)
            Add(v);
    }

    /**
     * Inserts a series of elements into the Section using the specified
     * animation
     *
     * @param idx
     *            The index where the elements are inserted
     * @param anim
     *            The animation to use
     * @param newElements
     *            A series of elements.
     */
    public void Insert(int idx, UITableViewRowAnimation anim,
            Element... newElements) {
        if (newElements == null)
            return;

        int pos = idx;
        for (Element e : newElements) {
            Elements.add(pos++, e);
            e.setParent(this);
        }
        RootElement root = (RootElement) Parent;
        if (Parent != null && root.getTableView() != null) {
            if (anim == UITableViewRowAnimation.NONE)
                root.getTableView().reloadData();
            else
                InsertVisual(idx, anim, newElements.length);
        }
    }

    public int Insert(int idx, UITableViewRowAnimation anim,
            List<Element> newElements) {
        if (newElements == null)
            return 0;

        int pos = idx;
        int count = 0;
        for (Element e : newElements) {
            Elements.add(pos++, e);
            e.setParent(this);
            count++;
        }
        RootElement root = (RootElement) Parent;
        if (root != null && root.getTableView() != null) {
            if (anim == UITableViewRowAnimation.NONE)
                root.getTableView().reloadData();
            else
                InsertVisual(idx, anim, pos - idx);
        }
        return count;
    }

    void InsertVisual(int idx, UITableViewRowAnimation anim, int count) {
        RootElement root = (RootElement) Parent;

        if (root == null || root.getTableView() == null)
            return;

        int sidx = root.IndexOf(this);
        NSIndexPath[] paths = new NSIndexPath[count];
        for (int i = 0; i < count; i++)
            paths[i] = NSIndexPath.fromRowSection(idx + i, sidx);

        root.getTableView().insertRows(paths, anim);
    }

    public void Insert(int index, Element... newElements) {
        Insert(index, UITableViewRowAnimation.NONE, newElements);
    }

    public void Remove(Element e) {
        if (e == null)
            return;
        for (int i = Elements.size(); i > 0;) {
            i--;
            if (Elements.get(i).equals(e)) {
                RemoveRange(i, 1);
                return;
            }
        }
    }

    public void Remove(int idx) {
        RemoveRange(idx, 1);
    }

    /**
     * Removes a range of elements from the Section
     *
     * @param start
     *            Starting position
     * @param count
     *            Number of elements to remove from the section
     */
    public void RemoveRange(int start, int count) {
        RemoveRange(start, count, UITableViewRowAnimation.FADE);
    }

    /**
     * Remove a range of elements from the section with the given animation
     *
     * @param start
     *            Starting position
     * @param count
     *            Number of elements to remove form the section
     * @param anim
     *            The animation to use while removing the elements
     */
    public void RemoveRange(int start, int count, UITableViewRowAnimation anim) {
        if (start < 0 || start >= Elements.size())
            return;
        if (count == 0)
            return;

        RootElement root = (RootElement) Parent;

        if (start + count > Elements.size())
            count = Elements.size() - start;

        Elements.subList(start, count).clear();

        if (root == null || root.getTableView() == null)
            return;

        int sidx = root.IndexOf(this);
        NSIndexPath[] paths = new NSIndexPath[count];
        for (int i = 0; i < count; i++)
            paths[i] = NSIndexPath.fromRowSection(start + i, sidx);
        root.getTableView().deleteRows(paths, anim);
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = new UITableViewCell(
                UITableViewCellStyle.DEFAULT, "");
        cell.getTextLabel().setText("Section was used for Element");

        return cell;
    }

    public List<Element> getElements() {
        return Elements;
    }

    @Override
    public Iterator<Element> iterator() {
        return Elements.iterator();
    }

    public int Count() {
        return Elements.size();
    }

    public Element get(int idx) {
        return Elements.get(idx);
    }

    public void Clear() {
        if (Elements != null) {
            for (Element e : Elements)
                e.Dispose();
        }
        Elements = new ArrayList<Element>();

        RootElement root = (RootElement) Parent;
        if (root != null && root.getTableView() != null)
            root.getTableView().reloadData();
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            Parent = null;
            Clear();
            Elements = null;
        }
        super.Dispose(disposing);
    }

    public CGSize getEntryAlignment() {
        return EntryAlignment;
    }

}