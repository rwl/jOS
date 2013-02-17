package jos.samples.task.core.access;

import jos.samples.task.core.data.TaskDatabase;

public class TaskManager {

    TaskDatabase _db = null;
    protected static File _dbLocation;
    protected static TaskManager _me;

    static
    {
        _me = new TaskManager();
    }

    protected TaskManager()
    {
        // set the db location
        //_dbLocation = new File(NSBundle.getMainBundle().getBundlePath(), "Library/TaskDB.db3");
        _dbLocation = new File(Environment.getFolderPath(Environment.getSpecialFolder().getPersonal()), "TaskDB.db3");
        // instantiate the database
        _db = new TaskDatabase(_dbLocation);
    }

    public static Task getTask(int id)
    {
        return _me._db.getTask(id);
    }

    public static Iterable<Task> getTasks ()
    {
        return _me._db.getTasks();
    }

    public static int saveTask (Task item)
    {
        return _me._db.saveTask(item);
    }

    public static int deleteTask(int id)
    {
        return _me._db.deleteTask(id);
    }

}
