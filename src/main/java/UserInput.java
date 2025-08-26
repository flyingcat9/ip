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
            Input i = new Input();
            System.out.print(i.validityOfWords(userWords, text));
            object = new Scanner(System.in);
            try {
                userWords = object.nextLine();
            } catch (NoSuchElementException error) {
                System.out.println(error);
            }
        }
        System.out.println("Bye, I hope to see you soon!");
    }


}





