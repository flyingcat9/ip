/**
 * This class represents a task that needs to be done.
 *
 * @author: Ong Li Min
 */
public class Task {
    protected String descript;
    protected Boolean progressStatus;

    /**
     * Creates a task
     * @param d description
     * @param p progress
     */
    public Task(String d, Boolean p) {
        descript = d;
        progressStatus = p;
    }

    /**
     * Creates a new task
     * @param d description
     */
    public Task(String d) {
        descript = d;
        progressStatus = false;
    }

    /**
     * Returns the status
     * @return the string as provided
     */
    public String getProgressStatus() {
        if (progressStatus.equals(false)) {
            return " ";
        }
        return "X";
    }

    /**
     * marks task as completed
     */
    public void mark() {
        this.progressStatus = true;
    }

    /**
     * unmarks the task
     */
    public void unMark() {
        this.progressStatus = false;
    }

    /**
     * Returns the task as a toString
     * @return nicely formatted String
     */
    public String toString() {
        return "[" + this.getProgressStatus() + "] " + this.descript;
    }


}