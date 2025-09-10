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
}
