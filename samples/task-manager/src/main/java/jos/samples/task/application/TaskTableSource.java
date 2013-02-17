package jos.samples.task.application;

import java.util.ArrayList;
import java.util.List;

import jos.api.foundation.NSIndexPath;
import jos.api.uikit.UITableView;
import jos.api.uikit.UITableViewCell;
import jos.api.uikit.UITableViewCellStyle;
import jos.api.uikit.UITableViewDataSource;

public class TaskTableSource extends UITableViewDataSource {

    public /*event*/ EventHandler<TaskClickedEventArgs> TaskClicked;
    public /*event*/ EventHandler<TaskClickedEventArgs> TaskDeleted;

    protected String _cellId = "TaskCell";


    public List<Task> tasks;
    protected List<Task> _tasks = new ArrayList<Task>();

    public TaskTableSource (List<Task> tasks) {
        super();
        this._tasks = tasks;
    }

    @Override
    public UITableViewCell getCell(UITableView tableView, NSIndexPath indexPath)
    {
        UITableViewCell cell = tableView.dequeueReusableCell(_cellId);

        if(cell == null)
        {
            cell = new UITableViewCell(UITableViewCellStyle.VALUE1, _cellId);
        }

        cell.getTextLabel().setText(_tasks.get(indexPath.getRow()).getName());
        cell.getDetailTextLabel().setText(_tasks.get(indexPath.getRow()).getNotes());

        return cell;
    }

    @Override
    public int rowsInSection (UITableView tableview, int section)
    {
        return _tasks.size();
    }

    @Override
    public int numberOfSections (UITableView tableView)
    {
        return 1;
    }

    @Override
    public void rowSelected (UITableView tableView, NSIndexPath indexPath)
    {
        raiseTaskClicked(indexPath.getRow());
    }

    @Override
    public boolean canEditRow (UITableView tableView, NSIndexPath indexPath)
    {
         return true;
    }

    @Override
    public UITableViewCellEditingStyle editingStyleForRow (UITableView tableView, NSIndexPath indexPath)
    {
        return UITableViewCellEditingStyle.DELETE;
    }

    @Override
    public void commitEditingStyle (UITableView tableView, UITableViewCellEditingStyle editingStyle, NSIndexPath indexPath)
    {
        if(editingStyle == UITableViewCellEditingStyle.DELETE)
        {
            raiseTaskDeleted(indexPath.getRow());
        }
    }

    protected void raiseTaskClicked(int row)
    {
        // raise the event in a thread-safe way
        var handler = taskClicked;
        if(handler != null)
        {
            handler(this, new TaskClickedEventArgs(_tasks.get(row)));
        }
    }

    protected void raiseTaskDeleted(int row)
    {
        // raise the event in a thread-safe way
        var handler = taskDeleted;
        if(handler != null)
        {
            handler(this, new TaskClickedEventArgs(_tasks.get(row)));
        }
    }

}
