package jos.dialog;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;

/**
 *  This interface is implemented by Element classes that will have
 *  different heights
 */
public interface IElementSizing {
    float GetHeight (UITableView tableView, NSIndexPath indexPath);
}