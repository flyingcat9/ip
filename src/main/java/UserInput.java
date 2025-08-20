import java.util.Scanner;


public class UserInput {

    public static void starting() {
        System.out.println("Hello! I'm Jocelyn. What can I do for you?");
        Scanner object = new Scanner(System.in);
        String userWords = object.nextLine();
        Echo text = new Echo();
        while (!userWords.equals("bye")) {
            System.out.print(validityOfWords(userWords, text));
            object = new Scanner(System.in);
            userWords = object.nextLine();
        }
        System.out.println("Bye, I hope to see you soon!");

    }

    public static String validityOfWords(String s, Echo e) {
        String t = "";
        if (s.equals("list")) {
            t += "Here are the tasks in your list: \n";
            t += e.printList();
        } else if (s.contains("unmark")) {
            t += e.unmark(Integer.valueOf(s.substring(7))) + "\n";
        } else if (s.contains("mark")) {
            t += e.mark(Integer.valueOf(s.substring(5))) + "\n";
        }
        else {
            return e.addToList(s);
        }
        return t;

    }
}

