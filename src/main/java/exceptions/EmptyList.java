package exceptions;

/**
 * Error if the list is empty.
 *
 * @author Ong Li Min
 */

public class EmptyList extends Exception {
    protected String message;

    /**
     * Constructor for an empty list.
     *
     */
    public EmptyList() {
        super("List is empty.");
    }
}