package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;

/**
 *  This interface is implemented by Elements that needs to update
 *  their cells Background properties just before they are displayed
 *  to the user.   This is an iOS 3 requirement to properly render
 *  a cell.
 */
public interface IColorizeBackground {
    void WillDisplay (UITableView tableView, UITableViewCell cell,
            NSIndexPath indexPath);
}