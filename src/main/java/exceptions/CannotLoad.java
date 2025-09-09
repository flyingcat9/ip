package exceptions;

/**
 * Error if the list is empty.
 *
 * @author Ong Li Min
 */

public class CannotLoad extends Exception {
    protected String message;

    /**
     * Constructor for an empty list.
     *
     */
    public CannotLoad() {
        super("Unable to load list.");
    }
}
