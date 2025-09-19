package storetasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import exceptions.CannotLoad;
import exceptions.CannotStore;
import exceptions.DuplicationError;
import exceptions.EmptyList;
import exceptions.EventTimelineInvalid;
import exceptions.InvalidDateInput;
import exceptions.InvalidElementInList;
import exceptions.InvalidInput;
import exceptions.NoDeadlineProvided;
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
            public Task pass(ArrayList<String> p) throws InvalidDateInput,
                    InvalidInput, NoDeadlineProvided, EventTimelineInvalid, InvalidElementInList {
                ArrayList<String> tags = new ArrayList<>();
                ArrayList<String> descriptWithoutTags = new ArrayList<>();
                for (int i = 0; i < p.size(); i++) {
                    if (p.get(i).contains("#")) {
                        tags.add(p.get(i));
                    } else {
                        descriptWithoutTags.add(p.get(i));
                    }
                }
                int indexOfBy = finder(descriptWithoutTags, "/by");
                if (indexOfBy == -1 || indexOfBy + 1 >= descriptWithoutTags.size()) {
                    throw new NoDeadlineProvided();
                }
                String task = String.join(" ",
                        descriptWithoutTags.subList(1, indexOfBy));
                String deadline = String.join(" ",
                                    descriptWithoutTags.subList(indexOfBy + 1,
                                            descriptWithoutTags.size()));
                return new Deadlines(task, deadline, false, tags);
            }

        },

        // assumed to only get a todo object
        ToDo {
            /**
             * adds a new todo object
             * @param p the user string split as an arraylist
             * @return the todo object
             * @throws InvalidDateInput the date format is invalid
             * @throws InvalidInput the input is invalid
             */
            public Task pass(ArrayList<String> p) throws InvalidDateInput,
                    InvalidInput, NoDeadlineProvided, EventTimelineInvalid,
                    InvalidElementInList {
                ArrayList<String> tags = new ArrayList<>();
                ArrayList<String> descriptWithoutTags = new ArrayList<>();
                p.remove(0);
                for (int i = 0; i < p.size(); i++) {
                    if (p.get(i).contains("#")) {
                        tags.add(p.get(i));
                    } else {
                        descriptWithoutTags.add(p.get(i));
                    }
                }
                return new ToDo(String.join(" ",
                        descriptWithoutTags), false, tags);
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
            public Task pass(ArrayList<String> p) throws InvalidDateInput,
                    InvalidInput, NoDeadlineProvided, EventTimelineInvalid,
                    InvalidElementInList {
                ArrayList<String> tags = new ArrayList<>(); // doing the tagging, might do a subfn later
                ArrayList<String> descriptWithoutTags = new ArrayList<>();
                p.remove(0);
                for (int i = 0; i < p.size(); i++) {
                    if (p.get(i).contains("#")) {
                        tags.add(p.get(i));
                    } else {
                        descriptWithoutTags.add(p.get(i));
                    }
                }
                int indexOfFrom = finder(descriptWithoutTags, "/from");
                int indexOfTo = finder(descriptWithoutTags, "/to");
                String description = String.join(" ",
                        descriptWithoutTags.subList(0, indexOfFrom));
                String startingTime = String.join(" ",
                        descriptWithoutTags.subList(indexOfFrom + 1, indexOfTo)).trim();
                String endingTime = String.join(" ",
                        descriptWithoutTags.subList(indexOfTo + 1, descriptWithoutTags.size())).trim();
                return new Events(description,
                        startingTime, endingTime, false, tags);
            }

        };

        /**
         * Find string in an array of words
         * @param array array of words
         * @param term you are searching for
         * @return the index of the word
         */
        public static int finder(ArrayList<String> array, String term) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).equals(term)) {
                    return i;
                }
            }
            return -1;
        }
        public abstract Task pass(ArrayList<String> p) throws InvalidDateInput,
                InvalidInput, NoDeadlineProvided, EventTimelineInvalid, InvalidElementInList;

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
     * Used AI for guidance on the easiest method to preserve duplicates.
     * @param s the thing to be added
     * @return the string related to adding
     * @throws InvalidDateInput date input invalid
     * @throws InvalidInput input invalid
     * @throws EmptyList list is empty
     * @throws CannotLoad cannot load
     * @throws CannotStore cannot store
     */
    public String addToList(String s) throws EventTimelineInvalid,
            InvalidDateInput, InvalidInput, EmptyList,
            CannotLoad, CannotStore, DuplicationError, NoDeadlineProvided,
            InvalidElementInList, EventTimelineInvalid {
        this.taskList = slist.load();
        s = s.trim();
        String[] p = s.split("\\s+");
        String stringy = "Got it, I have added this to my list!\n";
        ArrayList<String> a = new ArrayList<>(Arrays.asList(p));
        Task newObject = checkerOfCommand(p[0]).pass(a);
        Set<Task> theSet = new LinkedHashSet<>(taskList);
        boolean b = theSet.add(newObject);
        if (!b) {
            throw new DuplicationError();
        }
        taskList = new ArrayList<Task>(theSet);
        slist.store(this.taskList);
        return stringy + newObject.toString() + "\nNow, you have " + taskList.size()
                + " objects in your list right now!";
    }



    /**
     * This method marks a task as complete.
     * @param i this contains the integer of the arraylist that is marked.
     * @return message
     */
    public String mark(Integer i) throws CannotLoad, CannotStore,
            InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        this.taskList = slist.load();
        assert !this.taskList.isEmpty() : "the tasklist is empty";
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
    public String unmark(Integer i) throws InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
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
    public String printList() throws InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
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
    public String delete(Integer i) throws InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        try {
            this.taskList = slist.load();
            String stringy = this.taskList.get(i - 1).toString();
            this.taskList.remove(i - 1);
            slist.store(this.taskList);
            return "Noted. I have removed the current task!\n" + stringy + "\nNow, you have "
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
    public String find(String s) throws InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        try {
            this.taskList = slist.load();
            String ongoingString = "";
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).toString().contains(s)) {
                    ongoingString += taskList.get(i).toString() + "\n";
                }
            }
            if (ongoingString.equals("")) {
                return "There are no matches.";
            }
            return "Here are the matching tasks in your lists:\n" + ongoingString;
        } catch (CannotLoad e) {
            System.out.println(e.getMessage());
        }
        return "There are no matches.";
    }

    /**
     * Returns the final task length list.
     *
     * @return length of the list
     */
    public int lengthOfList() throws CannotLoad, InvalidElementInList,
            InvalidDateInput, EventTimelineInvalid {
        taskList = slist.load();
        this.lengthOfList = taskList.size();
        return this.lengthOfList;
    }

    /**
     * @param s the statement
     * @return the tags
     */
    public String addTag(String[] s) throws CannotLoad, CannotStore,
            InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        taskList = slist.load();
        int number = 0;
        number = Integer.parseInt(s[1]) - 1;
        if (number >= taskList.size() || number < 0) {
            throw new InvalidElementInList();
        }
        taskList.get(number).addTags(Arrays.copyOfRange(s, 2, s.length));
        slist.store(taskList);
        return "Got it, I have added the tags to task " + (number + 1) + ".\n This is"
                + " the current element:\n " + taskList.get(number).toString();
    }

    /**
     * the ablity to delete a tag
     * @param s take in the tags
     * @return the tags
     * @throws CannotLoad can not load content
     * @throws CannotStore can not store content
     * @throws InvalidElementInList element is invalid
     */
    public String deleteTag(String[] s) throws CannotLoad, CannotStore,
            InvalidElementInList, InvalidDateInput, EventTimelineInvalid {
        taskList = slist.load();
        int number = 0;
        number = Integer.parseInt(s[1]) - 1;
        if (number >= taskList.size() || number < 0) {
            throw new InvalidElementInList();
        }
        taskList.get(number).removeTags(Arrays.copyOfRange(s, 2, s.length));
        slist.store(taskList);
        return "Got it, I have remove the tags for task " + (number + 1) + ".\n This is"
                + " the current element:\n " + taskList.get(number).toString();
    }


}

