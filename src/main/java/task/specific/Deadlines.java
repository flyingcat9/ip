package task.specific;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import exceptions.InvalidDateInput;
import exceptions.InvalidElementInList;
import task.Task;

/**
 * This class is meant for tasks that have deadlines.
 *
 * @author Ong Li Min
 */
public class Deadlines extends Task {
    private final LocalDate deadline;

    /**
     * Creating a new Deadline
     * @param description description of a deadline task
     * @param deadline when the task must be done
     */
    public Deadlines(String description, String deadline) throws InvalidElementInList, InvalidDateInput {
        super(description);
        try {
            assert deadline != null;
            this.deadline = LocalDate.parse(deadline);
        } catch (Exception e) {
            throw new InvalidDateInput();
        }
    }

    /**
     * Create a new Deadline
     * @param description description of the deadline
     * @param deadline when the task should be done
     * @param finishStatus whether it has been completed or not
     */
    public Deadlines(String description, String deadline, boolean finishStatus)
            throws InvalidElementInList, InvalidDateInput {
        super(description, finishStatus);
        try {
            assert deadline != null;
            this.deadline = LocalDate.parse(deadline);
        } catch (Exception e) {
            throw new InvalidDateInput();
        }
    }


    /**
     * Create a new Deadline
     * @param description description of the deadline
     * @param deadline when the task should be done
     * @param finishStatus whether it has been completed or not
     */
    public Deadlines(String description, String deadline, boolean finishStatus,
                     ArrayList<String> tags) throws InvalidElementInList, InvalidDateInput {
        super(description, finishStatus, tags);
        try {
            assert deadline != null;
            this.deadline = LocalDate.parse(deadline);
        } catch (Exception e) {
            throw new InvalidDateInput();
        }
    }

    /**
     * Return the String for a Deadline task
     * @return a string
     */
    public String toString() {
        String e = this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[Deadline]" + super.toString() + " (by: " + e + ") "
                + super.taggedToPrint();
    }

    @Override
    public String store() {
        return "[Deadline]\"\"" + super.store()
                + "\\by" + deadline.toString() + "\"\"" + super.taggedStrings();
    }

    public String getDeadline() {
        return this.deadline.toString();
    }
}
