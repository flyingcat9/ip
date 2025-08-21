public class InvalidInput extends Exception {
    protected String message;
    public InvalidInput() {
        super("Input is invalid.");
    }
}