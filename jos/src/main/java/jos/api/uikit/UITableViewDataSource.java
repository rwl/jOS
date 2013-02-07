package jos.api.uikit;

import jos.api.foundation.NSIndexPath;
import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;
import com.google.j2objc.annotations.Register;

@Model
@Register(isWrapper = true)
public abstract class UITableViewDataSource extends NSObject {

    @Export("numberOfSectionsInTableView:")
    public int numberOfSections(UITableView tableView) {
        return 0;
    }

    @Export("tableView:numberOfRowsInSection:")
    public abstract int rowsInSection(UITableView tableview, int section);

    @Export("tableView:titleForHeaderInSection:")
    public String titleForHeader(UITableView tableView, int section) {
        return null;
    }

    @Export("tableView:titleForFooterInSection:")
    public String titleForFooter(UITableView tableView, int section) {
        return null;
    }

    @Export("tableView:cellForRowAtIndexPath:")
    public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath) {
        return null;
    }

}
