package exceptions;

/**
 * Error happens if the input is invalid.
 *
 * @author Ong Li Min
 */

public class InvalidElementInList extends Exception {
    protected String message;

    /**
     * Error for invalid input.
     */
    public InvalidElementInList() {
        super("You are accessing an invalid element.");
    }
}
