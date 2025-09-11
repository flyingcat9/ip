package task.specific;

import java.util.ArrayList;

import task.Task;

/**
 * This class represents an event. In other words, there is a
 * starting and an ending time.
 * NTS: add a comparator to compare startingTime and endingTime
 * @author: Ong Li Min
 */
public class Events extends Task {
    private String startingTime;
    private String endingTime;

    /**
     * Creating an event.
     * @param description description of event
     * @param sT starting time
     * @param eT ending time
     */
    public Events(String description, String sT, String eT) {
        super(description);
        this.startingTime = sT;
        this.endingTime = eT;
    }

    /**
     * Creating an event.
     * @param description description of event
     * @param sT starting time
     * @param eT ending time
     */
    public Events(String description, String sT, String eT, boolean finishType,
                  ArrayList<String> tags) {
        super(description, finishType, tags);
        this.startingTime = sT;
        this.endingTime = eT;
    }

    /**
     * Another constructor for the events
     * @param description description of the task
     * @param sT starting time
     * @param eT ending time
     * @param finishResult of whether it has been completed or not
     */
    public Events(String description, String sT, String eT, boolean finishResult) {
        super(description, finishResult);
        this.startingTime = sT;
        this.endingTime = eT;
    }

    public String getEndingTime() {
        return this.endingTime;
    }

    public String getStaringTime() {
        return this.startingTime;
    }




    /**
     * returns a string
     * @return string of the event
     */
    public String toString() {
        return "[Events]" + super.toString()
                + " (from: " + startingTime + " to: " + endingTime + ")"
                + super.taggedToPrint();
    }

    /**
     * returns the stored way
     * @return stored method
     */
    @Override
    public String store() {
        return "[Events]\"\"" + super.store() + "\\from"
                + startingTime + "\"\"" + "\\to" + endingTime
                + "\"\"" + super.taggedStrings();
    }
}

