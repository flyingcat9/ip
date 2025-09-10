package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CannotLoad;
import exceptions.CannotStore;
import task.Task;
import task.specific.Deadlines;
import task.specific.Events;
import task.specific.ToDo;

/**
 * In charge of loading and saving things in the file.
 *
 */

public class StoringList {

    /**
     * In charge of loading the list
     * @return the final updated list from the file
     * @throws CannotLoad cannot load the list
     */
    public ArrayList<Task> load() throws CannotLoad {
        File directory = new File("theData");
        ArrayList<Task> theList = new ArrayList<>();
        // make directory if it does not exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File theFile = new File(directory, "Jocelyn.txt");
        if (!theFile.exists()) {
            try {
                theFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Scanner nextLiner = new Scanner(theFile);
            while (nextLiner.hasNextLine()) {
                String t = nextLiner.nextLine();
                String[] p = t.split("\"\"");
                boolean finished = p[1].contains("[X]");
                String description = p[2];
                Task specific = null;
                if (p[0].contains("[ToDo]")) {
                    specific = new ToDo(description, finished);
                } else if (p[0].contains("[Deadline]")) {
                    specific = new Deadlines(description, p[3], finished);
                } else if (p[0].contains("[Events]")) {
                    specific = (new Events(description, p[3], p[4], finished));
                } else {
                    throw new CannotLoad();
                }
                theList.add(specific);
            }
        } catch (IOException ee) {
            throw new CannotLoad();
        }
        return theList;
    }

    /**
     * Storing the updated list into the .txt file
     * @param t the ArrayList you are updating
     */
    public void store(ArrayList<Task> t) throws CannotStore {
        try {
            File directory = new File("theData");
            File theFinalFile = new File(directory, "Jocelyn.txt");
            FileWriter a = new FileWriter(theFinalFile, false);
            for (Task theTask : t) {
                a.write(theTask.store() + "\n");
            }
            a.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}




