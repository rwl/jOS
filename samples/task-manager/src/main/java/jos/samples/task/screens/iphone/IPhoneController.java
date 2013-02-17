package jos.samples.task.screens.iphone;

import jos.api.uikit.UITableViewController;

public class IPhoneController extends UITableViewController {

    TaskTableSource _tableSource = null;
    Screen _detailsScreen = null;

    public IPhoneController() {
        super();
        initialize ();
        setTitle("Tasky");
    }

    protected void initialize()
    {
        getNavigationItem().setRightBarButtonItem(new UIBarButtonItem (UIBarButtonSystemItem.Add), false);
        getNavigationItem().getRightBarButtonItem();//.Clicked += (sender, e) => { this.ShowTaskDetails(new Task()); };
    }

    protected void showTaskDetails(Task task)
    {
        _detailsScreen = new Screen(task);
        getNavigationController().pushViewController(this._detailsScreen, true);
    }

    @Override
    public void viewWillAppear (boolean animated)
    {
        super.viewWillAppear (animated);

        // reload/refresh
        populateTable();
    }

    protected void populateTable()
    {
        _tableSource = new TaskTableSource(TaskManager.GetTasks());
        _tableSource.taskDeleted();// += (object sender, TaskClickedEventArgs e) => { this.DeleteTaskRow(e.Task.ID); };
        _tableSource.taskClicked();// += (object sender, TaskClickedEventArgs e) => { this.ShowTaskDetails(e.Task); };
        getTableView().setSource(_tableSource);
    }

    protected void seleteTaskRow(int id)
    {
        TaskManager.DeleteTask(id);
        populateTable();
    }

}
