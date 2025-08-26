/**
 * Come back later.
 */


public class Input {
    /**
     This function checks to see what the user wants to do.
     *
     * @param s user's message
     * @param e the echo they have
     * @return formatted String
     */
    public static String validityOfWords(String s, TaskList e) {
        String t = "";
        if (s.equals("list")) {
            t += "Here are the tasks in your list: \n";
            t += e.printList();
        } else if (s.contains("unmark")) {
            t += e.unmark(Integer.valueOf(s.substring(7))) + "\n";
        } else if (s.contains("mark")) {
            t += e.mark(Integer.valueOf(s.substring(5))) + "\n";
        } else if (s.contains("delete")) {
            t += e.delete(Integer.valueOf(s.substring(s.indexOf("delete") + 7))) + "\n";
        } else {
            try {
                t += e.addToList(s);
            } catch (InvalidInput error) {
                System.out.println(error);
            } catch (EmptyList ee) {
                System.out.println(ee);
            }
        }
        return t;
    }
}