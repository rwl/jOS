package jos.api.uikit;

import jos.api.foundation.NSIndexPath;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public abstract class UITableViewDelegate {

    @Export("tableView:didSelectRowAtIndexPath:")
    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {
    }

}