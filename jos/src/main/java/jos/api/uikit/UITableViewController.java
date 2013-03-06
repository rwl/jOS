package jos.api.uikit;

import com.google.j2objc.annotations.BaseType;
import com.google.j2objc.annotations.Export;
import com.google.j2objc.annotations.Register;

@BaseType({ UITableViewDelegate.class, UITableViewDataSource.class })
@Register(isWrapper = true)
public class UITableViewController extends UIViewController {

    @Export("init")
    public UITableViewController() {
        super();
    }

    @Export("initWithStyle:")
    public UITableViewController(UITableViewStyle grouped) {
    }

    public UITableView tableView;

    @Export("tableView")
    public UITableView getTableView() {
        return this.tableView;
    }

    @Export("setTableView:")
    public void setTableView(UITableView value) {
        this.tableView = value;
    }

    public boolean clearsSelectionOnViewWillAppear;

    @Export("clearsSelectionOnViewWillAppear")
    public boolean getClearsSelectionOnViewWillAppear() {
        return this.clearsSelectionOnViewWillAppear;
    }

    @Export("setClearsSelectionOnViewWillAppear:")
    public void setClearsSelectionOnViewWillAppear(boolean value) {
        this.clearsSelectionOnViewWillAppear = value;
    }

    public UIRefreshControl refreshControl;

    @Export("refreshControl")
    public UIRefreshControl getRefreshControl() {
        return this.refreshControl;
    }

    @Export("setRefreshControl:")
    public void setRefreshControl(UIRefreshControl value) {
        this.refreshControl = value;
    }

}
