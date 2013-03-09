package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;

public class CheckboxElement extends StringElement {

    private boolean Value;
    private String Group;

    public CheckboxElement(String caption) {
        super(caption);
    }

    public CheckboxElement(String caption, boolean value) {
        super(caption);
        Value = value;
    }

    public CheckboxElement(String caption, boolean value, String group) {
        this(caption, value);
        Group = group;
    }

    UITableViewCell ConfigCell(UITableViewCell cell) {
        cell.setAccessoryType(Value ? UITableViewCellAccessoryType.CHECKMARK
                : UITableViewCellAccessoryType.NONE);
        return cell;
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        return ConfigCell(super.GetCell(tv));
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath path) {
        Value = !Value;
        UITableViewCell cell = tableView.cellAt(path);
        ConfigCell(cell);
        super.Selected(dvc, tableView, path);
    }

    public String getGroup() {
        return Group;
    }

    public boolean getValue() {
        return Value;
    }

    public void setValue(boolean value) {
        Value = value;
    }

}