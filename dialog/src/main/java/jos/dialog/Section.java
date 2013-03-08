package jos.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewRowAnimation;

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
public class Section extends Element implements IEnumerable {

    Object header, footer;
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
        HeaderView = header;
    }

    public Section(UIView header, UIView footer) {
        super(null);
        HeaderView = header;
        FooterView = footer;
    }

    /**
     * The section header, as a string
     */
    public String getHeader() {
            return header as string;
        }

    public void setHeader(String value) {
        header = value;
    }

    /**
     * The section footer, as a string.
     */
    public String getFooter() {
        return (String) footer;
    }

    public void setFooter(String value) {
        footer = value;
    }

    /**
     * The section's header view.
     */
    public UIView getHeaderView() {
            return header as UIView;
        }

    public void setHeaderView(UIView value) {
        header = value;
    }

    /**
     * The section's footer view.
     */
    public UIView getFooterView() {
            return footer as UIView;
        }

    public void setFooterView(UIView value) {
        footer = value;
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

        Elements.Add(element);
        element.Parent = this;

        if (Parent != null)
            InsertVisual(Elements.Count - 1, UITableViewRowAnimation.NONE, 1);
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
    public void Add(IEnumerable<UIView> views) {
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
            Elements.Insert(pos++, e);
            e.Parent = this;
        }
        RootElement root = (RootElement) Parent;
        if (Parent != null && root.TableView != null) {
            if (anim == UITableViewRowAnimation.NONE)
                root.getTableView().ReloadData();
            else
                InsertVisual(idx, anim, newElements.Length);
        }
    }

    public int Insert(int idx, UITableViewRowAnimation anim,
            List<Element> newElements) {
        if (newElements == null)
            return 0;

        int pos = idx;
        int count = 0;
        for (Element e : newElements) {
            Elements.Insert(pos++, e);
            e.Parent = this;
            count++;
        }
        RootElement root = (RootElement) Parent;
        if (root != null && root.TableView != null) {
            if (anim == UITableViewRowAnimation.NONE)
                root.getTableView().ReloadData();
            else
                InsertVisual(idx, anim, pos - idx);
        }
        return count;
    }

    void InsertVisual(int idx, UITableViewRowAnimation anim, int count) {
        var root = (RootElement) Parent;

        if (root == null || root.TableView == null)
            return;

        int sidx = root.IndexOf(this);
        NSIndexPath[] paths = new NSIndexPath[count];
        for (int i = 0; i < count; i++)
            paths[i] = NSIndexPath.FromRowSection(idx + i, sidx);

        root.getTableView().InsertRows(paths, anim);
    }

    public void Insert(int index, Element... newElements) {
        Insert(index, UITableViewRowAnimation.None, newElements);
    }

    public void Remove(Element e) {
        if (e == null)
            return;
        for (int i = Elements.Count; i > 0;) {
            i--;
            if (Elements[i] == e) {
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
        RemoveRange(start, count, UITableViewRowAnimation.Fade);
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

        Elements.RemoveRange(start, count);

        if (root == null || root.TableView == null)
            return;

        int sidx = root.IndexOf(this);
        NSIndexPath[] paths = new NSIndexPath[count];
        for (int i = 0; i < count; i++)
            paths[i] = NSIndexPath.FromRowSection(start + i, sidx);
        root.TableView.DeleteRows(paths, anim);
    }

    /**
     * Enumerator to get all the elements in the Section.
     */
    public List GetEnumerator() {
        //        for (Element e : Elements)
        //            yield return e;
    }

    public int Count() {
        return Elements.Count;
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
}