/**
 * This class is meant for tasks that have deadlines.
 *
 * @author Ong Li Min
 */
public class Deadlines extends Task{
    String deadline;

    /**
     * Creating a new Deadline
     * @param description description of a deadline task
     * @param deadline when the task must be done
     */
    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public Deadlines(String description, String deadline, boolean finishStatus) {
        super(description, finishStatus);
        this.deadline = deadline;
    }

    /**
     * Return the String for a Deadline task
     * @return a string
     */
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}