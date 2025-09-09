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
            // pass the array into the deadline to parse
            public String pass(Arrays p) {
                if (p.length > 1 && Arrays.asList(p).contains("/from")
                        && Arrays.asList(p).contains("/to")) {
                    int indexOfFrom = this.finder(p, "/from");
                    int indexOfTo = this.finder(p, "/to");
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
                    Task event = new Events(description,
                            stringStartingTime, stringEndingTime);
                    taskList.add(event);
                    stringy += event.toString();
                } else {
                    throw new InvalidInput();
                }
                break;
                return "";
            }

        },

        ToDo {
            public String pass(Arrays p) {
                if (p.length > 1) {
                    Task todo = new ToDo(String.join(
                            " ", Arrays.copyOfRange(p, 1, p.length)));
                    taskList.add(todo);
                    stringy += todo.toString();
                } else {
                    throw new EmptyList();
                }
                break;
                return "";
            }
        },

        Event {
            public String pass(Arrays p) {
                if (p.length > 1 && Arrays.asList(p).contains("/by")) {
                    int indexOfBy = this.finder(p, "/by");
                    String task = String.join(" ",
                            Arrays.copyOfRange(p, 1, indexOfBy));
                    DateConverter de = new DateConverter(
                            String.join(" ",
                                    Arrays.copyOfRange(p, indexOfBy + 1, p.length)));
                    String d = de.toString();
                    Task deadline = new Deadlines(task, d);
                    taskList.add(deadline);
                    stringy += deadline.toString();
                } else {
                    throw new InvalidInput();
                }
                break;
            }
        }

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
     * This method adds a task to the taskList.
     * @param s task to be added
     * @return added: task
     */
    public void addToList(String s) throws InvalidInput, EmptyList {
        try {
            this.taskList = slist.load();
            s = s.trim();
            String[] p = s.split("\\s+");
            String stringy = "Got it, I have added this to my list!\n";
            stringy += checkerOfCommand(p[0]).pass(p);
            slist.store(this.taskList);
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        } catch (InvalidDateInput e) {
            System.out.println(e.getMessage());
        } catch (CannotStore e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Find string in an array of words
     * @param array array of words
     * @param term you are searching for
     * @return the index of the word
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
     * This method marks a task as complete.
     * @param i this contains the integer of the arraylist that is marked.
     * @return message
     */
    public String mark(Integer i) {
        try {
            this.taskList = slist.load();
            taskList.get(i - 1).mark();
            slist.store(this.taskList);
            return "Well done! I have marked this "
                    + "particular task as done: \n" + taskList.get(i - 1).toString();
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        } catch (CannotStore e) {
            System.out.println(e.getMessage());
        }
        return "";
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
    public int lengthOfList() {
        return this.lengthOfList;
    }
}

