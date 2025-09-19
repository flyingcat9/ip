package chatbot;

import exceptions.CannotLoad;
import parse.Parser;
import storage.StoringList;

/**
 * This is the main method of the ChatBot.
 * Okay for now.
 *
 * @author: Ong Li Min
 */

public class Jocelyn {

    /**
     * Main chat bot.
     */
    public static void main(String[] args) {
        StoringList a = new StoringList();
        try {
            a.load();
            Parser p = new Parser();

        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * introduces the user when they log into the gui
     * @return String
     */
    public String introduce() {
        return "Woof, woof. My name is Jocelyn. "
                + "Please feel free to type in any tasks you want!";
    }
}
