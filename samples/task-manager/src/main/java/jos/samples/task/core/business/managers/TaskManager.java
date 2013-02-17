package jos.samples.task.core.business.managers;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    public static Task getTask(int id)
    {
        return jos.samples.task.core.access.TaskManager.getTask(id);
    }

    public static List<Task> getTasks ()
    {
        return new ArrayList<Task>(jos.samples.task.core.access.TaskManager.getTasks());
    }

    public static int saveTask (Task item)
    {
        return jos.samples.task.core.access.TaskManager.saveTask(item);
    }

    public static int deleteTask(int id)
    {
        return jos.samples.task.core.access.TaskManager.deleteTask(id);
    }

}
