import java.util.Scanner;


public class UserInput {

    public static void starting() {
        System.out.println("Hello! I'm Jocelyn. What can I do for you?");
        Scanner object = new Scanner(System.in);
        String userWords = object.nextLine();
        while (!userWords.equals("bye")) {
            Echo.echo(userWords);
            object = new Scanner(System.in);
            userWords = object.nextLine();
        }
        System.out.println("Bye, I hope to see you soon!");

    }
}