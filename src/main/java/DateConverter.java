import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Class meant to convert the date into a better format.
 */
public class DateConverter{

    protected LocalDate date;


    /**
     * Constructor to create a new date.
     * @param date date that is meant to be converted.
     */
    public DateConverter(String date) {
        try {
            this.date = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            System.out.println("Please format your date properly");
        }
    }

<<<<<<< HEAD
    /**
     * Returns the error message
     * @return the string formatted
     */
=======

>>>>>>> branch-A-CodingStandard
    public String toString() {
        return this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

    }
}