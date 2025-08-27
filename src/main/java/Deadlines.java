/**
 * This class is meant for tasks that have deadlines.
 *
 * @author Ong Li Min
 */
public class Deadlines extends Task{
    String deadline;

    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}