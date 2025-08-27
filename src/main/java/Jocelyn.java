/**
 * This is the main method of the ChatBot.
 *
 * @author: Ong Li Min
 */

import java.util.Scanner;

public class Jocelyn {

    /**
     * Main chat bot.
     * @param args the main method
     */
    public static void main(String[] args) {
        StoringList a = new StoringList();
        a.load();
        UserInput u = new UserInput();
        UserInput.starting();
    }
}
