package chatbot;

import exceptions.CannotLoad;
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
            UserInput u = new UserInput();
            UserInput.starting();
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        }
    }
}
