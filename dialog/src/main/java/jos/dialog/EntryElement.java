package jos.dialog;

import jos.api.graphicsimaging.CGRect;
import jos.api.graphicsimaging.CGSize;
import jos.api.uikit.UIDevice;
import jos.api.uikit.UIFont;
import jos.api.uikit.UIKeyboardType;
import jos.api.uikit.UIReturnKeyType;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
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
            Changed(this/*, EventArgs.Empty*/);
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
    static NSString entryKey = new NSString("EntryElement");

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
        if (entry != null && returnKeyType.hasValue())
            entry.setReturnKeyType(returnKeyType.getValue());
    }

    public UITextAutocapitalizationType getAutocapitalizationType() {
        return autocapitalizationType;
    }

    public void setAutocapitalizationType(UITextAutocapitalizationType value) {
        autocapitalizationType = value;
        if (entry != null)
            entry.AutocapitalizationType = value;
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

    UITextAlignment textalignment = UITextAlignment.LEFT;
    UIKeyboardType keyboardType = UIKeyboardType.Default;
    UIReturnKeyType returnKeyType = null;
    UITextAutocapitalizationType autocapitalizationType = UITextAutocapitalizationType.Sentences;
    UITextAutocorrectionType autocorrectionType = UITextAutocorrectionType.Default;
    UITextFieldViewMode clearButtonMode = UITextFieldViewMode.Never;
    boolean isPassword, becomeResponder;
    UITextField entry;
    String placeholder;
    static UIFont font = UIFont.boldSystemFontOfSize(17);

    public EventHandler Changed;
    public Method<Boolean>/*Func<bool>*/ShouldReturn;
    public EventHandler EntryStarted;
    public EventHandler EntryEnded;

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
        Value = value;
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
        Value = value;
        this.isPassword = isPassword;
        this.placeholder = placeholder;
    }

    @Override
    public String Summary() {
        return Value;
    }

    //
    // Computes the X position for the entry by aligning all the entries in the Section
    //
    CGSize ComputeEntryPosition(UITableView tv, UITableViewCell cell) {
        Section s = (Section) Parent;
        if (s.getEntryAlignment().Width != 0)
            return s.getEntryAlignment();

        // If all EntryElements have a null Caption, align UITextField with the Caption
        // offset of normal cells (at 10px).
        CGSize max = makeSize(-15, tv.StringSize("M", font).Height);
        for (Element e : s.Elements) {
            EntryElement ee = (EntryElement) e;
            if (ee == null)
                continue;

            if (ee.Caption != null) {
                var size = tv.StringSize(ee.Caption, font);
                if (size.Width > max.Width)
                    max = size;
            }
        }
        s.setEntryAlignment(makeSize(25 + Math.Min(max.Width, 160), max.Height));
        return s.getEntryAlignment();
    }

    protected UITextField CreateTextField (CGRect frame)
    {
        UITextField tf = new UITextField (frame);
        tf.setAutoresizingMask = UIViewAutoresizing.FLEXIBLE_WIDTH | UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN);
        tf.setPlaceholder(placeholder == null ? "" : placeholder);
        tf.setSecureTextEntry(isPassword);
        tf.setText(Value == null ? "" : Value);
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
        cell.setFrame(makeRect(cell.getFrame().x, cell.getFrame().y,
                tv.getFrame().width - offset, cell.getFrame().height));
        CGSize size = ComputeEntryPosition(tv, cell);
        float yOffset = (cell.getContentView().getBounds().Height - size.Height) / 2 - 1;
        float width = cell.getContentView().getBounds().width - size.width;
        if (textalignment == UITextAlignment.RIGHT) {
            // Add padding if right aligned
            width -= 10;
        }
        CGRect entryFrame = makeRect(size.Width, yOffset, width, size.Height);

        if (entry == null) {
            entry = createTextField(entryFrame);
            entry.setDelegate(new UITextFieldDelegate() {
                public boolean valueChanged(UITextField textField, NSRange range, String string) {
                    FetchValue ();
                }

                public void ended(UITextField textField) {
                    FetchValue ();
                    if (EntryEnded != null) {
                        EntryEnded (this, null);
                    }
                }

                public boolean shouldReturn(UITextField textField) {
                    if (ShouldReturn != null)
                        return ShouldReturn ();

                    RootElement root = GetImmediateRootElement ();
                    EntryElement focus = null;

                    if (root == null)
                        return true;

                    for (Section s : root.Sections) {
                        for (Element e : s.Elements) {
                            if (e.equals(this)) {
                                focus = this;
                            } else if (focus != null && e instanceof EntryElement) {
                                focus = (EntryElement) e;
                                break;
                            }
                        }

                        if (focus != null && !focus.equals(this))
                            break;
                    }

                    if (!focus.equals(this))
                        focus.BecomeFirstResponder (true);
                    else
                        focus.ResignFirstResponder (true);

                    return true;

                }
                public void started(UITextField textField) {
                    EntryElement self = null;

                    if (EntryStarted != null) {
                        EntryStarted (this, null);
                    }

                    if (!returnKeyType.HasValue) {
                        UIReturnKeyType returnType = UIReturnKeyType.Default;

                        for (Element e : ((Section) Parent).Elements) {
                            if (e.equals(this))
                                self = this;
                            else if (self != null && e instanceof EntryElement)
                                returnType = UIReturnKeyType.Next;
                        }
                        entry.setReturnKeyType(returnType);
                    } else
                        entry.setReturnKeyType(returnKeyType.Value);

                    tv.ScrollToRow (IndexPath, UITableViewScrollPosition.MIDDLE, true);

                }
            });
            cell.getContentView().addSubview(entry);
        } else
            entry.setFrame(entryFrame);

        if (becomeResponder) {
            entry.becomeFirstResponder();
            becomeResponder = false;
        }
        entry.setKeyboardType(KeyboardType);

        entry.setAutocapitalizationType(AutocapitalizationType);
        entry.setAutocorrectionType(AutocorrectionType);

        return cell;
    }

    /**
     * Copies the value from the UITextField in the EntryElement to the Value
     * property and raises the Changed event if necessary.
     */
    public void FetchValue() {
        if (entry == null)
            return;

        newValue = entry.getText();
        if (newValue == Value)
            return;

        Value = newValue;

        if (Changed != null)
            Changed(this/*, EventArgs.Empty*/);
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (entry != null) {
                entry.Dispose();
                entry = null;
            }
        }
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath indexPath) {
        BecomeFirstResponder(true);
        tableView.DeselectRow(indexPath, true);
    }

    @Override
    public boolean Matches(String text) {
        return (Value != null ? Value.equalsIgnoreCase(text) : false)
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
        tv.ScrollToRow(IndexPath, UITableViewScrollPosition.Middle, animated);
        if (entry != null) {
            entry.BecomeFirstResponder();
            becomeResponder = false;
        }
    }

    public void ResignFirstResponder(boolean animated) {
        becomeResponder = false;
        UITableView tv = GetContainerTableView();
        if (tv == null)
            return;
        tv.ScrollToRow(IndexPath, UITableViewScrollPosition.Middle, animated);
        if (entry != null)
            entry.ResignFirstResponder();
    }

}