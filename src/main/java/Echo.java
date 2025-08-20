import java.util.ArrayList;

public class Echo {

    protected ArrayList<Task> taskList = new ArrayList<>();

    public String addToList(String s) {
        Task t = new Task(s);
        taskList.add(t);
        return "added: " + s + "\n";
    }

    public String mark(Integer i) {
        taskList.get(i-1).mark();
        return "Well done! I have marked this particular task as done: \n" + taskList.get(i-1).toString();
    }

    public String unmark(Integer i) {
        taskList.get(i-1).unMark();
        return "Okay, I have marked this particular task as not done yet: \n" + taskList.get(i-1).toString();
    }


    public String printList() {
        String line = "";
        for (int i = 0; i < taskList.size(); i++ ) {
            line += String.valueOf(i+1) + "." +  taskList.get(i).toString() + "\n";
        }
        return line;
    }
}