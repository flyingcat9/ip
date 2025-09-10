package storetasks;


import java.util.ArrayList;
import java.util.Arrays;

import date.DateConverter;
import exceptions.CannotLoad;
import exceptions.CannotStore;
import exceptions.EmptyList;
import exceptions.InvalidDateInput;
import exceptions.InvalidInput;
import storage.StoringList;
import task.Task;
import task.specific.Deadlines;
import task.specific.Events;
import task.specific.ToDo;

/**
 * This class is in charge of maintaining the task list by adding and
 * removing tasks.
 *
 * @author: Ong Li Min
 */

public class TaskList {

    private StoringList slist = new StoringList();
    private ArrayList<Task> taskList = new ArrayList<>();
    private int lengthOfList = taskList.size();

    /**
     * Enum to split the different types of tasks.
     */
    public enum TaskTypes {

        Deadline {
            /**
             * creates a new deadline
             * @param p passes in the string
             * @return the new deadline
             * @throws InvalidDateInput date format is invalid
             * @throws InvalidInput the input is invalid
             */
            public Task pass(String ... p) throws InvalidDateInput, InvalidInput {
                int indexOfBy = finder(p, "/by");
                String task = String.join(" ",
                        Arrays.copyOfRange(p, 1, indexOfBy));
                DateConverter de = new DateConverter(
                            String.join(" ",
                                    Arrays.copyOfRange(p, indexOfBy + 1, p.length)));
                String d = de.toString();
                return new Deadlines(task, d);
            }

        },

        // assumed to only get a todo object
        ToDo {
            /**
             * adds a new todo object
             * @param p the user string
             * @return the todo object
             * @throws InvalidDateInput the date format is invalid
             * @throws InvalidInput the input is invalid
             */
            public Task pass(String ... p) throws InvalidDateInput, InvalidInput {
                return new ToDo(String.join(" ",
                        Arrays.copyOfRange(p, 1, p.length)), false);
            }
        },

        // assumed to only get events
        Event {
            /**
             * Passes in an event.
             * @param p the string comment
             * @return the event
             * @throws InvalidDateInput date format is invalid
             * @throws InvalidInput the input is invalid
             */
            public Task pass(String ... p) throws InvalidDateInput, InvalidInput {
                int indexOfFrom = finder(p, "/from");
                int indexOfTo = finder(p, "/to");
                String description = String.join(" ",
                        Arrays.copyOfRange(p, 1, indexOfFrom));
                String startingTime = String.join(" ",
                        Arrays.copyOfRange(p, indexOfFrom + 1, indexOfTo));
                DateConverter st = new DateConverter(startingTime);
                String stringStartingTime = st.toString();
                String endingTime = String.join(" ",
                        Arrays.copyOfRange(p, indexOfTo + 1, p.length));
                DateConverter en = new DateConverter(endingTime);
                String stringEndingTime = en.toString();
                return new Events(description,
                            stringStartingTime, stringEndingTime);
            }

        };

        /**
         * Find string in an array of words
         * @param array array of words
         * @param term you are searching for
         * @return the index of the word
         */
        public static int finder(String[] array, String term) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(term)) {
                    return i;
                }
            }
            return -1;
        }
        public abstract Task pass(String ... p) throws InvalidInput, InvalidDateInput;

    }

    /**
     * Checks and validates type of task.
     * @param s type of task to be added
     * @return the task
     */
    public TaskTypes checkerOfCommand(String s) {
        for (TaskTypes c: TaskTypes.values()) {
            if (s.equalsIgnoreCase(c.name())) {
                return c;
            }
        }
        return null;
    }


    /**
     * the method to add the task to the list
     * @param s the thing to be added
     * @return the string related to adding
     * @throws InvalidDateInput date input invalid
     * @throws InvalidInput input invalid
     * @throws EmptyList list is empty
     * @throws CannotLoad cannot load
     * @throws CannotStore cannot store
     */
    public String addToList(String s) throws InvalidDateInput, InvalidInput, EmptyList, CannotLoad, CannotStore {
        this.taskList = slist.load();
        s = s.trim();
        String[] p = s.split("\\s+");
        String stringy = "Got it, I have added this to my list!\n";
        Task newObject = checkerOfCommand(p[0]).pass(p);
        this.taskList.add(newObject);
        slist.store(this.taskList);
        return stringy + newObject.toString();
    }



    /**
     * This method marks a task as complete.
     * @param i this contains the integer of the arraylist that is marked.
     * @return message
     */
    public String mark(Integer i) throws CannotLoad, CannotStore {
        this.taskList = slist.load();
        this.taskList.get(i - 1).mark();
        slist.store(this.taskList);
        return "Well done! I have marked this "
                    + "particular task as done: \n" + taskList.get(i - 1).toString();
    }

    /**
     * This method marks a task as incomplete
     * @param i this contains the integer of the arraylist marked
     * @return message to user
     */
    public String unmark(Integer i) {
        try {
            this.taskList = slist.load();
            taskList.get(i - 1).unMark();
            slist.store(this.taskList);
            return "Okay, I have marked this "
                    + "particular task as not done yet: \n" + taskList.get(i - 1).toString();
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        } catch (CannotStore e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    /**
     * This prints out the list in its entirety
     * @return the list printed out and formatted nicely.
     */
    public String printList() {
        try {
            this.taskList = slist.load();
            String line = "";
            line += "Here are the tasks in your list: \n";
            for (int i = 0; i < this.taskList.size(); i++) {
                line += String.valueOf(i + 1) + "." + this.taskList.get(i).toString() + "\n";
            }
            return line;
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    /**
     * This deletes an item from the list.
     *
     * @param i index you are deleting
     * @return String you are returning
     */
    public String delete(Integer i) {
        try {
            this.taskList = slist.load();
            String stringy = this.taskList.get(i - 1).toString();
            this.taskList.remove(i - 1);
            slist.store(this.taskList);
            return "Noted. I have removed the current task!" + stringy + "Now, you have "
                    + this.taskList.size() + " items in this list.";
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        } catch (CannotStore e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    /**
     * Finds the string required throughout the tasks
     * @param s string to be found
     * @return all strings that match
     */
    public String find(String s) {
        try {
            this.taskList = slist.load();
            String ongoingString = "";
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).toString().contains(s)) {
                    ongoingString += taskList.get(i).toString() + "\n";
                }
            }
            return ongoingString;
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    /**
     * Returns the final task length list.
     *
     * @return length of the list
     */
    public int lengthOfList() throws CannotLoad {
        taskList = slist.load();
        this.lengthOfList = taskList.size();
        return this.lengthOfList;
    }
}

