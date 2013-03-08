package jos.dialog;

import jos.api.foundation.NSString;
import jos.api.uikit.UIColor;
import jos.api.uikit.UIControlEvent;
import jos.api.uikit.UISwitch;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;

/**
 * Used to display switch on the screen.
 */
public class BooleanElement extends BoolElement {

    static NSString bkey = new NSString("BooleanElement");

    UISwitch sw;

    public BooleanElement(String caption, boolean value) {
        super(caption, value);
    }

    public BooleanElement(String caption, boolean value, String key) {
        super(caption, value);
    }

    @Override
    protected NSString getCellKey() {
        return bkey;
    }

    @Override
    public UITableViewCell GetCell (UITableView tv)
    {
        if (sw == null){
            sw = new UISwitch ();
            sw.setBackgroundColor(UIColor.CLEAR);
            sw.setTag(1);
            sw.setOn(getValue());
            sw.addTarget(new Target() {
//                Value = sw.On;
            }, UIControlEvent.VALUE_CHANGED);
        } else {
            sw.setOn(getValue());
        }

        UITableViewCell cell = tv.dequeueReusableCell(getCellKey());
        if (cell == null){
            cell = new UITableViewCell(UITableViewCellStyle.DEFAULT, getCellKey());
            cell.setSelectionStyle(UITableViewCellSelectionStyle.NONE);
        } else {
            RemoveTag (cell, 1);
        }

        cell.getTextLabel().setText(Caption);
        cell.setAccessoryView(sw);

        return cell;
    }

    @Override
    protected void Dispose(boolean disposing) {
        if (disposing) {
            if (sw != null) {
                sw.Dispose();
                sw = null;
            }
        }
    }

    @Override
    public boolean getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(boolean value) {
        super.setValue(value);
        if (sw != null)
            sw.setOn(value);
    }
}