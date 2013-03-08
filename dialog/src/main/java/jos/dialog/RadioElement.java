package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;

public class RadioElement extends StringElement {

    public String Group;
    private int RadioIdx;

    public RadioElement(String caption, String group) {
        super(caption);
        Group = group;
    }

    public RadioElement(String caption) {
        super(caption);
    }

    @Override
    public UITableViewCell GetCell(UITableView tv) {
        UITableViewCell cell = super.GetCell(tv);
        RootElement root = (RootElement) Parent.Parent;

        if (!(root.group instanceof RadioGroup))
            throw new Exception(
                    "The RootElement's Group is null or is not a RadioGroup");

        boolean selected = RadioIdx == ((RadioGroup) root.group).getSelected();
        cell.setAccessory(selected ? UITableViewCellAccessoryType.CHECKMARK
                : UITableViewCellAccessoryType.NONE);

        return cell;
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath indexPath) {
        RootElement root = (RootElement) Parent.Parent;
        if (RadioIdx != root.RadioSelected) {
            UITableViewCell cell;
            selectedIndex = root.PathForRadio(root.RadioSelected);
            if (selectedIndex != null) {
                cell = tableView.CellAt(selectedIndex);
                if (cell != null)
                    cell.setAccessory(UITableViewCellAccessoryType.NONE);
            }
            cell = tableView.CellAt(indexPath);
            if (cell != null)
                cell.setAccessory(UITableViewCellAccessoryType.CHECKMARK);
            root.setRadioSelected(RadioIdx);
        }

        super.Selected(dvc, tableView, indexPath);
    }
}