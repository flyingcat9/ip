package exceptions;

/**
 * Error happens if the input is invalid.
 *
 * @author Ong Li Min
 */

public class InvalidDateInput extends Exception {
    protected String message;

    /**
     * Error for invalid input.
     */
    public InvalidDateInput() {
        super("Invalid date input, please format as YYYY-DD-MM");
    }
}
