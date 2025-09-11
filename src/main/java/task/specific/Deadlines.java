package task.specific;

import java.util.ArrayList;

import task.Task;

/**
 * This class is meant for tasks that have deadlines.
 *
 * @author Ong Li Min
 */
public class Deadlines extends Task {
    private String deadline;

    /**
     * Creating a new Deadline
     * @param description description of a deadline task
     * @param deadline when the task must be done
     */
    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Create a new Deadline
     * @param description description of the deadline
     * @param deadline when the task should be done
     * @param finishStatus whether it has been completed or not
     */
    public Deadlines(String description, String deadline, boolean finishStatus) {
        super(description, finishStatus);
        this.deadline = deadline;
    }


    /**
     * Create a new Deadline
     * @param description description of the deadline
     * @param deadline when the task should be done
     * @param finishStatus whether it has been completed or not
     */
    public Deadlines(String description, String deadline, boolean finishStatus,
                     ArrayList<String> tags) {
        super(description, finishStatus, tags);
        this.deadline = deadline;
    }

    /**
     * Return the String for a Deadline task
     * @return a string
     */
    public String toString() {
        return "[Deadline]" + super.toString() + " (by: " + deadline + ")"
                + super.taggedToPrint();
    }

    /**
     * Used ChatGPT's idea to have a separate idea
     * for serialization instead of using the toString method.
     */
    @Override
    public String store() {
        return "[Deadline]\"\"" + super.store()
                + "\\by" + this.deadline + "\"\"" + super.taggedStrings();
    }

    public String getDeadline() {
        return this.deadline;
    }
}
