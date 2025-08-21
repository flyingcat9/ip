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
    public String addToList(String s) throws InvalidInput, EmptyList {
        Task t = null;
        if (s.contains("todo")) {
            if (s.indexOf("todo") + 4 < s.length()) {
                t = new ToDo(s.substring(s.indexOf("todo") + 4).trim());
            } else {
                throw new EmptyList();
            }
        } else if (s.contains("/by")) {
            if (s.indexOf("/by") + 3 < s.length()) {
                t = new Deadlines(s.substring(0, s.indexOf("/by")), s.substring(s.indexOf("/by") + 3));
            } else {
                throw new EmptyList();
            }
        } else if (s.contains("/from") || s.contains("/to")) {
            if (s.indexOf("/by") + 3 < s.length() && s.indexOf("/from") + 3 < s.length())
                t = new Events(s.substring(0, s.indexOf("/from")), s.substring(s.indexOf("/from") + 5,
                        s.indexOf("/to")), s.substring(s.indexOf("/to") + 3));
        }
        if (t != null) {
           taskList.add(t);
       }  else {
           throw new InvalidInput();
       }
       return "added: " + t.toString() + "\n";
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

    /**
     * This deletes an item from the list.
     *
     */
    public String delete(Integer i) {
        String stringy = taskList.get(i).toString();
        taskList.remove(i - 1);
        return "Noted. I have removed the current task!" + stringy + "Now, you have " +
                taskList.size() + " items in this list.";
    }
}