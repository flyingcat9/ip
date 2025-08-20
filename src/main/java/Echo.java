import java.util.ArrayList;

public class Echo {

    protected ArrayList<String> taskList = new ArrayList<>();

    public void addToList(String s) {
        taskList.add(s);
        System.out.print("added: ");
        echo(s);
    }


    public static void echo(String word) {
        System.out.println(word);
    }

    public void printList() {
        for (int i = 0; i < taskList.size(); i++ ) {
            System.out.println(String.valueOf(i+1) + ". " +  taskList.get(i));
        }
    }
}