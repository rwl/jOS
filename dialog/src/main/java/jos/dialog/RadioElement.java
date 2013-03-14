package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellAccessoryType;

public class RadioElement extends StringElement {

    private String Group;

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

        if (!(root.getGroup() instanceof RadioGroup))
            throw new RuntimeException(
                    "The RootElement's Group is null or is not a RadioGroup");

        boolean selected = RadioIdx == ((RadioGroup) root.getGroup())
                .getSelected();
        cell.setAccessoryType(selected ? UITableViewCellAccessoryType.CHECKMARK
                : UITableViewCellAccessoryType.NONE);

        return cell;
    }

    @Override
    public void Selected(DialogViewController dvc, UITableView tableView,
            NSIndexPath indexPath) {
        RootElement root = (RootElement) Parent.Parent;
        if (RadioIdx != root.getRadioSelected()) {
            UITableViewCell cell;
            NSIndexPath selectedIndex = root.PathForRadio(root
                    .getRadioSelected());
            if (selectedIndex != null) {
                cell = tableView.cellAt(selectedIndex);
                if (cell != null)
                    cell.setAccessoryType(UITableViewCellAccessoryType.NONE);
            }
            cell = tableView.cellAt(indexPath);
            if (cell != null)
                cell.setAccessoryType(UITableViewCellAccessoryType.CHECKMARK);
            root.setRadioSelected(RadioIdx);
        }

        super.Selected(dvc, tableView, indexPath);
    }

    public void setRadioIdx(int value) {
        RadioIdx = value;
    }

    public String getGroup() {
        return Group;
    }

}