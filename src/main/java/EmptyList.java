public class EmptyList extends Exception {
    protected String message;
    public EmptyList() {
        super("List is empty.");
    }
}