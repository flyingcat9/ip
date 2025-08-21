/**
 * This class is in charge of maintaining the task list by adding and
 * removing tasks.
 *
 * @author: Ong Li Min
 */

import java.util.ArrayList;

public class TaskList {

    enum TaskType{
        TODO,
        DEADLINES,
        EVENTS
    }

    protected ArrayList<Task> taskList = new ArrayList<>();

    /**
     * This method adds a task to the taskList.
     * @param s task to be added
     * @return added: task
     */
    public String addToList(String s) {
        Task t = new Task(s);
        taskList.add(t);
        return "added: " + s + "\n";
    }

    /**
     * This method marks a task as complete.
     * @param i this contains the integer of the arraylist that is marked.
     * @return message
     */
    public String mark(Integer i) {
        taskList.get(i-1).mark();
        return "Well done! I have marked this particular task as done: \n" + taskList.get(i-1).toString();
    }

    /**
     * This method marks a task as incomplete
     * @param i this contains the integer of the arraylist marked
     * @return message to uesr
     */
    public String unmark(Integer i) {
        taskList.get(i-1).unMark();
        return "Okay, I have marked this particular task as not done yet: \n" + taskList.get(i-1).toString();
    }

    /**
     * This prints out the list in its entirety
     * @return the list printed out and formatted nicely.
     */
    public String printList() {
        String line = "";
        for (int i = 0; i < taskList.size(); i++ ) {
            line += String.valueOf(i+1) + "." +  taskList.get(i).toString() + "\n";
        }
        return line;
    }
}