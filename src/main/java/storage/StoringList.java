package storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

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
     * In charge of loading the file into the taskList.
     * @return the updated ArrayList
     */
    public ArrayList<Task> load() {
        File directory = new File("theData");
        ArrayList<Task> theList = new ArrayList<>();
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
                if (t.contains("[ToDo]")) {
                    String[] p = t.split(" ");
                    boolean finished = p[1].equals("[O]") ? false : true;
                    theList.add(new ToDo(String.join(" ", Arrays.copyOfRange(p, 2, p.length)), finished));
                } else if (t.contains("[D]")) {
                    String[] p = t.split(" ");
                    int indexOfBy = this.finder(p, "(by:");
                    boolean finished = p[1].equals("[O]") ? false : true;
                    theList.add(new Deadlines(String.join(" ", Arrays.copyOfRange(p, 2, indexOfBy)),
                                String.join(" ", Arrays.copyOfRange(p, indexOfBy + 1, p.length)), finished));

                } else if (t.contains("[Events]")) {
                    String[] p = t.split(" ");
                    int indexOfFrom = this.finder(p, "(from:");
                    int indexOfTo = this.finder(p, "to:");
                    boolean finished = p[1].equals("[O]") ? false : true;
                    theList.add(new Events(String.join(" ", Arrays.copyOfRange(p, 2, indexOfFrom)),
                            String.join(" ", Arrays.copyOfRange(p, indexOfFrom + 1, indexOfTo)),
                            String.join(" ", Arrays.copyOfRange(p, indexOfTo + 1, p.length)), finished));
                }
            }
        } catch(IOException ee){
                System.out.println(ee.getMessage());
        }
        return theList;

    }

    /**
     * Finds the string in the array
     * @param array array of words
     * @param term word you are looking for
     * @return index of the string
     */
    public int finder(String[] array, String term) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(term)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Storing the updated list into the .txt file
     * @param t the ArrayList<task.Task> you are updating
     */

    public void store(ArrayList<Task> t) {
        try {
            File directory = new File("theData");
            File theFinalFile = new File(directory, "Jocelyn.txt");
            FileWriter a = new FileWriter(theFinalFile, false);
            for (Task theTask : t) {
                a.write(theTask.toString() + "\n");
            }
            a.close();
        } catch (IOException e) {
                System.out.println(e.getMessage());
            }

    }
}



