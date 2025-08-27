/**
 * This class represents a task that should be done.
 * @author: Ong Li Min
 */
public class ToDo extends Task{

    /**
     * Creating a new to do task.
     * @param description
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * string
     * @return the string
     */
    public String toString() {
        return "[ToDo]" + super.toString();
    }
}