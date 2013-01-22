package jos.api.uikit;

import jos.api.foundation.NSObject;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Model;

@BaseType({UIViewController.class, UITableViewDelegate.class, UITableViewDataSource.class})
@Model
public class UITableViewController extends UIViewController {

    public UITableViewController(UITableViewStyle grouped) {
    }

    public UITableView tableView;

    @Export(selector = "tableView")
    public UITableView getTableView() {
        return this.tableView;
    }

    @Export(selector = "setTableView:")
    public void setTableView(UITableView value) {
        this.tableView = value;
    }

    public boolean clearsSelectionOnViewWillAppear;

    @Export(selector = "clearsSelectionOnViewWillAppear")
    public boolean getClearsSelectionOnViewWillAppear() {
        return this.clearsSelectionOnViewWillAppear;
    }

    @Export(selector = "setClearsSelectionOnViewWillAppear:")
    public void setClearsSelectionOnViewWillAppear(boolean value) {
        this.clearsSelectionOnViewWillAppear = value;
    }

    /*public UIRefreshControl refreshControl;

    @Export(selector = "refreshControl")
    public UIRefreshControl getRefreshControl() {
        return this.refreshControl;
    }

    @Export(selector = "setRefreshControl:")
    public void setRefreshControl(UIRefreshControl value) {
        this.refreshControl = value;
    }*/

    public NSObject initWithStyle(UITableViewStyle style) {
        return null;
    }

}

