package exceptions;

/**
 * Error happens if the input is invalid.
 *
 * @author Ong Li Min
 */

public class InvalidInput extends Exception {
    protected String message;

    /**
     * Error for invalid input.
     * @param e to be passed up
     */
    public InvalidInput(String e) {
        super(e);
    }
}
