import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * In charge of loading and saving things in the file.
 *
 */

public class StoringList {


    public String load() {
        File directory = new File("theData");
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
        String s = "";
        try {
            Scanner nextLiner = new Scanner(theFile);
            while (nextLiner.hasNextLine()) {
                s += nextLiner.nextLine() + "/n";
            }
        } catch(IOException ee){
                System.out.println(ee.getMessage());
        }
        return s;

    }


    public void store(ArrayList<Task> t) {
        try {
            File directory = new File("theData");
            File theFinalFile = new File(directory, "Jocelyn.txt");
            FileWriter a = new FileWriter(theFinalFile);
            for (Task theTask : t) {
                a.write(theTask.toString() + "/n");
            }
            a.close();
        } catch (IOException e) {
                System.out.println(e.getMessage());
            }

    }
}



