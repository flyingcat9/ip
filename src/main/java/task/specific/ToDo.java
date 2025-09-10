package task.specific;

import task.Task;

/**
 * This class represents a task that should be done.
 * @author: Ong Li Min
 */
public class ToDo extends Task {


    /**
     * Creating a new task.specific.ToDo task
     * @param description of task
     * @param finishType whether it is completed or not
     */
    public ToDo(String description, boolean finishType) {
        super(description, finishType);
    }

    /**
     * string
     * @return the string
     */
    @Override
    public String toString() {
        return "[ToDo] " + super.toString();
    }

    /**
     * store the thing correctly
     */
    @Override
    public String store() {
        return "[ToDo]\"\"" + super.store();
    }
}
