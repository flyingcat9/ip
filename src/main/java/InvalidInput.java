/**
 * Error happens if the input is invalid.
 *
 * @author Ong Li Min
 */

public class InvalidInput extends Exception {
    protected String message;

    /**
     * Error for invalid input.
     */
    public InvalidInput() {
        super("Input is invalid.");
    }
}