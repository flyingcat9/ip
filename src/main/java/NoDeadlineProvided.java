/**
 * Error run if the user does not provide a deadline.
 */

public class NoDeadlineProvided extends Exception{
    public NoDeadlineProvided() {
        super("No deadline is provided, please add one.");
    }
}