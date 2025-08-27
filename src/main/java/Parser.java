import java.util.Arrays;

public class Parser {
    public enum Commands {
        LIST,
        MARK,
        UNMARK,
        DELETE,
        INVALID
    }

    public Commands checkerOfCommand(String s) {
        for (Commands c : Commands.values()) {
            if (s.equalsIgnoreCase(c.name())) {
                return c;
            }
        }
        return Commands.INVALID;
    }

    /**
     * This function checks to see what the user wants to do.
     *
     * @param s user's message
     * @param e the echo they have
     * @return formatted String
     */

    public static String validityOfWords(String s, TaskList e) throws InvalidInput, EmptyList {
        s = s.toLowerCase().trim();
        String t = "";
        String[] p = s.split("\\s+");
        Parser pa = new Parser();
        Commands command = pa.checkerOfCommand(p[0].toLowerCase());
        switch (command) {
            case LIST:
                t += e.printList();
                break;
            case UNMARK:
                // need a try-catch if list isn't that long
                t += e.unmark(Integer.parseInt(p[1]));
                break;
            case MARK:
                t += e.mark(Integer.parseInt(p[1]));
                break;
            case DELETE:
                t += e.delete(Integer.parseInt(p[1]));
                break;
            default:
                t += e.addToList(s);

        }

        return t;

    }
}
