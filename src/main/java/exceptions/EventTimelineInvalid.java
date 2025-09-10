package exceptions;

/**
 * Error if starting date is after ending date.
 *
 * @author Ong Li Min
 */

public class EventTimelineInvalid extends Exception {
    protected String message;

    /**
     * Constructor for an empty list.
     *
     */
    public EventTimelineInvalid() {
        super("Your starting date is after your ending date");
    }
}

