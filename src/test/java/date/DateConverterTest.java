package date;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import exceptions.InvalidDateInput;

public class DateConverterTest {

    @Test
    public void testDate() throws InvalidDateInput {
        DateConverter t = new DateConverter("2025-08-20");
        String actual = t.toString();
        assertEquals("Aug 20 2025", actual);
    }

    @Test
    public void testDateTwo() throws InvalidDateInput {
        DateConverter t = new DateConverter("2020-07-20");
        String actual = t.toString();
        assertEquals("Jul 20 2020", actual);
    }

    @Test
    public void testDateThree() throws InvalidDateInput {
        DateConverter t = new DateConverter("2027-10-20");
        String actual = t.toString();
        assertEquals("Oct 20 2027", actual);
    }

    // Solution below adapted from
    // https://stackoverflow.com/questions/10148101/junit-testing-assertequals-for-exception
    @Test
    public void nonexistentDate() throws InvalidDateInput {
        try {
            DateConverter t = new DateConverter("2025-02-30");
            String actual = t.toString();
            assertEquals("Oct 20 2027", actual);
        } catch (InvalidDateInput e) {
            String expectedErrorOutput = "Invalid date input, please format as YYYY-DD-MM";
            assertEquals(expectedErrorOutput, e.getMessage());
        }
    }

    @Test
    public void noDateSpecified() throws InvalidDateInput {
        try {
            DateConverter t = new DateConverter("2025-02-30");
            String actual = t.toString();
            assertEquals("", actual);
        } catch (InvalidDateInput e) {
            String expectedErrorOutput = "Invalid date input, please format as YYYY-DD-MM";
            assertEquals(expectedErrorOutput, e.getMessage());
        }
    }

    @Test
    public void invalidYear() throws InvalidDateInput {
        try {
            DateConverter t = new DateConverter("20-02-30");
            String actual = t.toString();
            assertEquals("", actual);
        } catch (InvalidDateInput e) {
            String expectedErrorOutput = "Invalid date input, please format as YYYY-DD-MM";
            assertEquals(expectedErrorOutput, e.getMessage());
        }
    }

    @Test
    public void invalidMonth() throws InvalidDateInput {
        try {
            DateConverter t = new DateConverter("2005-13-30");
            String actual = t.toString();
            assertEquals("", actual);
        } catch (InvalidDateInput e) {
            String expectedErrorOutput = "Invalid date input, please format as YYYY-DD-MM";
            assertEquals(expectedErrorOutput, e.getMessage());
        }
    }

    @Test
    public void invalidDate() throws InvalidDateInput {
        try {
            DateConverter t = new DateConverter("2005-13-33");
            String actual = t.toString();
            assertEquals("", actual);
        } catch (InvalidDateInput e) {
            String expectedErrorOutput = "Invalid date input, please format as YYYY-DD-MM";
            assertEquals(expectedErrorOutput, e.getMessage());
        }
    }
}
