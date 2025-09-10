package parse;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.EmptyList;
import exceptions.InvalidInput;
import storetasks.TaskList;

/**
 * Class in charge of validating the user commands
 *
 * @author Ong Li Min
 */
public class Parser {

    /**
     * Enum class in charge of splitting the different commands.
     */
    public enum Commands {
        LIST {
            /**
             * prints out the list
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment.
             */
            public String run(TaskList e, String[] statement) {
                return e.printList();
            }
        },
        MARK {
            /**
             * marks the list
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment.
             */
            public String run(TaskList e, String ... statement) throws EmptyList {
                if (e.lengthOfList() > 0) {
                    return e.mark(Integer.parseInt(statement[1]));
                }
                throw new EmptyList();
            }
        },
        UNMARK {
            /**
             * unmarks element in list
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment.
             */
            public String run(TaskList e, String ... statement) throws EmptyList {
                if (e.lengthOfList() > 0) {
                    return e.unmark(Integer.parseInt(statement[1]));
                }
                throw new EmptyList();
            }
        },

        DELETE {
            /**
             * deletes element in list
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment
             */
            public String run(TaskList e, String ... statement) throws EmptyList {
                if (e.lengthOfList() > 0) {
                    return e.delete(Integer.parseInt(statement[1]));
                }
                throw new EmptyList();
            }
        },
        FIND {
            /**
             * finds task in list
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment
             */
            public String run(TaskList e, String ... statement) throws EmptyList {
                if (e.lengthOfList() > 0) {
                    return e.find(String.join(" ",
                            Arrays.copyOfRange(statement, 1, statement.length)));
                }
                throw new EmptyList();
            }
        },
        BYE {
            /**
             * shuts down the thing
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment
             */
            public String run(TaskList e, String ... statement) {
                return "BYEBYEBYE";
            }
        },
        ADDTOLIST {
            /**
             * adds task to the list
             * @param e the TaskList you are working on
             * @param statement user statement
             * @return string comment
             */
            public String run(TaskList e, String ... statement) {
                return String.join(" ", statement);
            }
        };

        /**
         * does enum task in the list
         * @param e the TaskList you are working on
         * @param statement user statement
         * @return string comment
         */
        public abstract String run(TaskList e, String ... statement) throws EmptyList;
    }

    /**
     * Checks the command to see if it matches any of the above enums
     * @param s command
     * @return Commands appropriate command it correlates with
     */
    public Commands checkerOfCommand(String s) {
        for (Commands c : Commands.values()) {
            if (s.equalsIgnoreCase(c.name())) {
                return c;
            }
        }
        ArrayList<String> a = new ArrayList<>(Arrays.asList("todo", "event", "deadline"));
        for (String stringy : a) {
            if (s.equalsIgnoreCase(stringy)) {
                return Commands.ADDTOLIST;
            }
        }
        return null;
    }

    /**
     * This function checks to see what the user wants to do.
     *
     * @param s user's message
     * @param e the echo they have
     * @return formatted String
     *
     */
    public static String validityOfWords(String s, TaskList e) throws InvalidInput, EmptyList {
        s = s.trim();
        // split the statement
        // basically p is the user string in an array
        String[] p = s.split("\\s+");
        Parser pa = new Parser();
        Commands command = pa.checkerOfCommand(p[0].toLowerCase());
        try {
            return command.run(e, p);
        } catch (NullPointerException error) {
            throw new InvalidInput();
        }
    }
}
