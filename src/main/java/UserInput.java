import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class takes user input and
 * manages the interactions with the user.
 *
 * @author Ong Li Min
 */

/** just create the scanner once.
 * normalize input
 * split into more functions
 */

public class UserInput {

    /**
     * This method maintains the main function and the starting
     * phrases from the chatbot.
     */
    public static void starting() {
        UserInput uI = new UserInput();
        Scanner object = new Scanner(System.in);
        System.out.println(uI.greet());
        String userWords = object.nextLine();
        TaskList text = new TaskList();
        Parser i = new Parser();
        while (!uI.exitingTheLoop(userWords)) {
            try {
                String s = i.validityOfWords(userWords, text);
                System.out.println(s);
            } catch (InvalidInput e) {
                System.out.println(e);
            } catch (EmptyList t) {
                System.out.println(t);
            }
            userWords = object.nextLine();
        }
        System.out.println(uI.ending());
    }

    public String greet() {
        return "Hello! I'm Jocelyn. What can I do for you?";
    }

    public String ending() {
        return "Bye, I hope to see you soon!";
    }

    public boolean exitingTheLoop(String input) {
        if (input == null || input == "" || input == "bye") {
            return true;
        }
        return false;
    }


}





