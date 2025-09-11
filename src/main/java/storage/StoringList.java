package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
                ArrayList<String> arraylist = new ArrayList<>(Arrays.asList(p));
                assert p.length >= 3 : "the input of the task is invalid";
                boolean finished = arraylist.get(1).contains("[X]");
                String description = "";
                String deadline = "";
                String startingTime = "";
                String endingTime = "";
                ArrayList<String> tags = new ArrayList<>();
                for (int i = 2; i < arraylist.size(); i++ ) {
                    if (arraylist.get(i).contains("#")) {
                        tags.add(arraylist.get(i));
                    } else if (arraylist.get(i).contains("\\by")) {
                        deadline = arraylist.get(i).substring(3);
                    } else if (arraylist.get(i).contains("\\from")) {
                        startingTime = arraylist.get(i).substring(5);
                    } else if (arraylist.get(i).contains("\\to")) {
                        endingTime = arraylist.get(i).substring(3);
                    } else {
                        description += arraylist.get(i);
                    }
                }
                Task specific = null;
                if (arraylist.get(0).contains("[ToDo]")) {
                    specific = new ToDo(description, finished, tags);
                } else if (arraylist.get(0).contains("[Deadline]")) {
                    specific = new Deadlines(description, deadline, finished, tags);
                } else if (arraylist.get(0).contains("[Events]")) {
                    specific = new Events(description, startingTime,
                            endingTime, finished, tags);
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




