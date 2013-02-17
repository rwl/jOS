package jos.samples.task.core.business;

import java.util.Date;

public class Task {

    @PrimaryKey
    @AutoIncrement
    public int ID;
    public String name;
    public String notes;
    public Date dueDate;

}
