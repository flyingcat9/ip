package exceptions;

/**
 * Error if there are duplications.
 *
 * @author Ong Li Min
 */

public class DuplicationError extends Exception {
    protected String message;

    /**
     * Constructor for an empty list.
     *
     */
    public DuplicationError() {
        super("The list is empty, you can not "
                + "delete anything currently");
    }
}

