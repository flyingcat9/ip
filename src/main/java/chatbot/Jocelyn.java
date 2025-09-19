package chatbot;

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
     * Creates the main chatbot Jocelyn.
     * This loads the document into the tasklist so that it is
     * updated.
     */
    public Jocelyn() {
        StoringList a = new StoringList();
        try {
            a.load();
            Parser p = new Parser();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the greeting message.
     * Introduces the bot to the user when they log into the GUI.
     *
     * @return Introduction String.
     */
    public String introduce() {
        return "Woof, woof. My name is Jocelyn. "
                + "Please feel free to type in any tasks you want!";
    }
}
