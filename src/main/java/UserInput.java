import java.util.Scanner;


public class UserInput {

    public static void starting() {
        System.out.println("Hello! I'm Jocelyn. What can I do for you?");
        Scanner object = new Scanner(System.in);
        String userWords = object.nextLine();
        Echo text = new Echo();
        while (!userWords.equals("bye")) {
            validityOfWords(userWords, text);
            object = new Scanner(System.in);
            userWords = object.nextLine();
        }
        System.out.println("Bye, I hope to see you soon!");

    }

    public static void validityOfWords(String s, Echo e) {
        if (s.equals("list")) {
            e.printList();
        } else {
            e.addToList(s);
        }
    }
}

