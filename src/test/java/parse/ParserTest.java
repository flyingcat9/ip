package parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import date.DateConverter;
import exceptions.EventTimelineInvalid;
import exceptions.InvalidDateInput;
import exceptions.InvalidInput;
import storetasks.TaskList;

public class ParserTest {

    @Test
    public void blankSpace() throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            String actual = t.validityOfWords("", e);
            assertEquals("", actual);
        } catch (InvalidInput e) {
            String expectedErrorOutput = "The input is invalid.";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }

    @Test
    public void invalidInput() throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            e.addToList("deadline eat potates /by 2025-04-03");
            e.addToList("event eat lunch /from 2025-04-03 /to 2025-04-05");
            String actual = t.validityOfWords("hiiiiiii", e);
            assertEquals("", actual);
        } catch (InvalidInput e) {
            String expectedErrorOutput = "The input is invalid.";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }

    @Test
    public void invalidEventTime() throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            e.addToList("deadline eat potates /by 2025-04-03");
            e.addToList("event eat lunch /from 2025-04-03 /to 2025-04-05");
            String actual = t.validityOfWords("event eat lunch /from 2025-04-03 /to 2025-04-05", e);
            assertEquals("", actual);
        } catch (EventTimelineInvalid e) {
            String expectedErrorOutput = "Your starting date is after your ending date";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }

    @Test
    public void noDeeadlineProvided() throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            e.addToList("deadline eat potates /by 2025-04-03");
            e.addToList("event eat lunch /from 2025-04-03 /to 2025-04-02");
            String actual = t.validityOfWords("deadline do CS2100 homework", e);
            assertEquals("", actual);
        } catch (EventTimelineInvalid e) {
            String expectedErrorOutput = "Your starting date is after your ending date";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }

    @Test
    public void noEndingTimeForEvent() throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            e.addToList("deadline eat potates /by 2025-04-03");
            e.addToList("event eat lunch /from 2025-04-03 /to 2025-04-02");
            String actual = t.validityOfWords("deadline do CS2100 homework", e);
            assertEquals("", actual);
        } catch (EventTimelineInvalid e) {
            String expectedErrorOutput = "Your starting date is after your ending date";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }

    @Test
    public void addingTodoObject () throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            e.addToList("deadline eat potates /by 2025-04-03");
            e.addToList("event eat lunch /from 2025-04-03 /to 2025-04-02");
            String actual = t.validityOfWords("deadline do CS2100 homework", e);
            assertEquals("", actual);
        } catch (EventTimelineInvalid e) {
            String expectedErrorOutput = "Your starting date is after your ending date";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }

    @Test
    public void addingDeadlineObject () throws Exception {
        try {
            Parser t = new Parser();
            TaskList e = new TaskList();
            e.addToList("todo happy birthday");
            e.addToList("deadline eat potates /by 2025-04-03");
            e.addToList("event eat lunch /from 2025-04-03 /to 2025-04-02");
            String actual = t.validityOfWords("deadline do CS2100 homework", e);
            assertEquals("", actual);
        } catch (EventTimelineInvalid e) {
            String expectedErrorOutput = "Your starting date is after your ending date";
            assertEquals(e.getMessage(), expectedErrorOutput);
        }
    }



}
