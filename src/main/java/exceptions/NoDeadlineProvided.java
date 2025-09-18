package exceptions;

/**
 * Error happens if the there is no deadline provided.
 *
 * @author Ong Li Min
 */

public class NoDeadlineProvided extends Exception {
    protected String message;

    /**
     * Error for invalid input.
     */
    public NoDeadlineProvided() {
        super("No deadline is provided, please add one.");
    }
}
