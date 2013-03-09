package jos.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSIndexSet;
import jos.api.foundation.NSRange;
import jos.api.foundation.NSString;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;
import jos.api.uikit.UITableViewCellSelectionStyle;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewRowAnimation;
import jos.api.uikit.UIViewController;

/**
 * RootElements are responsible for showing a full configuration page.
 *
 * At least one RootElement is required to start the jOS.Dialogs process.
 *
 * RootElements can also be used inside Sections to trigger loading a new nested
 * configuration page. When used in this mode the caption provided is used while
 * rendered inside a section and is also used as the Title for the subpage.
 *
 * If a RootElement is initialized with a section/element value then this value
 * is used to locate a child Element that will provide a summary of the
 * configuration which is rendered on the right-side of the display.
 *
 * RootElements are also used to coordinate radio elements. The RadioElement
 * members can span multiple Sections (for example to implement something
 * similar to the ring tone selector and separate custom ring tones from system
 * ringtones).
 *
 */
public class RootElement extends Element implements Iterable<Section> {

    public interface TapListener {
        public UIViewController onTap(RootElement root);
    }

    private static final NSString rkey1 = new NSString("RootElement1");
    private static final NSString rkey2 = new NSString("RootElement2");

    private int summarySection, summaryElement;
    private Group group;
    private boolean UnevenRows;
    private TapListener createOnSelected;
    private UITableView TableView;

    // This is used to indicate that we need the DVC to dispatch calls to
    // willDisplayCell so we can prepare the color of the cell before
    // display
    public boolean NeedColorUpdate;

    /**
     * Initializes a RootSection with a caption
     *
     * @param caption
     *            The caption to render.
     */
    public RootElement(String caption) {
        this(caption, new Section[0]);
    }

    public RootElement(String caption, Section... sections) {
        super(caption);
        summarySection = -1;
        Sections = Arrays.asList(sections);
    }

    /**
     * Initializes a RootSection with a caption and a callback that will create
     * the nested UIViewController that is activated when the user taps on the
     * element.
     *
     * @param caption
     *            The caption to render.
     */
    public RootElement(String caption, TapListener createOnSelected) {
        super(caption);
        summarySection = -1;
        this.createOnSelected = createOnSelected;
        Sections = new ArrayList<Section>();
    }

    /**
     * Initializes a RootElement with a caption with a summary fetched from the
     * specified section and leement
     *
     * @param caption
     *            The caption to render cref="System.String"/>
     * @param section
     *            The section that contains the element with the summary.
     * @param element
     *            The element index inside the section that contains the summary
     *            for this RootSection.
     */
    public RootElement(String caption, int section, int element) {
        super(caption);
        summarySection = section;
        summaryElement = element;
    }

    /**
     * Initializes a RootElement that renders the summary based on the radio
     * settings of the contained elements.
     *
     * @param caption
     *            The caption to ender
     * @param group
     *            The group that contains the checkbox or radio information.
     *            This is used to display the summary information when a
     *            RootElement is rendered inside a section.
     */
    public RootElement(String caption, Group group) {
        super(caption);
        this.group = group;
    }

    private List<Section> Sections = new ArrayList<Section>();

    private NSIndexPath PathForRadio(int idx) {
        RadioGroup radio = (RadioGroup) group;
        if (radio == null)
            return null;

        int current = 0, section = 0;
        for (Section s : Sections) {
            int row = 0;

            for (Element e : s) {
                if (!(e instanceof RadioElement))
                    continue;

                if (current == idx) {
                    return NSIndexPath.create(new int[] { section, row }, 2);
                }
                row++;
                current++;
            }
            section++;
        }
        return null;
    }

    public int getCount() {
        return Sections.size();
    }

    public Section get(int idx) {
        return Sections.get(idx);
    }

    protected int IndexOf(Section target) {
        int idx = 0;
        for (Section s : Sections) {
            if (s == target)
                return idx;
            idx++;
        }
        return -1;
    }

    public void Prepare() {
        int current = 0;
        for (Section s : Sections) {
            for (Element e : s) {
                RadioElement re = (RadioElement) e;
                if (re != null)
                    re.setRadioIdx(current++);
                if (UnevenRows == false && e instanceof IElementSizing)
                    UnevenRows = true;
                if (NeedColorUpdate == false
                        && e instanceof IColorizeBackground)
                    NeedColorUpdate = true;
            }
        }
    }

    /**
     * Adds a new section to this RootElement
     *
     * @param section
     *            The section to add, if the root is visible, the section is
     *            inserted with no animation
     */
    public void Add(Section section) {
        if (section == null)
            return;

        Sections.add(section);
        section.setParent(this);
        if (TableView == null)
            return;

        TableView.insertSections(MakeIndexSet(Sections.size() - 1, 1),
                UITableViewRowAnimation.NONE);
    }

    public void Add(List<Section> sections) {
        for (Section s : sections)
            Add(s);
    }

    NSIndexSet MakeIndexSet(int start, int count) {
        NSRange range = NSRange.makeRange(start, count);
        return NSIndexSet.fromRange(range);
    }

    /**
     * Inserts a new section into the RootElement
     *
     * @param idx
     *            The index where the section is added <see
     *            cref="System.Int32"/>
     * @param anim
     *            The <see cref="UITableViewRowAnimation"/> type.
     * @param newSections
     *            A <see cref="Section[]"/> list of sections to insert
     *
     *            This inserts the specified list of sections (a params
     *            argument) into the root using the specified animation.
     */
    public void Insert(int idx, UITableViewRowAnimation anim,
            Section... newSections) {
        if (idx < 0 || idx > Sections.size())
            return;
        if (newSections == null)
            return;

        if (TableView != null)
            TableView.beginUpdates();

        int pos = idx;
        for (Section s : newSections) {
            s.Parent = this;
            Sections.add(pos++, s);
        }

        if (TableView == null)
            return;

        TableView.insertSections(MakeIndexSet(idx, newSections.length), anim);
        TableView.endUpdates();
    }

    /**
     * Inserts a new section into the RootElement
     *
     * @param idx
     *            The index where the section is added <see
     *            cref="System.Int32"/>
     * @param newSections
     *            A <see cref="Section[]"/> list of sections to insert
     *
     *            This inserts the specified list of sections (a params
     *            argument) into the root using the Fade animation.
     */
    public void Insert(int idx, Section section) {
        Insert(idx, UITableViewRowAnimation.NONE, section);
    }

    /**
     * Removes a section at a specified location
     */
    public void RemoveAt(int idx) {
        RemoveAt(idx, UITableViewRowAnimation.FADE);
    }

    /**
     * Removes a section at a specified location using the specified animation
     *
     * @param idx
     *            A <see cref="System.Int32"/>
     * @param anim
     *            A <see cref="UITableViewRowAnimation"/>
     */
    public void RemoveAt(int idx, UITableViewRowAnimation anim) {
        if (idx < 0 || idx >= Sections.size())
            return;

        Sections.remove(idx);

        if (TableView == null)
            return;

        TableView.deleteSections(NSIndexSet.fromIndex(idx), anim);
    }

    public void Remove(Section s) {
        if (s == null)
            return;
        int idx = Sections.indexOf(s);
        if (idx == -1)
            return;
        RemoveAt(idx, UITableViewRowAnimation.FADE);
    }

    public void Remove(Section s, UITableViewRowAnimation anim) {
        if (s == null)
            return;
        int idx = Sections.indexOf(s);
        if (idx == -1)
            return;
        RemoveAt(idx, anim);
    }

    public void Clear() {
        for (Section s : Sections)
            s.Dispose();
        Sections = new ArrayList<Section>();
        if (TableView != null)
            TableView.reloadData();
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (Sections == null)
                return;

            TableView = null;
            Clear();
            Sections = null;
        }
    }

    /**
     * The currently selected Radio item in the whole Root.
     */
    public int getRadioSelected() {
        RadioGroup radio = (RadioGroup) group;
        if (radio != null)
            return radio.getSelected();
        return -1;
    }

    public void setRadioSelected(int value) {
        RadioGroup radio = (RadioGroup) group;
        if (radio != null)
            radio.setSelected(value);
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        NSString key = summarySection == -1 ? rkey1 : rkey2;
        UITableViewCell cell = tv.dequeueReusableCell(key);
        if (cell == null) {
            UITableViewCellStyle style = summarySection == -1 ? UITableViewCellStyle.DEFAULT
                    : UITableViewCellStyle.VALUE1;

            cell = new UITableViewCell(style, key);
            cell.setSelectionStyle(UITableViewCellSelectionStyle.BLUE);
        }

        cell.getTextLabel().setText(Caption);
        RadioGroup radio = (RadioGroup) group;
        if (radio != null) {
            int selected = radio.getSelected();
            int current = 0;

            for (Section s : Sections) {
                for (Element e : s) {
                    if (!(e instanceof RadioElement))
                        continue;

                    if (current == selected) {
                        cell.getDetailTextLabel().setText(e.Summary());

                        cell.setAccessoryType(UITableViewCellAccessoryType.DISCLOSURE_INDICATOR);

                        return cell;
                    }
                    current++;
                }
            }
        } else if (group != null) {
            int count = 0;

            for (Section s : Sections) {
                for (Element e : s) {
                    CheckboxElement ce = (CheckboxElement) e;
                    if (ce != null) {
                        if (ce.getValue())
                            count++;
                        continue;
                    }
                    BoolElement be = (BoolElement) e;
                    if (be != null) {
                        if (be.getValue())
                            count++;
                        continue;
                    }
                }
            }
            cell.getDetailTextLabel().setText(String.valueOf(count));
        } else if (summarySection != -1 && summarySection < Sections.size()) {
            Section s = Sections.get(summarySection);
            if (summaryElement < s.getElements().size()
                    && cell.getDetailTextLabel() != null)
                cell.getDetailTextLabel().setText(
                        s.getElements().get(summaryElement).Summary());
        }
        cell.setAccessoryType(UITableViewCellAccessoryType.DISCLOSURE_INDICATOR);

        return cell;
    }

    /**
     * This method does nothing by default, but gives a chance to subclasses to
     * customize the UIViewController before it is presented
     */
    protected void PrepareDialogViewController(UIViewController dvc) {
    }

    /**
     * Creates the UIViewController that will be pushed by this RootElement
     */
    protected UIViewController MakeViewController() {
        if (createOnSelected != null)
            return createOnSelected.onTap(this);

        DialogViewController dvc = new DialogViewController(this, true);
        dvc.setAutorotate(true);
        return dvc;
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath path) {
        tableView.deselectRow(path, false);
        UIViewController newDvc = MakeViewController();
        PrepareDialogViewController(newDvc);
        dvc.ActivateController(newDvc);
    }

    public void Reload(Section section, UITableViewRowAnimation animation) {
        if (section == null)
            throw new IllegalArgumentException("section");
        if (section.Parent == null || section.Parent != this)
            throw new IllegalArgumentException(
                    "Section is not attached to this root");

        int idx = 0;
        for (Section sect : Sections) {
            if (sect == section) {
                TableView.reloadSections(NSIndexSet.fromIndex(idx), animation);
                return;
            }
            idx++;
        }
    }

    public void Reload(Element element, UITableViewRowAnimation animation) {
        if (element == null)
            throw new IllegalArgumentException("element");
        Section section = (Section) element.Parent;
        if (section == null)
            throw new IllegalArgumentException(
                    "Element is not attached to this root");
        RootElement root = (RootElement) section.Parent;
        if (root == null)
            throw new IllegalArgumentException(
                    "Element is not attached to this root");
        NSIndexPath path = element.getIndexPath();
        if (path == null)
            return;
        TableView.reloadRowsAtIndexPathswithRowAnimation(
                new NSIndexPath[] { path }, animation);
    }

    public List<Section> getSections() {
        return Sections;
    }

    public UITableView getTableView() {
        return TableView;
    }

    @Override
    public Iterator<Section> iterator() {
        return Sections.iterator();
    }

}