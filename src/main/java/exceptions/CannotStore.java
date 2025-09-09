package exceptions;

/**
 * Error if the list is empty.
 *
 * @author Ong Li Min
 */

public class CannotStore extends Exception {
    protected String message;

    /**
     * Constructor for an empty list.
     *
     */
    public CannotStore() {
        super("Unable to store content.");
    }
}
