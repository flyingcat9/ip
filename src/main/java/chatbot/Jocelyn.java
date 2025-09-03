package chatbot;

import storage.StoringList;
import userinteraction.UserInput;

/**
 * This is the main method of the ChatBot.
 *
 * @author: Ong Li Min
 */

public class Jocelyn {

    /**
     * Main chat bot.
     */
    public static void main(String[] args) {
        StoringList a = new StoringList();
        a.load();
        UserInput u = new UserInput();
        UserInput.starting();
    }
}
