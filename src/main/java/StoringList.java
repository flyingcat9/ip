import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 * In charge of loading and saving things in the file.
 *
 */

public class StoringList {


    public String load() {
        return "";
    }


    public void store(ArrayList<Task> t) {
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
        try {
            FileWriter a = new FileWriter(theFile);
            for (Task theTask : t) {
                a.write(theTask.toString() + "/n");
            }
            a.close();
        } catch (IOException e) {
                System.out.println(e.getMessage());
            }

    }
}



