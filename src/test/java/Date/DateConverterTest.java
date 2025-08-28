package Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateConverterTest {

    @Test
    public void testDate() {
        DateConverter t = new DateConverter("2025-08-20");
        String actual = t.toString();
        assertEquals("Aug 20 2025", actual);
    }

    @Test
    public void testDateTwo() {
        DateConverter t = new DateConverter("2020-07-20");
        String actual = t.toString();
        assertEquals("Jul 20 2020", actual);
    }

    @Test
    public void testDateThree() {
        DateConverter t = new DateConverter("2027-10-20");
        String actual = t.toString();
        assertEquals("Oct 20 2027", actual);
    }


}