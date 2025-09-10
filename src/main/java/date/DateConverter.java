package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exceptions.InvalidDateInput;

/**
 * Class meant to convert the date into a better format.
 *
 * Okay for now.
 */
public class DateConverter {

    protected LocalDate date;

    /**
     * Constructor to create a new date.
     * @param date date that is meant to be converted.
     */
    public DateConverter(String date) throws InvalidDateInput {
        assert date != null : "the date is null";
        try {
            this.date = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new InvalidDateInput();
        }
    }

    /**
     * Returns the error message
     * @return the string formatted
     */
    public String toString() {
        return this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

    }
}
