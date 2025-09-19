package task.specific;

import java.util.ArrayList;

import exceptions.InvalidElementInList;
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
    public ToDo(String description, boolean finishType) throws InvalidElementInList {
        super(description, finishType);
    }


    /**
     * Creating a new task.specific.ToDo task
     * @param description of task
     * @param finishType whether it is completed or not
     * @param tags the tags a description it is related to
     */
    public ToDo(String description, boolean finishType, ArrayList<String> tags)
            throws InvalidElementInList {
        super(description, finishType, tags);
    }

    /**
     * string
     * @return the string
     */
    @Override
    public String toString() {
        return "[ToDo]" + super.toString() + super.taggedToPrint();
    }

    /**
     * store the thing correctly
     */
    @Override
    public String store() {
        return "[ToDo]\"\"" + super.store() + super.taggedStrings();
    }
}
