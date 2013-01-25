package jos.api.uikit;

import jos.api.foundation.NSIndexPath;

import com.google.j2objc.annotations.Register;

@Register(isWrapper = true)
public class UITableViewSource extends UIScrollViewDelegate {

    public int numberOfSections(UITableView tableView) {
        return 0;
    }

    public int rowsInSection(UITableView tableview, int section) {
        return 0;
    }

    public String titleForHeader(UITableView tableView, int section) {
        return null;
    }

    public String titleForFooter(UITableView tableView, int section) {
        return null;
    }

    public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath) {
        return null;
    }

    public void rowSelected(UITableView tableView, NSIndexPath indexPath) {      
    }

}
