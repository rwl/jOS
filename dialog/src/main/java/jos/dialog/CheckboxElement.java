package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;

public class CheckboxElement extends StringElement {

    public boolean Value;
    public String Group;

    public CheckboxElement (String caption) {
        super(caption);
    }

    public CheckboxElement (String caption, boolean value) {
        super(caption);
        Value = value;
    }

    public CheckboxElement (String caption, boolean value, String group) {
        this (caption, value);
        Group = group;
    }

    UITableViewCell ConfigCell (UITableViewCell cell)
    {
        cell.Accessory = Value ? UITableViewCellAccessoryType.CHECKMARK : UITableViewCellAccessoryType.NONE;
        return cell;
    }

    @Override
    public UITableViewCell GetCell (UITableView tv)
    {
        return  ConfigCell (super.GetCell (tv));
    }

    @Override
    public void Selected (DialogViewController dvc, UITableView tableView, NSIndexPath path)
    {
        Value = !Value;
        UITableViewCell cell = tableView.CellAt (path);
        ConfigCell (cell);
        super.Selected (dvc, tableView, path);
    }

}