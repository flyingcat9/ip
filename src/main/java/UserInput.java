import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class takes user input and
 * manages the interactions with the user.
 *
 * @author Ong Li Min
 */

public class UserInput {

    /**
     * This method maintains the main function and the starting
     * phrases from the chatbot.
     */
    public static void starting() {
        System.out.println("Hello! I'm Jocelyn. What can I do for you?");
        Scanner object = new Scanner(System.in);
        String userWords = object.nextLine();
        TaskList text = new TaskList();
        while (!userWords.equals("bye")) {
            System.out.print(validityOfWords(userWords, text));
            object = new Scanner(System.in);
            try {
                userWords = object.nextLine();
            } catch (NoSuchElementException error) {
                System.out.println(error);
            }
        }
        System.out.println("Bye, I hope to see you soon!");
    }

    /**
     * This function checks to see what the user wants to do.
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
        }else {
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





