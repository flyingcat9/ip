package chatbot;

import exceptions.CannotLoad;
import parse.Parser;
import storage.StoringList;
import userinteraction.UserInput;

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
}
