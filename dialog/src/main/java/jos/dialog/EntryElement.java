package jos.dialog;

import static jos.api.graphicsimaging.CGGeometry.makeSize;
import static jos.api.graphicsimaging.CGGeometry.makeRect;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSString;
import jos.api.foundation.NSRange;
import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIKeyboardType;
import jos.api.uikit.UIReturnKeyType;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellSelectionStyle;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewScrollPosition;
import jos.api.uikit.UITextAlignment;
import jos.api.uikit.UITextAutocapitalizationType;
import jos.api.uikit.UITextAutocorrectionType;
import jos.api.uikit.UITextField;
import jos.api.uikit.UITextFieldDelegate;
import jos.api.uikit.UITextFieldViewMode;
import jos.api.uikit.UIUserInterfaceIdiom;
import jos.api.uikit.UIViewAutoresizing;

/**
 * An element that can be used to enter text.
 *
 * This element can be used to enter text both regular and password protected
 * entries.
 *
 * The Text fields in a given section are aligned with each other.
 */
public class EntryElement extends Element {

    /**
     * The value of the EntryElement
     */
    public String getValue() {
        if (entry == null)
            return val;
        String newValue = entry.getText();
        if (newValue == val)
            return val;
        val = newValue;

        if (Changed != null)
            Changed.onEvent(this, null);
        return val;
    }

    public void setValue(String value) {
        val = value;
        if (entry != null)
            entry.setText(value);
    }

    protected String val;

    /**
     * The key used for reusable UITableViewCells.
     */
    private static NSString entryKey = new NSString("EntryElement");

    protected NSString getEntryKey() {
        return entryKey;
    }

    /**
     * The type of keyboard used for input, you can change this to use this for
     * numeric input, email addressed, urls, phones.
     */
    public UIKeyboardType getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(UIKeyboardType value) {
        keyboardType = value;
        if (entry != null)
            entry.setKeyboardType(value);
    }

    /**
     * The type of Return Key that is displayed on the keyboard, you can change
     * this to use this for Done, Return, Save, etc. keys on the keyboard
     */
    public UIReturnKeyType getReturnKeyType() {
        return returnKeyType;
    }

    public void setReturnKeyType(UIReturnKeyType value) {
        returnKeyType = value;
        if (entry != null && returnKeyType != null)
            entry.setReturnKeyType(returnKeyType);
    }

    public UITextAutocapitalizationType getAutocapitalizationType() {
        return autocapitalizationType;
    }

    public void setAutocapitalizationType(UITextAutocapitalizationType value) {
        autocapitalizationType = value;
        if (entry != null)
            entry.setAutocapitalizationType(value);
    }

    public UITextAutocorrectionType getAutocorrectionType() {
        return autocorrectionType;
    }

    public void setAutocorrectionType(UITextAutocorrectionType value) {
        autocorrectionType = value;
        if (entry != null)
            this.autocorrectionType = value;
    }

    public UITextFieldViewMode getClearButtonMode() {
        return clearButtonMode;
    }

    public void setClearButtonMode(UITextFieldViewMode value) {
        clearButtonMode = value;
        if (entry != null)
            entry.setClearButtonMode(value);
    }

    public UITextAlignment getTextAlignment() {
        return textalignment;
    }

    public void setTextAlignment(UITextAlignment value) {
        textalignment = value;
        if (entry != null) {
            entry.setTextAlignment(textalignment);
        }
    }

    private UITextAlignment textalignment = UITextAlignment.LEFT;
    private UIKeyboardType keyboardType = UIKeyboardType.DEFAULT;
    private UIReturnKeyType returnKeyType = null;
    private UITextAutocapitalizationType autocapitalizationType = UITextAutocapitalizationType.SENTENCES;
    private UITextAutocorrectionType autocorrectionType = UITextAutocorrectionType.DEFAULT;
    private UITextFieldViewMode clearButtonMode = UITextFieldViewMode.NEVER;
    private boolean isPassword, becomeResponder;
    private UITextField entry;
    private String placeholder;
    private static final UIFont font = UIFont.boldSystemFontOfSize(17);

    public interface ShouldReturnHandler {
        public boolean shouldReturn();
    }

    public EventListener Changed;
    public ShouldReturnHandler ShouldReturn;
    public EventListener EntryStarted;
    public EventListener EntryEnded;

    /**
     * Constructs an EntryElement with the given caption, placeholder and
     * initial value.
     *
     * @param caption
     *            The caption to use
     * @param placeholder
     *            Placeholder to display when no value is set.
     * @param value
     *            Initial value.
     */
    public EntryElement(String caption, String placeholder, String value) {
        super(caption);
        setValue(value);
        this.placeholder = placeholder;
    }

    /**
     * Constructs an EntryElement for password entry with the given caption,
     * placeholder and initial value.
     *
     * @param caption
     *            The caption to use.
     * @param placeholder
     *            Placeholder to display when no value is set.
     * @param value
     *            Initial value.
     * @param isPassword
     *            True if this should be used to enter a password.
     */
    public EntryElement(String caption, String placeholder, String value,
            boolean isPassword) {
        super(caption);
        setValue(value);
        this.isPassword = isPassword;
        this.placeholder = placeholder;
    }

    @Override
    public String Summary() {
        return getValue();
    }

    //
    // Computes the X position for the entry by aligning all the entries in the Section
    //
    private CGSize ComputeEntryPosition(UITableView tv, UITableViewCell cell) {
        Section s = (Section) Parent;
        if (s.getEntryAlignment().width != 0)
            return s.getEntryAlignment();

        // If all EntryElements have a null Caption, align UITextField with the Caption
        // offset of normal cells (at 10px).
        CGSize max = makeSize(-15, new NSString("M").sizeWithFont(font).height);
        for (Element e : s) {
            EntryElement ee = (EntryElement) e;
            if (ee == null)
                continue;

            if (ee.Caption != null) {
                CGSize size = new NSString(ee.getCaption()).sizeWithFont(font);
                if (size.width > max.width)
                    max = size;
            }
        }
        s.setEntryAlignment(makeSize(25 + Math.min(max.width, 160), max.height));
        return s.getEntryAlignment();
    }

    protected UITextField CreateTextField(CGRect frame) {
        UITextField tf = new UITextField(frame);
        tf.setAutoresizingMask(UIViewAutoresizing.FLEXIBLE_WIDTH
                | UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN);
        tf.setPlaceholder(placeholder == null ? "" : placeholder);
        tf.setSecureTextEntry(isPassword);
        tf.setText(getValue() == null ? "" : getValue());
        tf.setTag(1);
        tf.setTextAlignment(textalignment);
        tf.setClearButtonMode(clearButtonMode);
        return tf;
    }

    static final NSString passwordKey = new NSString("EntryElement+Password");
    static final NSString cellkey = new NSString("EntryElement");

    @Override
    protected NSString getCellKey() {
        return isPassword ? passwordKey : cellkey;
    }

    UITableViewCell cell;

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT,
                    getCellKey());
            cell.setSelectionStyle(UITableViewCellSelectionStyle.NONE);
        }
        cell.getTextLabel().setText(Caption);

        int offset = (UIDevice.getCurrentDevice().getUserInterfaceIdiom() == UIUserInterfaceIdiom.PHONE) ? 20
                : 90;
        cell.setFrame(makeRect(cell.getFrame().origin.x,
                cell.getFrame().origin.y, tv.getFrame().size.width - offset,
                cell.getFrame().size.height));
        CGSize size = ComputeEntryPosition(tv, cell);
        float yOffset = (cell.getContentView().getBounds().size.height - size.height) / 2 - 1;
        float width = cell.getContentView().getBounds().size.width - size.width;
        if (textalignment == UITextAlignment.RIGHT) {
            // Add padding if right aligned
            width -= 10;
        }
        CGRect entryFrame = makeRect(size.width, yOffset, width, size.height);

        if (entry == null) {
            entry = CreateTextField(entryFrame);
            entry.setDelegate(new UITextFieldDelegate() {
                public boolean valueChanged(UITextField textField,
                        NSRange range, String string) {
                    FetchValue();
                }

                public void ended(UITextField textField) {
                    FetchValue();
                    if (EntryEnded != null) {
                        EntryEnded.onEvent(this, null);
                    }
                }

                public boolean shouldReturn(UITextField textField) {
                    if (ShouldReturn != null)
                        return ShouldReturn.shouldReturn();

                    RootElement root = GetImmediateRootElement();
                    EntryElement focus = null;

                    if (root == null)
                        return true;

                    for (Section s : root) {
                        for (Element e : s) {
                            if (e.equals(EntryElement.this)) {
                                focus = EntryElement.this;
                            } else if (focus != null
                                    && e instanceof EntryElement) {
                                focus = (EntryElement) e;
                                break;
                            }
                        }

                        if (focus != null && !focus.equals(this))
                            break;
                    }

                    if (!focus.equals(this))
                        focus.BecomeFirstResponder(true);
                    else
                        focus.ResignFirstResponder(true);

                    return true;

                }

                public void started(UITextField textField) {
                    EntryElement self = null;

                    if (EntryStarted != null) {
                        EntryStarted.onEvent(this, null);
                    }

                    if (returnKeyType == null) {
                        UIReturnKeyType returnType = UIReturnKeyType.DEFAULT;

                        for (Element e : (Section) Parent) {
                            if (e.equals(this))
                                self = this;
                            else if (self != null && e instanceof EntryElement)
                                returnType = UIReturnKeyType.NEXT;
                        }
                        entry.setReturnKeyType(returnType);
                    } else
                        entry.setReturnKeyType(returnKeyType);

                    tv.scrollToRow(getIndexPath(),
                            UITableViewScrollPosition.MIDDLE, true);

                }
            });
            cell.getContentView().addSubview(entry);
        } else
            entry.setFrame(entryFrame);

        if (becomeResponder) {
            entry.becomeFirstResponder();
            becomeResponder = false;
        }
        entry.setKeyboardType(getKeyboardType());

        entry.setAutocapitalizationType(getAutocapitalizationType());
        entry.setAutocorrectionType(getAutocorrectionType());

        return cell;
    }

    /**
     * Copies the value from the UITextField in the EntryElement to the Value
     * property and raises the Changed event if necessary.
     */
    public void FetchValue() {
        if (entry == null)
            return;

        String newValue = entry.getText();
        if (newValue == getValue())
            return;

        setValue(newValue);

        if (Changed != null)
            Changed.onEvent(this, null);
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (entry != null) {
                entry.dealloc();
                entry = null;
            }
        }
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath indexPath) {
        BecomeFirstResponder(true);
        tableView.deselectRow(indexPath, true);
    }

    @Override
    public boolean Matches(String text) {
        return (getValue() != null ? getValue().equalsIgnoreCase(text) : false)
                || super.Matches(text);
    }

    /**
     * Makes this cell the first responder (get the focus)
     *
     * @param animated
     *            Whether scrolling to the location of this cell should be
     *            animated
     */
    public void BecomeFirstResponder(boolean animated) {
        becomeResponder = true;
        UITableView tv = GetContainerTableView();
        if (tv == null)
            return;
        tv.scrollToRow(getIndexPath(), UITableViewScrollPosition.MIDDLE,
                animated);
        if (entry != null) {
            entry.becomeFirstResponder();
            becomeResponder = false;
        }
    }

    public void ResignFirstResponder(boolean animated) {
        becomeResponder = false;
        UITableView tv = GetContainerTableView();
        if (tv == null)
            return;
        tv.scrollToRow(getIndexPath(), UITableViewScrollPosition.MIDDLE,
                animated);
        if (entry != null)
            entry.resignFirstResponder();
    }

}