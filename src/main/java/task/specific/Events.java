package task.specific;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import exceptions.EventTimelineInvalid;
import exceptions.InvalidDateInput;
import exceptions.InvalidElementInList;
import task.Task;

/**
 * This class represents an event. In other words, there is a
 * starting and an ending time.
 * NTS: add a comparator to compare startingTime and endingTime
 * @author: Ong Li Min
 */
public class Events extends Task {
    private final LocalDate startingTime;
    private final LocalDate endingTime;

    /**
     * Creating an event.
     * @param description description of event
     * @param sT starting time
     * @param eT ending time
     */
    public Events(String description, String sT, String eT) throws
            InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        super(description);
        try {
            this.startingTime = LocalDate.parse(sT);
            this.endingTime = LocalDate.parse(eT);
        } catch (DateTimeParseException e) {
            throw new InvalidDateInput();
        }
        if (startingTime.isAfter(endingTime)) {
            throw new EventTimelineInvalid();
        }
    }

    /**
     * Creating an event.
     * @param description description of event
     * @param sT starting time
     * @param eT ending time
     */
    public Events(String description, String sT, String eT, boolean finishType,
                  ArrayList<String> tags) throws
            InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        super(description, finishType, tags);
        try {
            assert sT != null : "the starting time is null";
            assert eT != null : "the ending time is null";
            this.startingTime = LocalDate.parse(sT);
            this.endingTime = LocalDate.parse(eT);
        } catch (DateTimeParseException e) {
            throw new InvalidDateInput();
        }
        if (startingTime.isAfter(endingTime)) {
            throw new EventTimelineInvalid();
        }
    }

    /**
     * Another constructor for the events
     * @param description description of the task
     * @param sT starting time
     * @param eT ending time
     * @param finishResult of whether it has been completed or not
     */
    public Events(String description, String sT, String eT, boolean finishResult)
            throws InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        super(description);
        try {
            assert sT != null : "the starting time is null";
            assert eT != null : "the ending time is null";
            this.startingTime = LocalDate.parse(sT);
            this.endingTime = LocalDate.parse(eT);
        } catch (DateTimeParseException e) {
            throw new InvalidDateInput();
        }
        if (startingTime.isAfter(endingTime)) {
            throw new EventTimelineInvalid();
        }
    }


    public String getEndingTime() {
        assert this.endingTime != null : "the ending time is null";
        return this.endingTime.toString();
    }

    public String getStaringTime() {
        assert this.startingTime != null : "the starting time is null";
        return this.startingTime.toString();
    }

    /**
     * returns a string
     * @return the string
     */
    public String toString() {
        String stringStarting = this.startingTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String stringEnding = this.endingTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[Events]" + super.toString()
                + " (from: " + stringStarting + " to: " + stringEnding + ") "
                + super.taggedToPrint();
    }

    /**
     * returns the stored way
     * @return stored method
     */
    @Override
    public String store() {
        return "[Events]\"\"" + super.store() + "\\from"
                + startingTime.toString() + "\"\"" + "\\to" + endingTime.toString()
                + "\"\"" + super.taggedStrings();
    }
}

