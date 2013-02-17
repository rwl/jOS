package jos.samples.task.core.data;

import java.util.ArrayList;
import java.util.List;

import jos.samples.task.core.business.Task;

/**
 * TaskDatabase builds on SQLite.Net and represents a specific database, in our case, the Task DB.
 * It contains methods for retreival and persistance as well as db creation, all based on the
 * underlying ORM.
 */
public class TaskDatabase extends SQLiteConnection {

    /**
     * Initializes a new instance of the <see cref="Tasky.DL.TaskDatabase"/> TaskDatabase.
     * if the database doesn't exist, it will create the database and all the tables.
     */
    public TaskDatabase (String path) {
        super(path);
        // create the tables
        createTable<Task> ();
    }

    //TODO: make these methods generic, Add<T>(item), etc.

    public Iterable<Task> getTasks () {
        List<Task> tasks = new ArrayList<Task>();
        for (Task task : table()) {
            tasks.add(task);
        }
        return tasks;
    }

    public Task getTask (int id) {
        List<Task> tasks = new ArrayList<Task>();
        for (Task task : table()) {
            if (task.ID == id) {
                return task;
            }
        }
        return null;
    }

    public int saveTask (Task item) {
        if(item.ID != 0) {
            super.update(item);
            return item.ID;
        } else {
            return super.insert (item);
        }
    }

    public int deleteTask(int id) {
        return super.delete(new Task(id));
    }

}
