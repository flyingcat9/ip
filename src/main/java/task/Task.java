package task;

import java.util.ArrayList;

/**
 * This class represents a task that needs to be done.
 *
 * @author: Ong Li Min
 */
public class Task {
    protected String descript;
    protected Boolean progressStatus;
    protected ArrayList<String> tags = new ArrayList<>();

    /**
     * Creates a task
     * @param d description
     * @param p progress
     * @param tag tags it's associated with
     */
    public Task(String d, Boolean p, ArrayList<String> tag) {
        for (int i = 0; i < tag.size(); i++) {
            tags.add(tag.get(i));
        }
        this.descript = d;
        this.progressStatus = p;
    }


    /**
     * Creates a task
     * @param d description
     * @param p progress
     */
    public Task(String d, Boolean p) {
        this.descript = d;
        this.progressStatus = p;
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
            return "O";
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
        return " [" + this.getProgressStatus() + "] " + this.descript + " ";
    }



    /**
     * Used ChatGPT's idea of using a separate method
     * @return stored way
     */
    public String store() {
        return "[" + this.getProgressStatus() + "]\"\"" + this.descript + "\"\"";
    }

    /**
     * returns tags as strings
     * @return tagged Strings
     */
    public String taggedStrings() {
        String s = "";
        for (int i = 0; i < tags.size(); i++) {
            s += tags.get(i) + "\"\"";
        }
        return s;
    }

    /**
     * returns tags as strings
     * @return String to print
     */
    public String taggedToPrint() {
        String s = "";
        for (int i = 0; i < tags.size(); i++) {
            s += tags.get(i) + " ";
        }
        return s;
    }

    /**
     * Add tags to an element in the tasklist
     * @param theTags any tags the user wants to add
     */
    public void addTags(String[] theTags) {
        for (int i = 0; i < theTags.length; i++) {
            tags.add(theTags[i]);
        }
    }

    /**
     * Delete/remove tags to elements in the tasklist.
     * @param theTags any tags the user wants to remove
     */
    public void removeTags(String[] theTags) {
        for (int i = 0; i < theTags.length; i++) {
            tags.remove(theTags[i]);
        }
        if (theTags.length == 0) {
            tags.clear();
        }
    }




}

